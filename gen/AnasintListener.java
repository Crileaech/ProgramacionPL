// Generated from C:/Users/Enrique/Desktop/PL/ProgramacionPL (1)/src\Anasint.g4 by ANTLR 4.9
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
	 * Enter a parse tree produced by the {@code menosNum}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void enterMenosNum(Anasint.MenosNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code menosNum}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void exitMenosNum(Anasint.MenosNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opInteger}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void enterOpInteger(Anasint.OpIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opInteger}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void exitOpInteger(Anasint.OpIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFuncInt}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void enterExprFuncInt(Anasint.ExprFuncIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFuncInt}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void exitExprFuncInt(Anasint.ExprFuncIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sacarElemInteger}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void enterSacarElemInteger(Anasint.SacarElemIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sacarElemInteger}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void exitSacarElemInteger(Anasint.SacarElemIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void enterNum(Anasint.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void exitNum(Anasint.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentesisOpInteger}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void enterParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentesisOpInteger}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void exitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varInt}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void enterVarInt(Anasint.VarIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varInt}
	 * labeled alternative in {@link Anasint#expr_integer}.
	 * @param ctx the parse tree
	 */
	void exitVarInt(Anasint.VarIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negacionBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterNegacionBool(Anasint.NegacionBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negacionBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitNegacionBool(Anasint.NegacionBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentesisOpBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterParentesisOpBool(Anasint.ParentesisOpBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentesisOpBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitParentesisOpBool(Anasint.ParentesisOpBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterTrue(Anasint.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitTrue(Anasint.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code false}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterFalse(Anasint.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code false}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitFalse(Anasint.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterOpBool(Anasint.OpBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitOpBool(Anasint.OpBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compararInteger}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterCompararInteger(Anasint.CompararIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compararInteger}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitCompararInteger(Anasint.CompararIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sacarElemBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterSacarElemBool(Anasint.SacarElemBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sacarElemBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitSacarElemBool(Anasint.SacarElemBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterVarBool(Anasint.VarBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitVarBool(Anasint.VarBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFuncBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterExprFuncBool(Anasint.ExprFuncBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFuncBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitExprFuncBool(Anasint.ExprFuncBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compararBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterCompararBool(Anasint.CompararBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compararBool}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitCompararBool(Anasint.CompararBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compararSeq}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void enterCompararSeq(Anasint.CompararSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compararSeq}
	 * labeled alternative in {@link Anasint#expr_bool}.
	 * @param ctx the parse tree
	 */
	void exitCompararSeq(Anasint.CompararSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vaciaSeq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void enterVaciaSeq(Anasint.VaciaSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vaciaSeq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void exitVaciaSeq(Anasint.VaciaSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void enterSeq(Anasint.SeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void exitSeq(Anasint.SeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFuncSeq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void enterExprFuncSeq(Anasint.ExprFuncSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFuncSeq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void exitExprFuncSeq(Anasint.ExprFuncSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varSeq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void enterVarSeq(Anasint.VarSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varSeq}
	 * labeled alternative in {@link Anasint#expr_seq}.
	 * @param ctx the parse tree
	 */
	void exitVarSeq(Anasint.VarSeqContext ctx);
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
	 * Enter a parse tree produced by the {@code asig}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterAsig(Anasint.AsigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asig}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitAsig(Anasint.AsigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cond}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterCond(Anasint.CondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cond}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitCond(Anasint.CondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code it}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterIt(Anasint.ItContext ctx);
	/**
	 * Exit a parse tree produced by the {@code it}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitIt(Anasint.ItContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterBreak(Anasint.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitBreak(Anasint.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dev}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterDev(Anasint.DevContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dev}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitDev(Anasint.DevContext ctx);
	/**
	 * Enter a parse tree produced by the {@code show}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterShow(Anasint.ShowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code show}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitShow(Anasint.ShowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aserto}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterAserto(Anasint.AsertoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aserto}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitAserto(Anasint.AsertoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprfun}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void enterExprfun(Anasint.ExprfunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprfun}
	 * labeled alternative in {@link Anasint#declaracion_instrucciones}.
	 * @param ctx the parse tree
	 */
	void exitExprfun(Anasint.ExprfunContext ctx);
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