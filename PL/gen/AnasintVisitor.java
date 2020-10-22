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
	 * Visit a parse tree produced by {@link Anasint#decl_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_var(Anasint.Decl_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(Anasint.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(Anasint.InstContext ctx);
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
	 * Visit a parse tree produced by {@link Anasint#iteracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteracion(Anasint.IteracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#aserto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAserto(Anasint.AsertoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#avance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAvance(Anasint.AvanceContext ctx);
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
	 * Visit a parse tree produced by {@link Anasint#most_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMost_var(Anasint.Most_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Anasint.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#expr_entero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_entero(Anasint.Expr_enteroContext ctx);
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
	 * Visit a parse tree produced by {@link Anasint#expr_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_func(Anasint.Expr_funcContext ctx);
}