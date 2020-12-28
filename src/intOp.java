import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//clase que se encarga de realizar las operaciones matematicas en el orden adecuado.
public class intOp extends AnasintBaseVisitor<Object>{
    private String stringOp;
    private Map<String,Object> asig;

    private final evaluaExpr evalua = new evaluaExpr();

    //IDEA GENERAL DE FUNCIONAMIENTO:
    //Operaciones: +,-,* -> La más prioritaria es el * -> Se harán dichas operaciones las primeras.
    //Para ello -> Recibimos un String tal que  3*-2+7-4*2.
    //Generamos una lista de sumas -> Esto es una lista formada por los sumandos -> [3*-2,7-4*2]
    //Aplicamos multiplicaciones -> Para ello -> [3*-2,[7,4*2]] -> Aplicamos mult -> [-6,[7,8]] ->
    //Restamos -> [-6,-1] -> Lo que quede se suma -> -7

    public intOp(Anasint.OpIntegerContext ctx,Map<String, Object> asig) {
        //stringOp es el arbol opInteger transformado en una cadena representando una
        //operacion matematica formada unicamente por numeros y operadores.
        stringOp = (String) visit(ctx);
        this.asig = asig;
    }

    public intOp(Anasint.ParentesisOpIntegerContext ctx,Map<String, Object> asig) {
        //stringOp es el arbol opParentesisInteger transformado en una cadena representando una
        //operacion matematica formada unicamente por numeros y operadores.
        stringOp = (String) visit(ctx);
        this.asig = asig;
    }

    public intOp(Anasint.MenosNumContext ctx,Map<String, Object> asig) {
        //stringOp es el arbol opParentesisInteger transformado en una cadena representando una
        //operacion matematica formada unicamente por numeros y operadores.
        stringOp = (String) visit(ctx);
        this.asig = asig;
    }

