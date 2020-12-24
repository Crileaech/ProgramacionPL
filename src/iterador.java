import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class iterador extends AnasintBaseVisitor<Object>{

    ParseTreeWalker walker = new ParseTreeWalker();
    private final evaluaExpr evalua = new evaluaExpr();

    public Object visitIt(Anasint.ItContext ctx) {
        return visit(ctx.iteracion());
    }

    public Object visitIteracion(Anasint.IteracionContext ctx) {
        //miro si se cumple la condición del while
        Boolean cond = (Boolean) evalua.visit(ctx.expr_bool());
        if(cond) System.out.println("(iteración)");
        Boolean entra = cond; //centinela para ver si ha entrado al menos una vez.
        //si es así pongo mensaje de fin de iteración
        while(cond) {
            //mientras se cumpla la condición
            for(int i = 0; i < ctx.getChildCount(); i++) {
                //llamo al walker para que camine sobre los hijos de la iteración.
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