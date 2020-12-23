import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Map;

public class evaluador {
    public evaluador(ParseTree tree) {
        evaluaExpr evalua = new evaluaExpr();
        //System.out.println("INTÉRPRETE");
        /*for(Map.Entry<String,Anasint.ExprContext> kv:flujoInstrucciones.asig.entrySet()) {
            if(kv.getValue()!=null) {
                System.out.println("(asignación) " + kv.getKey() + " <- " + evalua.visit(kv.getValue()));
            }
        }*/
    }
}
