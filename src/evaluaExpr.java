import org.antlr.v4.runtime.tree.TerminalNode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class evaluaExpr extends AnasintBaseVisitor<Object>{

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
    public Object visitExprFuncSeq(Anasint.ExprFuncSeqContext ctx) {
        // TODO: 12/12/20
        return visitChildren(ctx);
    }
    public List<Object> visitVarSeq(Anasint.VarSeqContext ctx) {
        return (List<Object>) flujoInstrucciones.asig.get(ctx.getText());
    }

    public Integer visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx) {
        return (Integer) visit(ctx.expr_sacar_elem());
    }
    public Integer visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx) {
        //(2-4)
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
