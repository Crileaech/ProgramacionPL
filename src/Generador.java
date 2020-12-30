public class Generador extends AnasintBaseVisitor<String> {

    public String visitExpr(Anasint.ExprContext ctx){
        return (String) visit(ctx.getChild(0));
    }

    public String visitExpr_sacar_elem(Anasint.Expr_sacar_elemContext ctx){
        String i = ctx.variable().VAR().getText();
        String j = visit(ctx.expr_integer());
        String res = i+"["+j+"]";
        return res;
    }

    public String visitExpr_Integer(Anasint.Expr_integerContext ctx){
        return (String) visit(ctx.getChild(0));
    }

    public String visitExpr_bool(Anasint.Expr_boolContext ctx){
        return (String) visit(ctx.getChild(0));
    }

    public String visitExpr_seq(Anasint.Expr_seqContext ctx){
        return (String) visit(ctx.getChild(0));
    }

    public String visitVaciaSeq(Anasint.VarSeqContext ctx){
        String res="[];";
        return res;
    }

    public String visitSeq(Anasint.SeqContext ctx){
        Boolean esInteger = true;
        String res = new String();
        System.out.println(ctx.expr(1).getText());
        if((ctx.expr(0).getText().equals("true")) ||(ctx.expr(0).getText().equals("false"))){
            esInteger = false;
        }else if(Compilador.almacen_definiciones_Seq_Bool.containsKey(ctx.expr(0).getText())){
            esInteger = false;
        }
        if(esInteger) {
            res = "new Integer[]{";
        }else{
            res = "new Boolean[]{";
        }
        String aux= new String();
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
        String res = new String();
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
        String res = new String();
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
        String res = new String();
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
        String res = "!"+i;
        return res;
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