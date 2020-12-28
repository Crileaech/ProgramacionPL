import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class asertos extends AnasintBaseVisitor<Boolean>{
    //dado un aserto formado por un cuantificador, si es por exprBool es trivial y no será
    //procesado aquí, se encarga de procesarlo.

    //retornará: -True -> Ejecución correcta del aserto.
    //           -False -> Ejecición incorrecta del aserto.
    ParseTreeWalker walker = new ParseTreeWalker();
    private final evaluaExpr evalua = new evaluaExpr();

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
        Anasint.CuantificacionContext cuant = ctx.cuantificador()
                .cuantificadorExistencial().cuantificacion();
        String var = cuant.variable().getText();
        Integer comienzo = (Integer) evalua.visit(cuant.expr_integer(0));
        Integer fin = (Integer) evalua.visit(cuant.expr_integer(1));
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
        Anasint.CuantificacionContext cuant = ctx.cuantificador()
                .cuantificadorUniversal().cuantificacion();
        String var = cuant.variable().getText();
        Integer comienzo = (Integer) evalua.visit(cuant.expr_integer(0));
        Integer fin = (Integer) evalua.visit(cuant.expr_integer(1));
        if(comienzo>fin) { return null; }
        flujoInstrucciones.asig.put(var, comienzo);
        Boolean res = (Boolean) evalua.visit(cuant.expr_bool());
        while(res && (Integer)flujoInstrucciones.asig.get(var)<=fin) {
            res = res&&(Boolean) evalua.visit(cuant.expr_bool());
            flujoInstrucciones.asig.put(var,(Integer)flujoInstrucciones.asig.get(var)+1);
        }
        return res;
    }
}