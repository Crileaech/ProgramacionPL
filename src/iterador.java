import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class iterador extends AnasintBaseVisitor<Object>{

    ParseTreeWalker walker = new ParseTreeWalker();
    private final evaluaExpr evalua = new evaluaExpr();

    public Object visitIt(Anasint.ItContext ctx) {
        return visit(ctx.iteracion());
    }

    public Object visitIteracion(Anasint.IteracionContext ctx) {
        Boolean cond = (Boolean) evalua.visit(ctx.expr_bool());
        if(cond) System.out.println("(iteración)");
        Boolean entra = cond;
        while(cond) {
            for(int i = 0; i < ctx.getChildCount(); i++) {
                walker.walk(Principal.asig,ctx.getChild(i));
            }
            cond = (Boolean) evalua.visit(ctx.expr_bool());
        }
        if(entra) System.out.println("(fin iteración)");
        Principal.asig.pila.pop();
        Principal.asig.pila.push(false);
        return null;
    }
}