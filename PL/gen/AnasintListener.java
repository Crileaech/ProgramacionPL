// Generated from C:/Users/Enrique/Desktop/PL/src\Anasint.g4 by ANTLR 4.8
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
	 * Enter a parse tree produced by {@link Anasint#decl_var}.
	 * @param ctx the parse tree
	 */
	void enterDecl_var(Anasint.Decl_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#decl_var}.
	 * @param ctx the parse tree
	 */
	void exitDecl_var(Anasint.Decl_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(Anasint.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(Anasint.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(Anasint.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(Anasint.TipoContext ctx);
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
	 * Enter a parse tree produced by {@link Anasint#inst}.
	 * @param ctx the parse tree
	 */
	void enterInst(Anasint.InstContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#inst}.
	 * @param ctx the parse tree
	 */
	void exitInst(Anasint.InstContext ctx);
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
	 * Enter a parse tree produced by {@link Anasint#aserto}.
	 * @param ctx the parse tree
	 */
	void enterAserto(Anasint.AsertoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#aserto}.
	 * @param ctx the parse tree
	 */
	void exitAserto(Anasint.AsertoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#avance}.
	 * @param ctx the parse tree
	 */
	void enterAvance(Anasint.AvanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#avance}.
	 * @param ctx the parse tree
	 */
	void exitAvance(Anasint.AvanceContext ctx);
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
	 * Enter a parse tree produced by {@link Anasint#most_var}.
	 * @param ctx the parse tree
	 */
	void enterMost_var(Anasint.Most_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#most_var}.
	 * @param ctx the parse tree
	 */
	void exitMost_var(Anasint.Most_varContext ctx);
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
	 * Enter a parse tree produced by {@link Anasint#expr_entero}.
	 * @param ctx the parse tree
	 */
	void enterExpr_entero(Anasint.Expr_enteroContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#expr_entero}.
	 * @param ctx the parse tree
	 */
	void exitExpr_entero(Anasint.Expr_enteroContext ctx);
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
	 * Enter a parse tree produced by {@link Anasint#expr_func}.
	 * @param ctx the parse tree
	 */
	void enterExpr_func(Anasint.Expr_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#expr_func}.
	 * @param ctx the parse tree
	 */
	void exitExpr_func(Anasint.Expr_funcContext ctx);
}