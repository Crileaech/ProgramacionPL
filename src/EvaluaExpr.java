import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.*;
import java.util.stream.Collectors;

public class EvaluaExpr extends AnasintBaseVisitor<Object>{

    Anasint.SubprogramasContext subprogramas;

    public EvaluaExpr(){}

    public EvaluaExpr(Anasint.SubprogramasContext ctx){
        subprogramas = ctx;
    }

    //Almacén de los valores de los parámetros de los subprogramas ANTES de que la función
    //asigne los parámetros a una variable en la declaración de la misma, estructura:
    //Map<NombreSubprograma,List<valorVariable>>
    public Map<String,List<Object>> subpParams = new HashMap<>();

    //Almacén de los parámetros de los subprogramas con estructura:
    //Map<nombreSubprograma, Map<nombreVariable, valorVariable>>
    public Map<String,Map<String,Object>> subpParamsAsignados = new LinkedHashMap<>();

    //VISITORS
    public Object visitExpr(Anasint.ExprContext ctx) {
        return visit(ctx.getChild(0));
    }

    public Boolean visitTrue(Anasint.TrueContext ctx) { return true; }
    public Boolean visitFalse(Anasint.FalseContext ctx) {
        return false;
    }
    public Boolean visitVarBool(Anasint.VarBoolContext ctx) {
        return (Boolean) Interprete.asig.get(ctx.getText());
    }
    public Boolean visitSacarElemBool(Anasint.SacarElemBoolContext ctx) {
        return (Boolean) visit(ctx.expr_sacar_elem());
    }
    public Boolean visitCompararBool(Anasint.CompararBoolContext ctx) {
        //Si la izq o dcha son una función -> Debemos saberlo ya que las funciones retornan ["func", T] -> Para
        //ello comprobamos si el objeto retornado por los visits es una instancia de Lista -> En caso de serlo tomar
        // el segundo elemento (T). Si no lo es pues es el valor retornado del visit.
        Boolean izq; Boolean dcha;
        Object izqO = visit(ctx.getChild(0));
        Object dchaO = visit(ctx.getChild(2));
        if(izqO instanceof List) {
            izq = (Boolean) ((List<Object>) izqO).get(1);
        } else {
            izq = (Boolean) izqO;
        }
        if(dchaO instanceof List) {
            dcha = (Boolean) ((List<Object>) dchaO).get(1);
        } else {
            dcha = (Boolean) dchaO;
        }
        if(ctx.getChild(1).getText().equals("==")) {
            return izq==dcha;
        } else {
            return izq!=dcha;
        }
    }
    public Boolean visitParentesisOpBool(Anasint.ParentesisOpBoolContext ctx) {
        Boolean izq; Boolean dcha;
        Object izqO = visit(ctx.getChild(1));
        Object dchaO = visit(ctx.getChild(3));
        if(izqO instanceof List) {
            izq = (Boolean) ((List<Object>) izqO).get(1);
        } else {
            izq = (Boolean) izqO;
        }
        if(dchaO instanceof List) {
            dcha = (Boolean) ((List<Object>) dchaO).get(1);
        } else {
            dcha = (Boolean) dchaO;
        }
        String operador = ctx.getChild(2).getText();
        if(operador.equals("&&")) { return izq&&dcha; }
        else { return izq||dcha; }
    }
    public Boolean visitOpBool(Anasint.OpBoolContext ctx) {
        Boolean izq; Boolean dcha;
        Object izqO = visit(ctx.getChild(0));
        Object dchaO = visit(ctx.getChild(2));
        if(izqO instanceof List) {
            izq = (Boolean) ((List<Object>) izqO).get(1);
        } else {
            izq = (Boolean) izqO;
        }
        if(dchaO instanceof List) {
            dcha = (Boolean) ((List<Object>) dchaO).get(1);
        } else {
            dcha = (Boolean) dchaO;
        }
        String operador = ctx.getChild(1).getText();
        if(operador.equals("&&")) { return izq&&dcha; }
        else { return izq||dcha; }
    }

