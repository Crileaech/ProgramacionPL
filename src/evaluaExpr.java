import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.*;
import java.util.stream.Collectors;

public class evaluaExpr extends AnasintBaseVisitor<Object>{

    Anasint.SubprogramasContext subprogramas;

    public evaluaExpr(){}

    public evaluaExpr(Anasint.SubprogramasContext ctx){
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
        return (Boolean) flujoInstrucciones.asig.get(ctx.getText());
    }
    public Boolean visitSacarElemBool(Anasint.SacarElemBoolContext ctx) {
        return (Boolean) visit(ctx.expr_sacar_elem());
    }
    public Boolean visitCompararBool(Anasint.CompararBoolContext ctx) {
        if(ctx.getChild(1).getText().equals("==")) {
            return visit(ctx.getChild(0))==visit(ctx.getChild(2));
        } else {
            return visit(ctx.getChild(0))!=visit(ctx.getChild(2));
        }
    }
    public Boolean visitParentesisOpBool(Anasint.ParentesisOpBoolContext ctx) {
        Anasint.Expr_boolContext izq = (Anasint.Expr_boolContext) ctx.getChild(1);
        Anasint.Expr_boolContext dcha = (Anasint.Expr_boolContext) ctx.getChild(3);
        String operador = ctx.getChild(2).getText();
        if(operador.equals("&&")) { return (Boolean) visit(izq)&&(Boolean) visit(dcha); }
        else { return (Boolean) visit(izq)||(Boolean) visit(dcha); }
    }
    public Boolean visitOpBool(Anasint.OpBoolContext ctx) {
        Anasint.Expr_boolContext izq = (Anasint.Expr_boolContext) ctx.getChild(0);
        Anasint.Expr_boolContext dcha = (Anasint.Expr_boolContext) ctx.getChild(2);
        String operador = ctx.getChild(1).getText();
        if(operador.equals("&&")) { return (Boolean) visit(izq)&&(Boolean) visit(dcha); }
        else { return (Boolean) visit(izq)||(Boolean) visit(dcha); }
    }

    public Boolean visitCompararSeq(Anasint.CompararSeqContext ctx) {
        List<Object> seq1 = (List<Object>) visit(ctx.getChild(0));
        List<Object> seq2 = (List<Object>) visit(ctx.getChild(2));
        if(ctx.getChild(1).getText().equals("==")) {
            return seq1.equals(seq2);
        } else {
            return !seq1.equals(seq2);
        }
    }
    public Boolean visitCompararInteger(Anasint.CompararIntegerContext ctx) {
        Integer n1 = (Integer) visit(ctx.getChild(0));
        Integer n2 = (Integer) visit(ctx.getChild(2));
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
            seq = (List<Object>) flujoInstrucciones.asig.get(ctx.exprs().expr().getText());
            //si f=-1 es que la secuencia está vacía
            f = seq.size()-1;
        }
        //PREDEFINIDA: ¿está vacía la secuencia?
        else if(nomFunc.equals("vacia")){
            seq = (List<Object>) flujoInstrucciones.asig.get(ctx.exprs().expr().getText());
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
            seq = (List<Object>) flujoInstrucciones.asig.get(ctx.expr_func().exprs().expr().getText());

            //si ret=-1 es que la secuencia está vacía
            ret = seq.size()-1;
        }
        //PREDEFINIDA: ¿está vacía la secuencia?
        else if(nomFunc.equals("vacia")){
            seq = (List<Object>) flujoInstrucciones.asig.get(ctx.expr_func().exprs().expr().getText());
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
        List<Object> elems = (List<Object>) flujoInstrucciones.asig.get(ctx.variable().getText());
        Integer index = (Integer) visit(ctx.expr_integer());
        if(index>elems.size()) {
            System.out.println("ERROR: El índice excede la secuencia. (" + ctx.getText() + ").");
            System.out.println("Ejecución finalizada.");
            int tam = flujoInstrucciones.pila.size();
            flujoInstrucciones.pila.clear();
            for(int i=0; i<tam; i++) {
                flujoInstrucciones.pila.push(false);
            }
            return null;
        }
        return elems.get(index);
    }
    public Object visitVaciaSeq(Anasint.VaciaSeqContext ctx) {
        return new ArrayList<>();
    }
    public Object visitSeq(Anasint.SeqContext ctx) {
        List<Object> seq = new ArrayList<>();
        for(Anasint.ExprContext expr: ctx.expr()) { seq.add(visit(expr)); }
        return seq;
    }

