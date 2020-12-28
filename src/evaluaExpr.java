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
        boolOp opBool = new boolOp(ctx, flujoInstrucciones.asig);
        return opBool.resultado();
    }
    public Boolean visitOpBool(Anasint.OpBoolContext ctx) {
        boolOp opBool = new boolOp(ctx, flujoInstrucciones.asig);
        return opBool.resultado();
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
    public Boolean visitExprFuncBool(Anasint.ExprFuncBoolContext ctx) {
        // TODO: 12/12/20
        return null;
    }
    public Object visitExpr_sacar_elem(Anasint.Expr_sacar_elemContext ctx) {
        List<Object> elems = (List<Object>) flujoInstrucciones.asig.get(ctx.variable().getText());
        Integer index = (Integer) visit(ctx.expr_integer());
        if(index>elems.size()) {
            System.out.println("ERROR: El índice excede la secuencia. (" + ctx.getText() + ").");
            System.out.println("Ejecución finalizada.");
            int tam = flujoInstrucciones.pila.size();
            flujoInstrucciones.pila.empty();
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

        //nombre de la función a la que queremos llamar
        String nomFunc = ctx.expr_func().variable().VAR().getText();

        //añadimos a un mapa el nombre de la función asociado a una lista con los valores de las variables
        //que se le pasan como parámetro, ya que la propia función es la que se encarga de asignar
        //nombre a esas variables
        subpParams.put(nomFunc, ctx.expr_func().expr().stream().map(v -> visit(v)).collect(Collectors.toList()));

        //lista de subprogramas
        List<Anasint.Declaracion_subprogramasContext> decSubp = subprogramas.declaracion_subprogramas();
        Object f = null;

        for(int i=0; i<decSubp.size(); i++)
            //buscamos la función con el nombre que queremos
            if (decSubp.get(i).getChild(0).getChild(1).getText().equals(nomFunc)){
                f = visit(decSubp.get(i).getChild(0));
            }

        return f;
    }

    public Object visitFuncion(Anasint.FuncionContext ctx){

        String nomFunc = ctx.variable().VAR().getText();

        Map<String, Object> nombresYvalores = new LinkedHashMap<>();
        String nombreDev;

        //si el tercer hijo es un paréntesis, es que la función tiene parámetros de entrada
        //y, por tanto, debemos asignar el nombre que aparece en la declaración de la función
        //al valor introducido al llamarla
        if(ctx.getChild(2).getText().equals("(")){
            List<String> nombresParamsEntrada = getNombresParamsEntrada(ctx.params(0));
            nombreDev = ctx.params(1).variable().getText();
            for (int i=0; i<=subpParams.size(); i++){
                nombresYvalores.put(nombresParamsEntrada.get(i), subpParams.get(nomFunc).get(i));
            }
        }
        else{
            nombreDev = ctx.params(0).variable().getText();
        }

        subpParamsAsignados.put(nomFunc, nombresYvalores);

        //creamos un flujo de instrucciones para la función correspondiente
        System.out.println("--FUNCIÓN "+nomFunc+"--");
        flujoInstrucciones func = new flujoInstrucciones(subpParamsAsignados.get(nomFunc));
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(func, ctx);
        System.out.println("--FFUNCIÓN "+nomFunc+"--");

        return func.asig.get(nombreDev);
    }

        //función que devuelve una lista con todos los nombres de los parámetros de la función
    public List<String> getNombresParamsEntrada(Anasint.ParamsContext ctx){

        List<String> f = new ArrayList<>();
        f.add(ctx.variable().VAR().getText());
        if(ctx.params()!=null)
            f.addAll(getNombresParamsEntrada(ctx.params()));

        return f;
    }

    //FIN: Asignar una función a una variable

    public List<Object> visitVarSeq(Anasint.VarSeqContext ctx) {
        return (List<Object>) flujoInstrucciones.asig.get(ctx.getText());
    }

    public Integer visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx) {
        return (Integer) visit(ctx.expr_sacar_elem());
    }
    public Integer visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx) {
        //(2-4)*5
        intOp op = new intOp(ctx,flujoInstrucciones.asig);
        return op.resultado();
    }

    public Integer visitOpInteger(Anasint.OpIntegerContext ctx) {
        //si se desea que se resuelvan las variables mirando otro almacén introducir otro en el
        //constructor como segundo parámetro.
        intOp operador = new intOp(ctx,flujoInstrucciones.asig);
        return operador.resultado();
    }

    public Integer visitMenosNum(Anasint.MenosNumContext ctx) {
        intOp op = new intOp(ctx, flujoInstrucciones.asig);
        return op.resultado();
    }
    public Integer visitNum(Anasint.NumContext ctx) {
        return Integer.parseInt(ctx.getText());
    }
    public Object visitVarInt(Anasint.VarIntContext ctx) {
        //puede ser una variable log, num o seq
        return (Object) flujoInstrucciones.asig.get(ctx.getText());
    }
}