    public Boolean visitCompararSeq(Anasint.CompararSeqContext ctx) {
        List<Object> seq1 = (List<Object>) visit(ctx.getChild(0));
        List<Object> seq2 = (List<Object>) visit(ctx.getChild(2));
        if(seq1.get(0).equals("func")) {
            seq1 = (List<Object>)seq1.get(1);
        }
        if(seq2.get(0).equals("func")) {
            seq2 = (List<Object>)seq2.get(1);
        }
        if(ctx.getChild(1).getText().equals("==")) {
            return seq1.equals(seq2);
        } else {
            return !seq1.equals(seq2);
        }
    }
    public Boolean visitCompararInteger(Anasint.CompararIntegerContext ctx) {
        Integer n1; Integer n2;
        Object n1O = visit(ctx.getChild(0));
        Object n2O = visit(ctx.getChild(2));
        if(n1O instanceof List) {
            n1 = (Integer) ((List<Object>) n1O).get(1);
        } else {
            n1 = (Integer) n1O;
        }
        if(n2O instanceof List) {
            n2 = (Integer) ((List<Object>) n2O).get(1);
        } else {
            n2 = (Integer) n2O;
        }
        String comp = ctx.getChild(1).getText();
        if(comp.equals("<=")) return n1<=n2;
        else if(comp.equals(">=")) return n1>=n2;
        else if(comp.equals("<")) return n1<n2;
        else if(comp.equals(">")) return n1>n2;
        else if(comp.equals("==")) return n1.equals(n2);
        else return !n1.equals(n2);
    }

    public Boolean visitNegacionBool(Anasint.NegacionBoolContext ctx) {
        return !(Boolean)visit(ctx.expr_bool());
    }

    public Object visitExpr_func(Anasint.Expr_funcContext ctx) {
        //nombre de la función a la que queremos llamar
        String nomFunc = ctx.variable().VAR().getText();
        Object f = null;

        //PREDEFINIDA: última posición de una secuencia
        List<Object> seq;
        if(nomFunc.equals("ultima_posicion")) {
            seq = (List<Object>) Interprete.asig.get(ctx.exprs().expr().getText());
            //si f=-1 es que la secuencia está vacía
            f = seq.size()-1;
        }
        //PREDEFINIDA: ¿está vacía la secuencia?
        else if(nomFunc.equals("vacia")){
            seq = (List<Object>) Interprete.asig.get(ctx.exprs().expr().getText());
            f = seq.isEmpty();
        }
        //SI NO ES UNA FUNCIÓN PREDEFINIDA
        else{
            //añadimos a un mapa el nombre de la función asociado a una lista con los valores de las variables
            //que se le pasan como parámetro, ya que la propia función es la que se encarga de asignar
            //nombre a esas variables
            if (ctx.exprs()!=null)
                subpParams.put(nomFunc, iterarExprs(ctx.exprs()).stream().map(v -> visit(v)).collect(Collectors.toList()));
            //lista de subprogramas
            List<Anasint.Declaracion_subprogramasContext> decSubp = subprogramas.declaracion_subprogramas();

            for(int i=0; i<decSubp.size(); i++)
                //buscamos la función con el nombre que queremos
                if (decSubp.get(i).getChild(0).getChild(1).getText().equals(nomFunc)){
                    f = visit(decSubp.get(i).getChild(0));
                }
        }
        return  f;
    }

