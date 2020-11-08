// Generated from C:/Users/Enrique/Desktop/PL/src\Anasint.g4 by ANTLR 4.8
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
	 * Visit a parse tree produced by {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_integer(Anasint.Expr_integerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_bool(Anasint.Expr_boolContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_seq(Anasint.Expr_seqContext ctx);
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
	 * Visit a parse tree produced by {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_instrucciones(Anasint.Declaracion_instruccionesContext ctx);
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