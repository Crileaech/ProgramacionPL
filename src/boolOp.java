import java.util.Map;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class boolOp extends AnasintBaseVisitor<Object>{
    private String boolOp;
    private Map<String,Object> asig;

    private final evaluaExpr evalua = new evaluaExpr();

    public boolOp(Anasint.OpBoolContext ctx, Map<String, Object> asig) {
        this.boolOp = (String) visit(ctx);
        this.asig = asig;
    }

    public boolOp(Anasint.ParentesisOpBoolContext ctx, Map<String, Object> asig) {
        this.boolOp = (String) visit(ctx);
        this.asig = asig;
    }

    public String visitOpBool(Anasint.OpBoolContext ctx) {
        return visit(ctx.getChild(0))+ctx.getChild(1).getText()+visit(ctx.getChild(2));
    }

    public String visitParentesisOpBool(Anasint.ParentesisOpBoolContext ctx) {
        return "(" + visit(ctx.getChild(1))+ctx.getChild(2).getText()
                +visit(ctx.getChild(3)) + ")";
    }

    public String visitTrue(Anasint.TrueContext ctx) { return "true"; }
    public String visitFalse(Anasint.FalseContext ctx) { return "false"; }
    public String visitSacarElemBool(Anasint.SacarElemBoolContext ctx) { return evalua.visit(ctx).toString(); }
    public String visitCompararBool(Anasint.CompararBoolContext ctx) { return evalua.visit(ctx).toString(); }
    public String visitCompararSeq(Anasint.CompararSeqContext ctx) { return evalua.visit(ctx).toString(); }
    public String visitCompararInteger(Anasint.CompararIntegerContext ctx) { return evalua.visit(ctx).toString(); }
    public String visitNegacionBool(Anasint.NegacionBoolContext ctx) {
        String res = "";
        for(int i=0; i<ctx.getChildCount();i++) {
            if(ctx.getChild(i).getText().equals("!")) {
                res += "!";
            } else {
                res += visit(ctx.getChild(i));
            }
        }
        return res;
    }
    public String visitExpr_func(Anasint.Expr_funcContext ctx) {
        return "true";
    }
    public String visitVariable(Anasint.VariableContext ctx) { return evalua.visit(ctx).toString(); }
    public String visitVarBool(Anasint.VarBoolContext ctx) { return evalua.visit(ctx).toString(); }

    public Boolean resultado() {
        System.out.println("hola " + boolOp);
        if(boolOp.contains("(")) {
            Matcher m = Pattern.compile("\\((.*?)\\)").matcher(boolOp);
            String res = boolOp;
            while(m.find()) {
                String dentroParentesis = m.group(1);
                String calculo = calcula(dentroParentesis).toString();
                res = res.replace(dentroParentesis, calculo);
            }
            res = res.replace("(","");
            res = res.replace(")","");
            System.out.println(res);
            return calcula(res);
        } else {
            return calcula(boolOp);
        }
    }

    public Boolean calcula(String aCalc) {
        //prioridad 1: ! -> Fácil con replace.
        aCalc = aCalc.replace("!false","true");
        aCalc = aCalc.replace("!true", "false");
        Boolean res = opera(aCalc);
        return res;
    }

    //función recursiva.
    //true&&false||true -> opera calcula true&&false -> false. Genera un aCalc nuevo -> false||true.
    //calcula de nuevo false||true -> Genera aCalc nuevo -> true -> caso base, retorna Boolean true.
    public Boolean opera(String aCalc) {
        Character v = aCalc.charAt(0);
        Boolean op1;
        Boolean op2;
        Boolean resultado;
        if(aCalc.length()<=5) {
            resultado = aCalc.equals("true") ? true : false;
        } else {
            if(v=='t') {
                aCalc = aCalc.substring(4,aCalc.length());
                op1 = true;
            } else {
                aCalc = aCalc.substring(5,aCalc.length());
                op1 = false;
            }
            v = aCalc.charAt(2);
            Boolean esAnd = aCalc.charAt(0)=='&';
            if(v=='t') {
                aCalc = aCalc.substring(6,aCalc.length());
                op2 = true;
            } else {
                aCalc = aCalc.substring(7,aCalc.length());
                op2 = false;
            }
            Boolean res = esAnd ? op1&&op2 : op1||op2;
            aCalc = res.toString() + aCalc;
            resultado = opera(aCalc);
        }
        return resultado;
    }
}
