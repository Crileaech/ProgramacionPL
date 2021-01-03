import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

public class asertos extends AnasintBaseVisitor<Boolean>{
    //dado un aserto formado por un cuantificador, si es por exprBool es trivial y no será
    //procesado aquí, se encarga de procesarlo.

    //retornará: -True -> Ejecución correcta del aserto.
    //           -False -> Ejecición incorrecta del aserto.
    ParseTreeWalker walker = new ParseTreeWalker();

    public Boolean visitAserto(Anasint.AsertoContext ctx) { return visit(ctx.asertos()); }

    public Boolean visitAsertos(Anasint.AsertosContext ctx) {
        Boolean r;
        if(ctx.cuantificador().cuantificadorExistencial()!=null) {
            r = existencial(ctx);
        } else {
            r = universal(ctx);
        }
        return r;
    }

    //si uno cumple la condición el aserto es cierto.
    public Boolean existencial(Anasint.AsertosContext ctx) {
        evaluaExpr evalua = new evaluaExpr(subprogramaAPartirDeAserto(ctx));
        Anasint.CuantificacionContext cuant = ctx.cuantificador()
                .cuantificadorExistencial().cuantificacion();
        String var = cuant.variable().getText();
        //Si comienzo es una función
        Integer comienzo;
        if(cuant.expr_integer(0).getChild(0).getClass()==Anasint.Expr_funcContext.class){
            comienzo = (Integer)((List<Object>) evalua.visit(cuant.expr_integer(0))).get(1);
        } else {
            comienzo = (Integer) evalua.visit(cuant.expr_integer(0));
        }
        //Si fin es una función
        Integer fin;
        if(cuant.expr_integer(1).getChild(0).getClass()==Anasint.Expr_funcContext.class){
            fin = (Integer)((List<Object>) evalua.visit(cuant.expr_integer(1))).get(1);
        } else {
            fin = (Integer) evalua.visit(cuant.expr_integer(1));
        }
        if(comienzo==null || fin==null) { return null;}
        if(comienzo>fin) { return null; }
        flujoInstrucciones.asig.put(var, comienzo);
        while((Integer)flujoInstrucciones.asig.get(var)<=fin) {
            Boolean res = (Boolean) evalua.visit(cuant.expr_bool());
            if(res) { return true; }
            flujoInstrucciones.asig.put(var,(Integer)flujoInstrucciones.asig.get(var)+1);
        }
        return false;
    }

    //si todos cumplen la condición el aserto es cierto.
    public Boolean universal(Anasint.AsertosContext ctx) {
        evaluaExpr evalua = new evaluaExpr(subprogramaAPartirDeAserto(ctx));
        Anasint.CuantificacionContext cuant = ctx.cuantificador()
                .cuantificadorUniversal().cuantificacion();
        String var = cuant.variable().getText();
        //Si comienzo es una función
        Integer comienzo;
        if(cuant.expr_integer(0).getChild(0).getClass()==Anasint.Expr_funcContext.class){
            comienzo = (Integer)((List<Object>) evalua.visit(cuant.expr_integer(0))).get(1);
        } else {
            comienzo = (Integer) evalua.visit(cuant.expr_integer(0));
        }
        //Si fin es una función
        Integer fin;
        if(cuant.expr_integer(1).getChild(0).getClass()==Anasint.Expr_funcContext.class){
            Object a = evalua.visit(cuant.expr_integer(1));
            if (a.getClass().toString().equals("class java.util.ArrayList"))
                fin = (Integer)((List<Object>) evalua.visit(cuant.expr_integer(1))).get(1);
            else
                fin = (Integer)(evalua.visit(cuant.expr_integer(1)));
        } else {
            fin = (Integer) evalua.visit(cuant.expr_integer(1));
        }
        if(comienzo>fin) { return null; }
        flujoInstrucciones.asig.put(var, comienzo);
        Boolean res = (Boolean) evalua.visit(cuant.expr_bool());
        while(res && (Integer)flujoInstrucciones.asig.get(var)<=fin) {
            res = res&&(Boolean) evalua.visit(cuant.expr_bool());
            flujoInstrucciones.asig.put(var,(Integer)flujoInstrucciones.asig.get(var)+1);
        }
        return res;
    }

    private Anasint.SubprogramasContext subprogramaAPartirDeAserto(Anasint.AsertosContext ctx) {
        ParserRuleContext padre = ctx.getParent();
        while(true) {
            if(padre.getChild(0).getText().equals("PROGRAMA")) {
                break;
            }
            padre = padre.getParent();
        }
        return (Anasint.SubprogramasContext) padre.getChild(2);
    }
}