    public Object visitExprFuncBool(Anasint.ExprFuncBoolContext ctx) {
        //nombre de la función a la que queremos llamar
        String nomFunc = ctx.expr_func().variable().VAR().getText();
        Object ret;
        Object f = null;

        //PREDEFINIDA: última posición de una secuencia
        List<Object> seq;
        if(nomFunc.equals("ultima_posicion")) {
            seq = (List<Object>) Interprete.asig.get(ctx.expr_func().exprs().expr().getText());

            //si ret=-1 es que la secuencia está vacía
            ret = seq.size()-1;
        }
        //PREDEFINIDA: ¿está vacía la secuencia?
        else if(nomFunc.equals("vacia")){
            seq = (List<Object>) Interprete.asig.get(ctx.expr_func().exprs().expr().getText());
            ret = seq.isEmpty();
        }else {
            //SI NO ES UNA FUNCIÓN PREDEFINIDA
            //añadimos a un mapa el nombre de la función asociado a una lista con los valores de las variables
            //que se le pasan como parámetro, ya que la propia función es la que se encarga de asignar
            //nombre a esas variables
            if (ctx.expr_func().exprs()!=null)
                subpParams.put(nomFunc, iterarExprs(ctx.expr_func().exprs()).stream().map(v -> visit(v)).collect(Collectors.toList()));

            //lista de subprogramas
            List<Anasint.Declaracion_subprogramasContext> decSubp = subprogramas.declaracion_subprogramas();

            for (int i = 0; i < decSubp.size(); i++) {
                //buscamos la función con el nombre que queremos
                if (decSubp.get(i).getChild(0).getChild(1).getText().equals(nomFunc)) {
                    f = visit(decSubp.get(i).getChild(0));
                }
            }

            //quitamos el identificador de la función
            ((List<Object>) f).remove(0);

            ret = ((List<Object>) f).get(0);;
        }
        //devolvemos el primer objeto que devuelve la función
        return ret;
    }
    public Object visitExpr_sacar_elem(Anasint.Expr_sacar_elemContext ctx) {
        //dos posibilidades expr_func(param)[i] o s[i] -> expr_func funcion que retorna secuencia. s variable que almacena
        //secuencia.
        List<Object> elems;
        if(ctx.expr_func()!=null) {
            elems = (List<Object>) visit(ctx.expr_func());
            //si expr_func retorna secuencia ["func", [T,F,T..]]
            //se da por supuesto que la función retornará secuencia porque sino lo hace es
            //error semántico NO de intérprete
            elems = (List<Object>) elems.get(1);
        } else {
            elems = (List<Object>) Interprete.asig.get(ctx.variable().getText());
        }
        Integer index = (Integer) visit(ctx.expr_integer());
        if(index>=elems.size()) {
            System.out.println("ERROR: El índice excede la secuencia. (" + ctx.getText() + ").");
            System.out.println("Ejecución finalizada.");
            Interprete.finalizaEjecución();
            return null;
        }
        return elems.get(index);
    }
    public Object visitVaciaSeq(Anasint.VaciaSeqContext ctx) {
        return new ArrayList<>();
    }
    public Object visitSeq(Anasint.SeqContext ctx) {
        List<Object> seq = new ArrayList<>();
        for(Anasint.ExprContext expr: ctx.expr()) {
            Object exprVisitada = visit(expr);
            if(exprVisitada instanceof List) {
                if(((List<Object>) exprVisitada).get(0).equals("func")) {
                    ((List<Object>) exprVisitada).remove(0);
                    seq.addAll((List<Object>) exprVisitada);
                } else {
                    seq.add(exprVisitada);
                }
            } else {
                seq.add(exprVisitada);
            }
        }
        return seq;
    }

    //Asignar una función a una variable

    public Object visitExprFuncInt(Anasint.ExprFuncIntContext ctx) {
        return visit(ctx.expr_func());
    }

    public Object visitProcedimiento(Anasint.ProcedimientoContext ctx){

        if(Interprete.pila.peek()) {
            Interprete.pila.push(true);

            String nomProc = ctx.variable().VAR().getText();
            Map<String, Object> nombresYvalores = new LinkedHashMap<>();

            List<String> nombresParamsEntrada = getNombresParamsEntrada(ctx);
            for (int i = 0; i < subpParams.get(nomProc).size(); i++) {
                nombresYvalores.put(nombresParamsEntrada.get(i), subpParams.get(nomProc).get(i));
            }
            List<Anasint.Declaracion_instruccionesContext> instCtx = ctx.instrucciones().declaracion_instrucciones();

            //en cuanto se ve la instrucción dev, se devuelven las variables indicadas

            subpParamsAsignados.put(nomProc, nombresYvalores);

            //clonamos en un mapa las asignaciones de la función, y sustituimos las asignaciones globales con las de la función
            //con el objetivo de que el flujo de instrucciones para la función sólo utilice las variables de la propia función
            Map<String, Object> asigAnterior = new LinkedHashMap<>(Interprete.asig);
            Interprete.asig.clear();

            //creamos un flujo de instrucciones para la función correspondiente
            Interprete.muestraConIdentación("(PROCEDIMIENTO " + nomProc + ")",1);
            Interprete proc = new Interprete(subpParamsAsignados.get(nomProc));

            proc.asig.putAll(nombresYvalores);

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(proc, ctx);


            Map<String, Object> asigParametros = new LinkedHashMap<>();
            for (int i = 0; i < nombresParamsEntrada.size(); i++) {
                String s = proc.procEquivalencias.get(nomProc).get(nombresParamsEntrada.get(i));
                Object o = proc.asig.get(nombresParamsEntrada.get(i));

                //si el parámetro existe
                if (s != null)
                    asigParametros.put(s, o);
            }

            proc.asig.clear();
            proc.asig.putAll(asigAnterior);
            proc.asig.putAll(asigParametros);

            if (Interprete.pila.peek())
                Interprete.muestraConIdentación("(FIN PROCEDIMIENTO " + nomProc + ")",1);

            Interprete.pila.pop();
        }
        //no necesitamos devolver nada con los procedimientos, nos bastan los valores
        //almacenados en el almacén de variables de subprogramas y las equivalencias
        //entre variables
        return null;
    }

