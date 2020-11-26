import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class compruebaVariables extends AnasintBaseVisitor<Object> {


    // DECISION 5


    @Override
    public List<String> visitPrograma(Anasint.ProgramaContext ctx) {
        List<String> res = new ArrayList<String>();
        res = (List<String>) visit(ctx.instrucciones());
        System.out.println(res);
        return (List<String>) visit(ctx.instrucciones());
    }

    @Override
    public List<String> visitInstrucciones(Anasint.InstruccionesContext ctx) {
        List<String> res = new ArrayList<String>();
        List<String> aux = new ArrayList<String>();
        for(int i=1;i<ctx.getChildCount();i++){
            aux = (List<String>) visit(ctx.getChild(i));
            res.addAll(aux);
        }
        return res;
    }

    public List<String> visitDeclaracion_instrucciones(Anasint.Declaracion_instruccionesContext ctx){
        return (List<String>) visit(ctx.getChild(0));
    }

    @Override
    public List<String> visitAsignacion(Anasint.AsignacionContext ctx) {
        List<String> res = new ArrayList<String>();
        String variable = ctx.getChild(0).getText();
        res.add(variable);
        for(int i=2;i<ctx.getChildCount();i++) {
            String aux = ctx.getChild(i).getText();
            if (!(aux.isEmpty())) {
                res.add(aux);
            }
        }
        return res;
    }

    @Override
    public Object visitDevolucion(Anasint.DevolucionContext ctx) {
        return super.visitDevolucion(ctx);
    }

    @Override
    public List<String> visitCondicion(Anasint.CondicionContext ctx) {
        List<String> res = new ArrayList<String>();
        res.add(ctx.getChild(1).getText());
        return res;
    }

    @Override
    public Object visitBlq_sino(Anasint.Blq_sinoContext ctx) {
        return super.visitBlq_sino(ctx);
    }

    @Override
    public List<String> visitIteracion(Anasint.IteracionContext ctx) {
        return (List<String>) visit(ctx.expr_bool());
    }

    @Override
    public String visitExpr(Anasint.ExprContext ctx) {
        return (String) visit(ctx.getChild(0));
    }

    @Override
    public String visitExpr_integer(Anasint.Expr_integerContext ctx) {
        return (String) visit(ctx.variable());
    }

    @Override
    public String visitExpr_bool(Anasint.Expr_boolContext ctx) {
        return (String) visit(ctx.variable());
    }

    @Override
    public String visitExpr_seq(Anasint.Expr_seqContext ctx) {
        return (String) visit(ctx.variable());
    }

    @Override
    public String visitVariable(Anasint.VariableContext ctx) {
        return ctx.getText();
    }
}