    //Asignar una función a una variable

    public Object visitExprFuncInt(Anasint.ExprFuncIntContext ctx) {
        return visit(ctx.expr_func());
    }

    public Object visitProcedimiento(Anasint.ProcedimientoContext ctx){

        if(flujoInstrucciones.pila.peek()) {
            flujoInstrucciones.pila.push(true);

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
            Map<String, Object> asigAnterior = new LinkedHashMap<>(flujoInstrucciones.asig);
            flujoInstrucciones.asig.clear();

            //creamos un flujo de instrucciones para la función correspondiente
            flujoInstrucciones.muestraConIdentación("(PROCEDIMIENTO " + nomProc + ")");
            flujoInstrucciones proc = new flujoInstrucciones(subpParamsAsignados.get(nomProc));

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

            if (flujoInstrucciones.pila.peek())
                flujoInstrucciones.muestraConIdentación("(FIN PROCEDIMIENTO " + nomProc + ")");

            flujoInstrucciones.pila.pop();
        }
        //no necesitamos devolver nada con los procedimientos, nos bastan los valores
        //almacenados en el almacén de variables de subprogramas y las equivalencias
        //entre variables
        return null;
    }

    public List<Object> visitFuncion(Anasint.FuncionContext ctx) {

        List<Object> valores = new ArrayList<>();
        if (flujoInstrucciones.pila.peek()) {
            flujoInstrucciones.pila.push(true);

            String nomFunc = ctx.variable().VAR().getText();
            Map<String, Object> nombresYvalores = new LinkedHashMap<>();

            //si el tercer hijo es un paréntesis, es que la función tiene parámetros de entrada
            //y, por tanto, debemos asignar el nombre que aparece en la declaración de la función
            //al valor introducido al llamarla
            if(ctx.params().size()>1){
                List<String> nombresParamsEntrada = getNombresParamsEntrada(ctx);
                for (int i=0; i<subpParams.get(nomFunc).size(); i++){
                    nombresYvalores.put(nombresParamsEntrada.get(i), subpParams.get(nomFunc).get(i));
                }
            }

            List<Anasint.Declaracion_instruccionesContext> instCtx = ctx.instrucciones().declaracion_instrucciones();

            //en cuanto se ve la instrucción dev, se devuelven las variables indicadas

            subpParamsAsignados.put(nomFunc, nombresYvalores);

            //clonamos en un mapa las asignaciones de la función, y sustituimos las asignaciones globales con las de la función
            //con el objetivo de que el flujo de instrucciones para la función sólo utilice las variables de la propia función
            Map<String,Object> asigAnterior = new LinkedHashMap<>(flujoInstrucciones.asig);
            flujoInstrucciones.asig.clear();

            //creamos un flujo de instrucciones para la función correspondiente
            flujoInstrucciones.muestraConIdentación("(FUNCIÓN "+nomFunc+")");
            flujoInstrucciones func = new flujoInstrucciones(subpParamsAsignados.get(nomFunc));

            func.asig.putAll(nombresYvalores);

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(func, ctx);

            if(flujoInstrucciones.pila.peek()) {
                flujoInstrucciones.muestraConIdentación("(FIN FUNCIÓN "+nomFunc+")");

                valores.add("func");
                //me recorro la instrucción dev. Si los hijos son variables añado a valores lo que hay en el almacén.
                //Si lo que hay es algo que no son variables lo evaluo y lo añado en valores.
                for(int i=0; i<instCtx.size(); i++) {
                    if(instCtx.get(i).getChild(0).getChild(0).getText().equals("dev")) {
                        Anasint.DevolucionContext dev = (Anasint.DevolucionContext) instCtx.get(i).getChild(0);
                        for(int j=1; j<dev.getChildCount(); j+=2) {
                            if(dev.getChild(j).getClass()==Anasint.VariablesContext.class) {
                                valores.add(func.asig.get(dev.getChild(j).getText()));
                            } else {
                                valores.add(visit(dev.getChild(j)));
                            }
                        }
                    }
                }
                func.asig.clear();
                func.asig.putAll(asigAnterior);

            }
            flujoInstrucciones.pila.pop();
        }

        return valores;
    }