    public List<Object> visitFuncion(Anasint.FuncionContext ctx) {

        List<Object> valores = new ArrayList<>();
        if (Interprete.pila.peek()) {
            Interprete.pila.push(true);

            String nomFunc = ctx.variable().VAR().getText();
            Map<String, Object> nombresYvalores = new LinkedHashMap<>();

            //si el tercer hijo es un paréntesis, es que la función tiene parámetros de entrada
            //y, por tanto, debemos asignar el nombre que aparece en la declaración de la función
            //al valor introducido al llamarla
            if (ctx.params().size() > 1) {
                List<String> nombresParamsEntrada = getNombresParamsEntrada(ctx);
                for (int i = 0; i < subpParams.get(nomFunc).size(); i++) {
                    nombresYvalores.put(nombresParamsEntrada.get(i), subpParams.get(nomFunc).get(i));
                }
            }

            List<Anasint.Declaracion_instruccionesContext> instCtx = ctx.instrucciones().declaracion_instrucciones();

            //en cuanto se ve la instrucción dev, se devuelven las variables indicadas

            subpParamsAsignados.put(nomFunc, nombresYvalores);

            //clonamos en un mapa las asignaciones de la función, y sustituimos las asignaciones globales con las de la función
            //con el objetivo de que el flujo de instrucciones para la función sólo utilice las variables de la propia función
            Map<String, Object> asigAnterior = new LinkedHashMap<>(Interprete.asig);
            Interprete.asig.clear();

            //creamos un flujo de instrucciones para la función correspondiente
            Interprete.muestraConIdentación("(FUNCIÓN " + nomFunc + ")",1);
            Interprete func = new Interprete(subpParamsAsignados.get(nomFunc));

            func.asig.putAll(nombresYvalores);

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(func, ctx);

            if (Interprete.pila.peek()) {
                String textoADevolver = "";
                valores.add("func");
                //me recorro la instrucción dev. Si los hijos son variables añado a valores lo que hay en el almacén.
                //Si lo que hay es algo que no son variables lo evaluo y lo añado en valores.
                for (int i = 0; i < instCtx.size(); i++) {
                    if (instCtx.get(i).getChild(0).getChild(0) != null) {
                        if (instCtx.get(i).getChild(0).getChild(0).getText().equals("dev")) {
                            Anasint.DevolucionContext dev = (Anasint.DevolucionContext) instCtx.get(i).getChild(0);
                            for (int j = 1; j < dev.getChildCount(); j += 2) {
                                if (dev.getChild(j).getChild(0).getChild(0).getClass()
                                        == Anasint.VariableContext.class) {
                                    valores.add(func.asig.get(dev.getChild(j).getText()));
                                    textoADevolver += " " + dev.getChild(j).getText() + "="
                                            + valores.get(valores.size() - 1) + ",";
                                } else {
                                    valores.add(visit(dev.getChild(j)));
                                    textoADevolver += " " + valores.get(valores.size() - 1) + ",";
                                }

                            }
                            textoADevolver = textoADevolver.substring(0, textoADevolver.length() - 1);
                        }
                    } else {
                        break;
                    }
                }
                //restauramos el mapa de asignaciones global con las antiguas
                func.asig.clear();
                func.asig.putAll(asigAnterior);
                Interprete.muestraConIdentación("(devolución)" + textoADevolver, 1);
                Interprete.muestraConIdentación("(FIN FUNCIÓN "+nomFunc+")", 1);
            }
            Interprete.pila.pop();
        }
        return valores;
    }

