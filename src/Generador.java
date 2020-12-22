//////////////////////////
public class Generador extends AnasintBaseVisitor<String> {
    //Generar texto correspondiente a variable
//    public String visitIdExpr(Anasint.IdExprContext ctx) {
//        return ctx.VAR().getText();
//    }
    //Generar texto correspondiente a número
    public Integer visitNumExpr(Anasint.Expr_integerContext ctx) {
        return Anasint.NUM; }
    //Generar texto correspondiente a diferencia de expresiones
    public String visitMenosExpr(Anasint.OpIntegerContext ctx) {
        String i=visit(ctx.RESTA());
        String j=visit(ctx.RESTA());
        return i+"-"+j; }

    //Generar texto correspondiente a producto de expresiones
    public String visitPorExpr(Anasint.OpIntegerContext ctx) {
        String i=visit(ctx.POR());
        String j=visit(ctx.POR());
        return i+"*"+j; }
    //Generar texto correspondiente a suma de expresiones
    public String visitMasExpr(Anasint.OpIntegerContext ctx) {
        String i=visit(ctx.SUMA());
        String j=visit(ctx.SUMA());
        return i+"+"+j; }
}