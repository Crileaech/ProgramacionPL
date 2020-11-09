import java.util.HashMap;
import java.util.Map;

public class Anasem extends AnasintBaseVisitor<Integer>{
    public Map<String,Map<String,Integer>> variables=new HashMap<>();
    public Map<String,Integer> auxVar=new HashMap<>();

    @Override
    public Integer visitPrograma(Anasint.ProgramaContext ctx) {
        return super.visitPrograma(ctx);
    }

    @Override
    public Integer visitVariables(Anasint.VariablesContext ctx) {
        return super.visitVariables(ctx);
    }

    @Override
    public Integer visitSubprogramas(Anasint.SubprogramasContext ctx) {
        return super.visitSubprogramas(ctx);
    }

    @Override
    public Integer visitInstrucciones(Anasint.InstruccionesContext ctx) {
        return super.visitInstrucciones(ctx);
    }

    @Override
    public Integer visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx) {
        return super.visitDeclaracion_variables(ctx);
    }

    @Override
    public Integer visitIdentificador(Anasint.IdentificadorContext ctx) {
        return super.visitIdentificador(ctx);
    }

    @Override
    public Integer visitElementales(Anasint.ElementalesContext ctx) {
        return super.visitElementales(ctx);
    }

    @Override
    public Integer visitSecuencias(Anasint.SecuenciasContext ctx) {
        return super.visitSecuencias(ctx);
    }

    @Override
    public Integer visitTipos(Anasint.TiposContext ctx) {
        return super.visitTipos(ctx);
    }

    //tipos_elementales: NUMERO {t=entero}
    //             | BOOL   {t=booleano}
    //;
    @Override
    public Integer visitTipos_elementales(Anasint.Tipos_elementalesContext ctx, String funcion, String var) {
        auxVar.put(var,new Integer(ctx.getStart().getType()));
        variables.put(funcion,auxVar);
        return null;;
    }

    //tipos_no_elementales: SEQ_NUM  {t=secuencia entera}
    //                | SEQ_BOOL {t=secuencia booleana}
    @Override
    public Integer visitTipos_no_elementales(Anasint.Tipos_no_elementalesContext ctx, String funcion, String var) {
        auxVar.put(var,new Integer(ctx.getStart().getType()));
        variables.put(funcion,auxVar);
        return null;;
    }

    @Override
    public Integer visitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx) {
        return super.visitDeclaracion_subprogramas(ctx);
    }

    @Override
    public Integer visitFuncion(Anasint.FuncionContext ctx) {
        return super.visitFuncion(ctx);
    }

    @Override
    public Integer visitProcedimiento(Anasint.ProcedimientoContext ctx) {
        return super.visitProcedimiento(ctx);
    }

    @Override
    public Integer visitParams(Anasint.ParamsContext ctx) {
        return super.visitParams(ctx);
    }

    @Override
    public Integer visitExpr(Anasint.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public Integer visitExpr_integer(Anasint.Expr_integerContext ctx) {
        return super.visitExpr_integer(ctx);
    }

    @Override
    public Integer visitExpr_bool(Anasint.Expr_boolContext ctx) {
        return super.visitExpr_bool(ctx);
    }

    @Override
    public Integer visitExpr_seq(Anasint.Expr_seqContext ctx) {
        return super.visitExpr_seq(ctx);
    }

    @Override
    public Integer visitExpr_avanza(Anasint.Expr_avanzaContext ctx) {
        return super.visitExpr_avanza(ctx);
    }

    @Override
    public Integer visitExpr_func(Anasint.Expr_funcContext ctx) {
        return super.visitExpr_func(ctx);
    }

    @Override
    public Integer visitDeclaracion_instrucciones(Anasint.Declaracion_instruccionesContext ctx) {
        return super.visitDeclaracion_instrucciones(ctx);
    }

    @Override
    public Integer visitAsignacion(Anasint.AsignacionContext ctx) {
        return super.visitAsignacion(ctx);
    }

    @Override
    public Integer visitCondicion(Anasint.CondicionContext ctx) {
        return super.visitCondicion(ctx);
    }

    @Override
    public Integer visitBlq_sino(Anasint.Blq_sinoContext ctx) {
        return super.visitBlq_sino(ctx);
    }

    @Override
    public Integer visitIteracion(Anasint.IteracionContext ctx) {
        return super.visitIteracion(ctx);
    }

    @Override
    public Integer visitMostrar(Anasint.MostrarContext ctx) {
        return super.visitMostrar(ctx);
    }

    @Override
    public Integer visitAsertos(Anasint.AsertosContext ctx) {
        return super.visitAsertos(ctx);
    }

    @Override
    public Integer visitCuantificador(Anasint.CuantificadorContext ctx) {
        return super.visitCuantificador(ctx);
    }

    @Override
    public Integer visitCuantificadorUniversal(Anasint.CuantificadorUniversalContext ctx) {
        return super.visitCuantificadorUniversal(ctx);
    }

    @Override
    public Integer visitCuantificadorExistencial(Anasint.CuantificadorExistencialContext ctx) {
        return super.visitCuantificadorExistencial(ctx);
    }

    @Override
    public Integer visitCuantificacion(Anasint.CuantificacionContext ctx) {
        return super.visitCuantificacion(ctx);
    }
}