    public Integer visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx) {
        return (Integer) evalua.visit(ctx);
    }

    public String visitOpInteger(Anasint.OpIntegerContext ctx) {
        return visit(ctx.getChild(0))+ctx.getChild(1).getText()+visit(ctx.getChild(2));
    }

    public String visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx) {
        String r = "("+visit(ctx.getChild(1))+ctx.getChild(2).getText()+visit(ctx.getChild(3))+")";
        return r;
    }

    public Integer visitNum(Anasint.NumContext ctx) {
        return Integer.parseInt(ctx.getText());
    }
    public String visitMenosNum(Anasint.MenosNumContext ctx) {
        return "-" + visit(ctx.expr_integer());
    }

    public Integer visitVarInt(Anasint.VarIntContext ctx) {
        return (Integer) evalua.visit(ctx);
    }

    public Integer resultado() {
        return calcula(reduce(stringOp));
    }

    public String reduce(String intOp) {
        if(intOp.contains("(")) {
            List<String> dentroParentesis = entreParentesis(intOp);
            for(String enParent:dentroParentesis) {
                String sinParent = enParent.substring(1,enParent.length()-1);
                intOp = intOp.replace(enParent, calcula(reduce(sinParent)).toString());
            }
            return intOp;
        } else {
            return intOp;
        }
    }

    public Integer calcula(String aCalc) {
        List<String> sumas =  new ArrayList<>();
        sumas.add(aCalc);
        sumas = parsea(sumas, "+");
        sumas = aplicaMult(sumas);
        return opera(sumas);
    }

    //dado un operador y una cadena de una op. matematica -> Genera una lista de Strings que
    //donde cada string son los sumandos de la op matematica.
    public List<String> parsea(List<String> cads, String elem) {
        List<String> acum = new ArrayList<>();
        for(String cad: cads) {
            if(cad.contains(elem)) {
                String elem2 = escape(elem);
                String[] parts = cad.split(elem2);
                List<String> partsLs = Arrays.asList(parts.clone());
                acum.addAll(partsLs);
            } else {
                acum.add(cad);
            }
        }
        return acum;
    }

    //dada una lista de Strings en el que cada String se muestra un unico numero o una resta
    // -> calcula el valor de cada uno de esos strings y los suma, generando el resultado
    // [1,2-3,5] -> 1+(-1)+5 = 5
    public Integer opera(List<String> sumas) {
        List<Integer> aSumar = sumas.stream().map(n -> resta(n)).collect(Collectors.toList());
        return aSumar.stream().mapToInt(Integer::intValue).sum();
    }

    // resta("3-2") -> Integer(1)
    // también debe identificar la presencia de un número negativo.
    public Integer resta(String resta) {
        if(resta.contains("-")) {
            String[] aRestar = resta.split("\\-");
            Integer res = aRestar[0].length()==0 ? 0 :Integer.parseInt(aRestar[0]);
            for(int i=1; i<aRestar.length; i++) {
                res-=Integer.parseInt(aRestar[i]);
            }
            return res;
        } else {
            return Integer.parseInt(resta);
        }
    }

    //dada una Lista de strings con op. matematicas. Detecta aquellas en las que hay una multiplica-
    //cion y la aplica -> [3,5*2-1,3*3] -> [3,10-1,9]
    // 3*-1 -> ¿cómo resolverlo?
    public List<String> aplicaMult(List<String> cads) {
        List<String> acum = new ArrayList<>();
        for(String cad:cads) {
            if(cad.contains("*")) {
                if(cad.contains("-")) {
                    List<String> acum2 = new ArrayList<>();
                    cad = cad.replace("*-","t");
                    //llegados hasta este punto -> 5*2-4, separamos las restas -> 5*2,4 -> aplicamos las multiplicaciones
                    //-> 10,4 -> restamos lo que queda -> 6.
                    //problema -> Si tenemos 3*-2-5 esto no sirve pues nos quedaría 3*,2,5 -> Solución sencilla ->
                    //para que el split('-') no haga efecto sobre el *-, sustituiremos *- por t -> Y una vez realizado
                    //el split se volverá a sustituir t por "*-" -> Quedaría 3*-2,5
                    String[] es = cad.split("\\-");
                    Integer res = 1;
                    for(String e: es) {
                        e = e.replace("t", "*-");
                        if(e.contains("*")) {
                            String[] ops = e.split("\\*");
                            res = Integer.parseInt(ops[0]);
                            for(int i = 1; i<ops.length; i++) {
                                res *= Integer.parseInt(ops[i]);
                            }
                            acum2.add(res.toString());
                        } else {
                            acum2.add(e);
                        }
                    }
                    String mult = join(acum2, "-");
                    acum.add(mult);
                } else {
                    String[] ops = cad.split("\\*");
                    Integer res = Integer.parseInt(ops[0])*Integer.parseInt(ops[1]);
                    acum.add(res.toString());
                }
            } else {
                acum.add(cad);
            }
        }
        return acum;
    }

    public Object obtenVar(String var) {
        return asig.get(var);
    }

    public String escape(String operador) {
        String res;
        switch(operador) {
            case "+":
                res = "\\+";
                break;
            default:
                res = "\\-";
                break;
        }
        return res;
    }

    public String join(List<String> ls, String operator) {
        String r = "";
        for(String l: ls) {
            r = r + l + operator;
        }
        r = r.substring(0, r.length()-1);
        return r;
    }

    //Retorna en forma de lista las cosas que están entre paréntesis -> 3*(4-1)+(6-2*3) ->
    //[(4-1),(6-2*3)]
    public List<String> entreParentesis(String cad) {
        int nvl = 0;
        List<String> ls = new ArrayList<>();
        if(cad.contains("(")) {
            int comienzo = cad.indexOf('(');
            nvl = 1;
            for(int i = comienzo+1; i < cad.length(); i++) {
                if(cad.charAt(i)=='(') {
                    if(nvl==0) {
                        comienzo=i;
                    }
                    nvl+=1;
                } else if(cad.charAt(i)==')') {
                    if(nvl==1) {
                        ls.add(cad.substring(comienzo,i+1));
                        nvl-=1;
                    } else {
                        nvl-=1;
                    }
                }
            }
            return ls;
        } else {
            ls.add(cad);
            return ls;
        }
    }
}