    public List<String> getNombresParamsEntrada(Anasint.FuncionContext ctx){
        List<String> acum = new ArrayList<>();
        acum.add(ctx.params().get(0).variable().VAR().getText());

        if(ctx.params().get(0).params()!=null){
            acum.addAll(getNombresParamsEntrada(ctx.params().get(0).params()));
        }

        return acum;
    }

    public List<String> getNombresParamsEntrada(Anasint.ProcedimientoContext ctx){
        List<String> acum = new ArrayList<>();
        acum.add(ctx.params().variable().VAR().getText());

        if(ctx.params().params()!=null){
            acum.addAll(getNombresParamsEntrada(ctx.params().params()));
        }

        return acum;
    }

    public List<String> getNombresParamsEntrada(Anasint.ParamsContext params){

        List<String> acum = new ArrayList<>();
        acum.add(params.variable().VAR().getText());

        if(params.getChildCount()>2) {
            acum.addAll(getNombresParamsEntrada(params.params()));
        }

        return acum;
    }

    public List<Object> visitVarSeq(Anasint.VarSeqContext ctx) {
        return (List<Object>) Interprete.asig.get(ctx.getText());
    }

    public Integer visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx) {
        return (Integer) visit(ctx.expr_sacar_elem());
    }
    public Integer visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx) {
        Integer n1; Integer n2;
        Object n1O = visit(ctx.getChild(1));
        Object n2O = visit(ctx.getChild(3));
        if(n1O instanceof List) {
            n1 = (Integer) ((List<Object>) n1O).get(1);
        } else {
            n1 = (Integer) n1O;
        }
        if(n2O instanceof List) {
            n2 = (Integer) ((List<Object>) n2O).get(1);
        } else {
            n2 = (Integer) n2O;
        }
        String operador = ctx.getChild(2).getText();
        if(operador.equals("*")) { return n1*n2; }
        else if(operador.equals("+")) { return n1+n2; }
        else { return n1-n2; }
    }
    public Integer visitOpInteger(Anasint.OpIntegerContext ctx) {
        Integer n1; Integer n2;
        Object n1O = visit(ctx.getChild(0));
        Object n2O = visit(ctx.getChild(2));
        if(n1O instanceof List) {
            n1 = (Integer) ((List<Object>) n1O).get(1);
        } else {
            n1 = (Integer) n1O;
        }
        if(n2O instanceof List) {
            n2 = (Integer) ((List<Object>) n2O).get(1);
        } else {
            n2 = (Integer) n2O;
        }
        String operador = ctx.getChild(1).getText();
        if(operador.equals("*")) { return n1*n2; }
        else if(operador.equals("+")) { return n1+n2; }
        else { return n1-n2; }
    }
    public Integer visitMenosNum(Anasint.MenosNumContext ctx) {
        Object num = visit(ctx.expr_integer());
        if(num instanceof List) {
            num = ((List<Object>) num).get(1);
        }
        return -(Integer)num;
    }

    public Integer visitParentesisInteger(Anasint.ParentesisIntegerContext ctx) {
        Object num = visit(ctx.expr_integer());
        if(num instanceof List) {
            num = ((List<Object>) num).get(1);
        }
        return (Integer) num;
    }

    public List<Anasint.ExprContext> iterarExprs(Anasint.ExprsContext ctx){
        List<Anasint.ExprContext> l = new ArrayList<>();
        l.add(ctx.expr());
        if(ctx.exprs()!=null)
            l.addAll(iterarExprs(ctx.exprs()));

        return l;
    }

    public Integer visitNum(Anasint.NumContext ctx) {
        return Integer.parseInt(ctx.getText());
    }
    public Object visitVarInt(Anasint.VarIntContext ctx) {
        //puede ser una variable log, num o seq
        return (Object) Interprete.asig.get(ctx.getText());
    }
}
