import java.util.*;
import java.util.stream.Collectors;

public class asignaciones extends AnasintBaseListener{
    public static Map<String,Anasint.ExprContext> asig = new LinkedHashMap<>();

    //Asigna a cada var su expr correspondiente.
    public void enterAsignacion(Anasint.AsignacionContext ctx) {
        List<String> vars = ctx.variable().stream().map(v -> v.getText()).collect(Collectors.toList());
        List<Anasint.ExprContext> asign = ctx.expr();
        for(int i=0; i<vars.size(); i++) {
            asig.put(vars.get(i), asign.get(i));
        }
        muestra();
    }
    public void muestra() {
        System.out.println(asig);
    }
}
