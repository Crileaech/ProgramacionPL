// Generated from C:/Users/Enrique/Desktop/PL/ProgramacionPL (1)/src\Anasint.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Anasint}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnasintVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Anasint#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(Anasint.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(Anasint.VariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#subprogramas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubprogramas(Anasint.SubprogramasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(Anasint.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#declaracion_variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(Anasint.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#elementales}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementales(Anasint.ElementalesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#secuencias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecuencias(Anasint.SecuenciasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#tipos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipos(Anasint.TiposContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#tipos_elementales}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipos_elementales(Anasint.Tipos_elementalesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#tipos_no_elementales}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipos_no_elementales(Anasint.Tipos_no_elementalesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(Anasint.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#declaracion_subprogramas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(Anasint.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#procedimiento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedimiento(Anasint.ProcedimientoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(Anasint.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Anasint.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code menosNum}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenosNum(Anasint.MenosNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opInteger}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpInteger(Anasint.OpIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFuncInt}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFuncInt(Anasint.ExprFuncIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sacarElemInteger}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code num}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(Anasint.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentesisOpInteger}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varInt}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInt(Anasint.VarIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negacionBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegacionBool(Anasint.NegacionBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentesisOpBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentesisOpBool(Anasint.ParentesisOpBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(Anasint.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(Anasint.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpBool(Anasint.OpBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compararInteger}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompararInteger(Anasint.CompararIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sacarElemBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSacarElemBool(Anasint.SacarElemBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarBool(Anasint.VarBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFuncBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFuncBool(Anasint.ExprFuncBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compararBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompararBool(Anasint.CompararBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compararSeq}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompararSeq(Anasint.CompararSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vaciaSeq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVaciaSeq(Anasint.VaciaSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(Anasint.SeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFuncSeq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFuncSeq(Anasint.ExprFuncSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varSeq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSeq(Anasint.VarSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#expr_sacar_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_sacar_elem(Anasint.Expr_sacar_elemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#expr_avanza}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_avanza(Anasint.Expr_avanzaContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#expr_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_func(Anasint.Expr_funcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asig}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsig(Anasint.AsigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(Anasint.CondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code it}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIt(Anasint.ItContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(Anasint.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dev}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDev(Anasint.DevContext ctx);
	/**
	 * Visit a parse tree produced by the {@code show}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow(Anasint.ShowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aserto}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAserto(Anasint.AsertoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprfun}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprfun(Anasint.ExprfunContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#devolucion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDevolucion(Anasint.DevolucionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(Anasint.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion(Anasint.CondicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#blq_sino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlq_sino(Anasint.Blq_sinoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#iteracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteracion(Anasint.IteracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#mostrar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMostrar(Anasint.MostrarContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#asertos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsertos(Anasint.AsertosContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#cuantificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuantificador(Anasint.CuantificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#cuantificadorUniversal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuantificadorUniversal(Anasint.CuantificadorUniversalContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#cuantificadorExistencial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuantificadorExistencial(Anasint.CuantificadorExistencialContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#cuantificacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuantificacion(Anasint.CuantificacionContext ctx);
}