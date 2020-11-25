import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;
import java.util.Map;

public class Almacenes extends AnasintBaseListener{
    public static Map<String,Map<String, Map<String, String>>> almacenF = new HashMap<>();
    public static Map<String,String> almacenGlobal = new HashMap<>();

    public Almacenes(ParseTree tree) {
        AlmacenGlobal g = new AlmacenGlobal();
        AlmacenFunciones v = new AlmacenFunciones();
        this.almacenGlobal = (Map<String,String>) g.visit(tree);
        this.almacenF = (Map<String, Map<String, Map<String, String>>>) v.visit(tree);
        ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        walker.walk(new compruebaDeclaracion(), tree);

    }

}