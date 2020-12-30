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
        Anasint.Expr_boolContext izq = (Anasint.Expr_boolContext) ctx.getChild(1);
        Anasint.Expr_boolContext dcha = (Anasint.Expr_boolContext) ctx.getChild(3);
        String operador = ctx.getChild(2).getText();
        if(operador.equals("&&")) { return (Boolean) visit(izq)&&(Boolean) visit(dcha); }
        else { return (Boolean) visit(izq)||(Boolean) visit(dcha); }
    }
    public Boolean visitOpBool(Anasint.OpBoolContext ctx) {
        Anasint.Expr_boolContext izq = (Anasint.Expr_boolContext) ctx.getChild(0);
        Anasint.Expr_boolContext dcha = (Anasint.Expr_boolContext) ctx.getChild(2);
        String operador = ctx.getChild(1).getText();
        if(operador.equals("&&")) { return (Boolean) visit(izq)&&(Boolean) visit(dcha); }
        else { return (Boolean) visit(izq)||(Boolean) visit(dcha); }
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
            flujoInstrucciones.pila.clear();
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
        Anasint.Expr_integerContext izq = (Anasint.Expr_integerContext) ctx.getChild(1);
        Anasint.Expr_integerContext dcha = (Anasint.Expr_integerContext) ctx.getChild(3);
        String operador = ctx.getChild(2).getText();
        if(operador.equals("*")) { return (Integer)visit(izq)*(Integer)visit(dcha); }
        else if(operador.equals("+")) { return (Integer)visit(izq)+(Integer)visit(dcha); }
        else { return (Integer)visit(izq)-(Integer)visit(dcha); }
    }

    public Integer visitOpInteger(Anasint.OpIntegerContext ctx) {
        Anasint.Expr_integerContext izq = (Anasint.Expr_integerContext) ctx.getChild(0);
        Anasint.Expr_integerContext dcha = (Anasint.Expr_integerContext) ctx.getChild(2);
        String operador = ctx.getChild(1).getText();
        if(operador.equals("*")) { return (Integer)visit(izq)*(Integer)visit(dcha); }
        else if(operador.equals("+")) { return (Integer)visit(izq)+(Integer)visit(dcha); }
        else { return (Integer)visit(izq)-(Integer)visit(dcha); }
    }

    public Integer visitMenosNum(Anasint.MenosNumContext ctx) {
        return -(Integer)visit(ctx.expr_integer());
    }

    public Integer visitNum(Anasint.NumContext ctx) {
        return Integer.parseInt(ctx.getText());
    }
    public Object visitVarInt(Anasint.VarIntContext ctx) {
        //puede ser una variable log, num o seq
        return (Object) flujoInstrucciones.asig.get(ctx.getText());
    }
}
