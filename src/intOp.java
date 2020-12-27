import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//clase que se encarga de realizar las operaciones matematicas en el orden adecuado.
public class intOp extends AnasintBaseVisitor<Object>{
    private String stringOp = null;
    private Map<String,Object> asig = null;

    private final evaluaExpr evalua = new evaluaExpr();

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

    public Integer visitVarInt(Anasint.VarIntContext ctx) {
        return (Integer) evalua.visit(ctx);
    }

    public Integer resultado() {
        if(stringOp.contains("(")) {
            Matcher m = Pattern.compile("\\((.*?)\\)").matcher(stringOp);
            String res = stringOp;
            while(m.find()) {
                String dentroParentesis = m.group(1);
                res.replace(dentroParentesis, calcula(dentroParentesis).toString());
            }
            res = res.replace("(","");
            res = res.replace(")","");
            return calcula(res);
        } else {
            return calcula(stringOp);
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
    public Integer resta(String resta) {
        if(resta.contains("-")) {
            String[] aRestar = resta.split("\\-");
            Integer res = Integer.parseInt(aRestar[0]);
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
    public List<String> aplicaMult(List<String> cads) {
        List<String> acum = new ArrayList<>();
        for(String cad:cads) {
            if(cad.contains("*")) {
                if(cad.contains("-")) {
                    List<String> acum2 = new ArrayList<>();
                    String[] es = cad.split("\\-");
                    for(String e: es) {
                        if(e.contains("*")) {
                            String[] ops = e.split("\\*");
                            Integer res= Integer.parseInt(ops[0]);
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
                    //ops = 5,3-1
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

    public String getStringOp() {
        return stringOp;
    }
}
