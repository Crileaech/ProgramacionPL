import java.util.ArrayList;
import java.util.List;

public class Generador extends AnasintBaseVisitor<String> {
    //Generar texto correspondiente a variable
//    public String visitIdExpr(Anasint.IdExprContext ctx) {
//        return ctx.VAR().getText();
//    }

    public String visitExpr(Anasint.ExprContext ctx){
        return visit(ctx.getChild(0));
    }

    public String visitExpr_sacar_elem(Anasint.Expr_sacar_elemContext ctx){
        String i = ctx.variable().VAR().getText();
        String j = visit(ctx.expr_integer());
        return  i+"["+j+"]";
    }

    public String visitExpr_func(Anasint.Expr_funcContext ctx){
        String res;
        String k = ctx.variable().VAR().getText();
        res = k+"(";
        List<Anasint.ExprContext> expresiones = iterarExprs(ctx.exprs());
        for(Anasint.ExprContext expr: expresiones){
            res += visit(expr);
        }
        res +=")";
        return res;
    }

    public String visitSeq(Anasint.SeqContext ctx){
        Boolean esInteger = true;
        String res = "";
        if((ctx.expr(0).getText().equals("true")) ||(ctx.expr(0).getText().equals("false")) ||
            (ctx.expr(0).getText().equals("T")) || (ctx.expr(0).getText().equals("F"))){
            esInteger = false;
        }else if(Compilador.almacen_definiciones_Seq_Bool.containsKey(ctx.expr(0).getText()) ||
            Compilador.almacen_definiciones_Seq_Bool_Temporal.containsKey(ctx.expr(0).getText())){
            esInteger = false;
        }
        if(esInteger) {
            res = "new Integer[]{";
        }else{
             res = "new Boolean[]{";
        }
        String aux= "";
        for(int i=0;i<ctx.expr().size();i++){
            aux = visit(ctx.expr(i));
            res += aux;
            if(i+1 != ctx.expr().size()){
                res += ",";
            }else{
                res += "}";
            }
        }
        return res;
    }

    public String visitVarSeq(Anasint.VarSeqContext ctx){
        return ctx.variable().VAR().getText();
    }

    public String visitTrue(Anasint.TrueContext ctx){
        return "true";
    }

    public String visitFalse(Anasint.FalseContext ctx){
        return "false";
    }

    public String visitSacarElemBool(Anasint.SacarElemBoolContext ctx){
        return visit(ctx.getChild(0));
    }

    public String visitCompararBool(Anasint.CompararBoolContext ctx){
        String res = "";
        if(ctx.getChild(1)==ctx.IGUALL()){
            String i=visit(ctx.expr_bool(0));
            String j=visit(ctx.expr_bool(1));
            res = i+"=="+j;
        }
        if(ctx.getChild(2)==ctx.DISTINTO()){
            String i=visit(ctx.expr_bool(0));
            String j=visit(ctx.expr_bool(1));
            res = i+"!="+j;
        }
        return res;
    }
    public String visitParentesisOpBool(Anasint.ParentesisOpBoolContext ctx){
        String res = "(";
        if(ctx.getChild(2)==ctx.AND()){
            String i=visit(ctx.expr_bool(0));
            String j=visit(ctx.expr_bool(1));
            res += i+"&&"+j;
        }
        if(ctx.getChild(2)==ctx.OR()){
            String i=visit(ctx.expr_bool(0));
            String j=visit(ctx.expr_bool(1));
            res += i+"||"+j;
        }
        res += ")";
        return res;
    }
    public String visitOpBool(Anasint.OpBoolContext ctx){
        String res = "";
        if(ctx.getChild(1)==ctx.AND()){
            String i=visit(ctx.expr_bool(0));
            String j=visit(ctx.expr_bool(1));
            res = i+"&&"+j;
        }
        if(ctx.getChild(1)==ctx.OR()){
            String i=visit(ctx.expr_bool(0));
            String j=visit(ctx.expr_bool(1));
            res = i+"||"+j;
        }
        return res;
    }

    public String visitCompararInteger(Anasint.CompararIntegerContext ctx){
        String res = "";
        if(ctx.getChild(1)==ctx.MENORIGUAL()) {
            String i = visit(ctx.expr_integer(0));
            String j = visit(ctx.expr_integer(1));
            res = i + "<=" + j;
        }
        if(ctx.getChild(1)==ctx.MAYORIGUAL()) {
            String i = visit(ctx.expr_integer(0));
            String j = visit(ctx.expr_integer(1));
            res = i + ">=" + j;
        }
        if(ctx.getChild(1)==ctx.MENOR()) {
            String i = visit(ctx.expr_integer(0));
            String j = visit(ctx.expr_integer(1));
            res = i + "<" + j;
        }
        if(ctx.getChild(1)==ctx.MAYOR()) {
            String i = visit(ctx.expr_integer(0));
            String j = visit(ctx.expr_integer(1));
            res = i + ">" + j;
        }
        if(ctx.getChild(1)==ctx.IGUALL()) {
            String i = visit(ctx.expr_integer(0));
            String j = visit(ctx.expr_integer(1));
            res = i + "==" + j;
        }
        if(ctx.getChild(1)==ctx.DISTINTO()) {
            String i = visit(ctx.expr_integer(0));
            String j = visit(ctx.expr_integer(1));
            res = i + "!=" + j;
        }
        return res;
    }

    public String visitNegacionBool(Anasint.NegacionBoolContext ctx){
        String i=visit(ctx.expr_bool());
        return "!"+i;
    }

    public String visitVarBool(Anasint.VarBoolContext ctx){
        return ctx.variable().VAR().getText();
    }

    public String visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx){
        return visit(ctx.getChild(0));
    }

    public String visitVarInt(Anasint.VarIntContext ctx) {
        return ctx.variable().VAR().getText();
    }

    //Generar texto correspondiente a número
    public String visitNum(Anasint.NumContext ctx) {
        return ctx.getText();
    }

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
        return res;
    }

    public String visitOpInteger(Anasint.OpIntegerContext ctx){
        String res = "";
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

    public List<Anasint.ExprContext> iterarExprs(Anasint.ExprsContext ctx){
        List<Anasint.ExprContext> l = new ArrayList<>();
        l.add(ctx.expr());
        if(ctx.exprs()!=null)
            l.addAll(iterarExprs(ctx.exprs()));

        return l;
    }

}