    //función que devuelve una lista con todos los nombres de los parámetros de la función
    /*public List<String> getNombresParamsEntrada(Anasint.FuncionContext ctx){
        List<String> acum = new ArrayList<>();
        acum.add(ctx.params().get(0).variable().VAR().getText());

        if(ctx.params().get(0).params()!=null){
            acum.addAll(getNombresParamsEntrada(ctx.params().get(0).params(), acum));
        }

        return acum;
    }

    public List<String> getNombresParamsEntrada(Anasint.ProcedimientoContext ctx){
        List<String> acum = new ArrayList<>();
        acum.add(ctx.params().variable().VAR().getText());

        if(ctx.params().params()!=null){
            acum.addAll(getNombresParamsEntrada(ctx.params().params(), acum));
        }

        return acum;
    }*/

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

    /*public List<String> getNombresParamsEntrada(Anasint.ParamsContext params, List<String> acum){
        acum.add(params.variable().VAR().getText());
        if(params.getChildCount()>2) {
            acum.addAll(getNombresParamsEntrada(params.params(),acum));
        }

        return acum;
    }*/



    //FIN: Asignar una función a una variable

    public List<Object> visitVarSeq(Anasint.VarSeqContext ctx) {
        return (List<Object>) flujoInstrucciones.asig.get(ctx.getText());
    }

    public Integer visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx) {
        return (Integer) visit(ctx.expr_sacar_elem());
    }
    public Integer visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx) {
        Anasint.Expr_integerContext izq = (Anasint.Expr_integerContext) ctx.getChild(1);
        Anasint.Expr_integerContext dcha = (Anasint.Expr_integerContext) ctx.getChild(3);
        String operador = ctx.getChild(2).getText();
        if(operador.equals("*")) { return (Integer)visit(izq)*(Integer)visit(dcha); }
        else if(operador.equals("+")) { return (Integer)visit(izq)+(Integer)visit(dcha); }
        else { return (Integer)visit(izq)-(Integer)visit(dcha); }
    }
    public Integer visitOpInteger(Anasint.OpIntegerContext ctx) {
        Anasint.Expr_integerContext izq = (Anasint.Expr_integerContext) ctx.getChild(0);
        Anasint.Expr_integerContext dcha = (Anasint.Expr_integerContext) ctx.getChild(2);
        String operador = ctx.getChild(1).getText();
        if(operador.equals("*")) { return (Integer)visit(izq)*(Integer)visit(dcha); }
        else if(operador.equals("+")) { return (Integer)visit(izq)+(Integer)visit(dcha); }
        else { return (Integer)visit(izq)-(Integer)visit(dcha); }
    }
    public Integer visitMenosNum(Anasint.MenosNumContext ctx) {
        return -(Integer)visit(ctx.expr_integer());
    }

    /*
    public Integer visitParentesisNum(Anasint.ParentesisNumContext ctx) {
        return (Integer) Integer.parseInt(ctx.NUM().getText());
    }
    */

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
        return (Object) flujoInstrucciones.asig.get(ctx.getText());
    }
}