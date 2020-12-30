
import java.util.HashSet;
import java.util.Set;
//Extraer variables de una expresion
public class ExtraerVarsExpr extends AnasintBaseVisitor<Set<String>> {

    public Set<String> visitNumExpr(Anasint.Expr_integerContext ctx) {
        return new HashSet<>(); }

    public Set<String> visitMenosExpr(Anasint.OpIntegerContext ctx) {
        Set<String> s= new HashSet<>();
        s.addAll(visit(ctx.RESTA()));
        s.addAll(visit(ctx.RESTA()));
        return s; }

    public Set<String> visitPorExpr(Anasint.OpIntegerContext ctx) {
        Set<String> s=new HashSet<>();
        s.addAll(visit(ctx.POR()));
        s.addAll(visit(ctx.POR()));
        return s; }
    public Set<String> visitMasExpr(Anasint.OpIntegerContext ctx) {
        Set<String> s= new HashSet<>();
        s.addAll(visit(ctx.SUMA()));
        s.addAll(visit(ctx.SUMA()));
        return s; }


}