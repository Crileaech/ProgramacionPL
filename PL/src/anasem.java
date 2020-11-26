import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;

public class anasem extends AnasintBaseListener{
    public static Map<String,Map<String, Map<String, String>>> almacenF = new HashMap<>();
    public static Map<String,String> almacenGlobal = new HashMap<>();

    public anasem(ParseTree tree) {
        AlmacenGlobal g = new AlmacenGlobal();
        AlmacenFunciones v = new AlmacenFunciones();
        this.almacenGlobal = (Map<String,String>) g.visit(tree);
        this.almacenF = (Map<String, Map<String, Map<String, String>>>) v.visit(tree);
        CompruebaDevolución c = new CompruebaDevolución();
        c.visit(tree);
    }

}
