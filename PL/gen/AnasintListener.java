// Generated from F:/Universidad/TI/PL/ProgramacionPL-enrfercor/PL/src\Anasint.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Anasint}.
 */
public interface AnasintListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Anasint#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(Anasint.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(Anasint.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(Anasint.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(Anasint.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#subprogramas}.
	 * @param ctx the parse tree
	 */
	void enterSubprogramas(Anasint.SubprogramasContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#subprogramas}.
	 * @param ctx the parse tree
	 */
	void exitSubprogramas(Anasint.SubprogramasContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterInstrucciones(Anasint.InstruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitInstrucciones(Anasint.InstruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#declaracion_variables}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_variables(Anasint.Declaracion_variablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#declaracion_variables}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(Anasint.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(Anasint.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#elementales}.
	 * @param ctx the parse tree
	 */
	void enterElementales(Anasint.ElementalesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#elementales}.
	 * @param ctx the parse tree
	 */
	void exitElementales(Anasint.ElementalesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#secuencias}.
	 * @param ctx the parse tree
	 */
	void enterSecuencias(Anasint.SecuenciasContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#secuencias}.
	 * @param ctx the parse tree
	 */
	void exitSecuencias(Anasint.SecuenciasContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#tipos}.
	 * @param ctx the parse tree
	 */
	void enterTipos(Anasint.TiposContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#tipos}.
	 * @param ctx the parse tree
	 */
	void exitTipos(Anasint.TiposContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#tipos_elementales}.
	 * @param ctx the parse tree
	 */
	void enterTipos_elementales(Anasint.Tipos_elementalesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#tipos_elementales}.
	 * @param ctx the parse tree
	 */
	void exitTipos_elementales(Anasint.Tipos_elementalesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#tipos_no_elementales}.
	 * @param ctx the parse tree
	 */
	void enterTipos_no_elementales(Anasint.Tipos_no_elementalesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#tipos_no_elementales}.
	 * @param ctx the parse tree
	 */
	void exitTipos_no_elementales(Anasint.Tipos_no_elementalesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(Anasint.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(Anasint.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#declaracion_subprogramas}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#declaracion_subprogramas}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(Anasint.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(Anasint.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#procedimiento}.
	 * @param ctx the parse tree
	 */
	void enterProcedimiento(Anasint.ProcedimientoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#procedimiento}.
	 * @param ctx the parse tree
	 */
	void exitProcedimiento(Anasint.ProcedimientoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(Anasint.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(Anasint.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Anasint.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Anasint.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void enterExpr_integer(Anasint.Expr_integerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void exitExpr_integer(Anasint.Expr_integerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterExpr_bool(Anasint.Expr_boolContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitExpr_bool(Anasint.Expr_boolContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void enterExpr_seq(Anasint.Expr_seqContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void exitExpr_seq(Anasint.Expr_seqContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#expr_sacar_elem}.
	 * @param ctx the parse tree
	 */
	void enterExpr_sacar_elem(Anasint.Expr_sacar_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#expr_sacar_elem}.
	 * @param ctx the parse tree
	 */
	void exitExpr_sacar_elem(Anasint.Expr_sacar_elemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#expr_avanza}.
	 * @param ctx the parse tree
	 */
	void enterExpr_avanza(Anasint.Expr_avanzaContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#expr_avanza}.
	 * @param ctx the parse tree
	 */
	void exitExpr_avanza(Anasint.Expr_avanzaContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#expr_func}.
	 * @param ctx the parse tree
	 */
	void enterExpr_func(Anasint.Expr_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#expr_func}.
	 * @param ctx the parse tree
	 */
	void exitExpr_func(Anasint.Expr_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_instrucciones(Anasint.Declaracion_instruccionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_instrucciones(Anasint.Declaracion_instruccionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#devolucion}.
	 * @param ctx the parse tree
	 */
	void enterDevolucion(Anasint.DevolucionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#devolucion}.
	 * @param ctx the parse tree
	 */
	void exitDevolucion(Anasint.DevolucionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(Anasint.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(Anasint.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(Anasint.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(Anasint.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#blq_sino}.
	 * @param ctx the parse tree
	 */
	void enterBlq_sino(Anasint.Blq_sinoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#blq_sino}.
	 * @param ctx the parse tree
	 */
	void exitBlq_sino(Anasint.Blq_sinoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#iteracion}.
	 * @param ctx the parse tree
	 */
	void enterIteracion(Anasint.IteracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#iteracion}.
	 * @param ctx the parse tree
	 */
	void exitIteracion(Anasint.IteracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#mostrar}.
	 * @param ctx the parse tree
	 */
	void enterMostrar(Anasint.MostrarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#mostrar}.
	 * @param ctx the parse tree
	 */
	void exitMostrar(Anasint.MostrarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#asertos}.
	 * @param ctx the parse tree
	 */
	void enterAsertos(Anasint.AsertosContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#asertos}.
	 * @param ctx the parse tree
	 */
	void exitAsertos(Anasint.AsertosContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#cuantificador}.
	 * @param ctx the parse tree
	 */
	void enterCuantificador(Anasint.CuantificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#cuantificador}.
	 * @param ctx the parse tree
	 */
	void exitCuantificador(Anasint.CuantificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#cuantificadorUniversal}.
	 * @param ctx the parse tree
	 */
	void enterCuantificadorUniversal(Anasint.CuantificadorUniversalContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#cuantificadorUniversal}.
	 * @param ctx the parse tree
	 */
	void exitCuantificadorUniversal(Anasint.CuantificadorUniversalContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#cuantificadorExistencial}.
	 * @param ctx the parse tree
	 */
	void enterCuantificadorExistencial(Anasint.CuantificadorExistencialContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#cuantificadorExistencial}.
	 * @param ctx the parse tree
	 */
	void exitCuantificadorExistencial(Anasint.CuantificadorExistencialContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#cuantificacion}.
	 * @param ctx the parse tree
	 */
	void enterCuantificacion(Anasint.CuantificacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#cuantificacion}.
	 * @param ctx the parse tree
	 */
	void exitCuantificacion(Anasint.CuantificacionContext ctx);
}