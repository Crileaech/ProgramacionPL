import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;

public class anasem extends AnasintBaseListener{
    public static Map<String,Map<String, Map<String, String>>> almacenF = new HashMap<>();

    public anasem(ParseTree tree) {
        System.out.println();
        AlmacenFunciones v = new AlmacenFunciones();
        this.almacenF = (Map<String, Map<String, Map<String, String>>>) v.visit(tree);
        CompruebaDevolución c = new CompruebaDevolución(tree);
        c.visit(tree);

    }

    public static void main(String[] args) {
        System.out.println(almacenF);
    }

}
