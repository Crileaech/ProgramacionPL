public class Generador extends AnasintBaseVisitor<String> {
    //Generar texto correspondiente a variable
    public String visitVar(Anasint.VariableContext ctx) {
        return ctx.VAR().getText();
    }
    //Generar texto correspondiente a número
    public String visitNum(Anasint.NumContext ctx) {
        return ctx.NUM().getText(); }
    //Generar texto correspondiente a expresión parentizada
    public String visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx){
        String res = "(";
        if(ctx.getChild(2)==ctx.SUMA()){
            String i=visit(ctx.expr_integer(0));
            String j=visit(ctx.expr_integer(1));
            res += i+"+"+j;
        }
        if(ctx.getChild(2)==ctx.RESTA()){
            String i=visit(ctx.expr_integer(0));
            String j=visit(ctx.expr_integer(1));
            res += i+"-"+j;
        }

        if(ctx.getChild(2)==ctx.POR()){
            String i=visit(ctx.expr_integer(0));
            String j=visit(ctx.expr_integer(1));
            res += i+"*"+j;
        }
        res += ")";
        return res; }
    public String visitOpInteger(Anasint.OpIntegerContext ctx){
        String res = new String();
        if(ctx.getChild(1)==ctx.SUMA()){
            String i=visit(ctx.expr_integer(0));
            String j=visit(ctx.expr_integer(1));
            res = i+"+"+j;
        }
        if(ctx.getChild(1)==ctx.RESTA()){
            String i=visit(ctx.expr_integer(0));
            String j=visit(ctx.expr_integer(1));
            res = i+"-"+j;
        }

        if(ctx.getChild(1)==ctx.POR()){
            String i=visit(ctx.expr_integer(0));
            String j=visit(ctx.expr_integer(1));
            res = i+"*"+j;
        }
        return res;
    }
}
