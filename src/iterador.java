import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class iterador extends AnasintBaseVisitor<Object>{

    ParseTreeWalker walker = new ParseTreeWalker();
    private Integer valorAnteriorAvanza = null;

    public Object visitIt(Anasint.ItContext ctx) {
        return visit(ctx.iteracion());
    }

    public Object visitIteracion(Anasint.IteracionContext ctx) {
        evaluaExpr evalua = new evaluaExpr(subprogramaAPartirDeIteracion(ctx));
        //miro si se cumple la condición del while
        Boolean cond = (Boolean) evalua.visit(ctx.expr_bool());
        if(cond) flujoInstrucciones.muestraConIdentación("(iteración) mientras " + ctx.expr_bool().getText(), 1);
        Boolean entra = cond; //centinela para ver si ha entrado al menos una vez.
        //si es así pongo mensaje de fin de iteración
        //¿por qué compruebo si la cima es true para entrar en este while? Porque aunque en el enterIt solo llame
        //a esta clase si pila.peek es true, si en algunas de estas instrucciones de dentro del while hay una
        // ruptura, la cima será false y deberemos parar este while. Es cierto que al estar la cima a false,
        //las instrucciones del while no se ejecutarían, pero al no ejecutarse no se modificarían variables
        // y cond siempre sería true -> bucle infinito. De ninguna de las maneras debemos entrar en este while
        //en este caso.

        avanza(ctx.expr_avanza(), evalua);
        Boolean avanza = true;
        while(cond&&Principal.asig.pila.peek()) {
            //mientras se cumpla la condición
            for(int i = 0; i < ctx.getChildCount(); i++) {
                //llamo al walker para que camine sobre los hijos de la iteración.
                walker.walk(Principal.asig,ctx.getChild(i));
            }
            avanza = avanza(ctx.expr_avanza(), evalua);
            cond = (Boolean) evalua.visit(ctx.expr_bool());
        }
        if(entra&&avanza) flujoInstrucciones.muestraConIdentación("(fin iteración)", 1);

        //si no se pone se ejecuta el cuerpo de la iteración una vez más, pero... ¿por qué?
        //Cuando hacemos enterIt, posteriormente el walker caminará sobre los hijos de dicha
        //it. Lo que sucede es que nosotros hemos controlado la ejecución de dichos hijos mediante
        //un visitor. Cuando se concluye el it.visit, si en la pila hay true, entrará de nuevo
        //en declaración de instrucciones y ejecutará una vez más las instrucciones de la iteración.
        //por ello debemos poner en la cima de la pila un false.
        Principal.asig.pila.pop();
        Principal.asig.pila.push(false);
        return null;
    }

    private Boolean avanza(Anasint.Expr_avanzaContext ctx, evaluaExpr evalua) {
        if(ctx!=null) {
            if(valorAnteriorAvanza==null) {
                flujoInstrucciones.muestraConIdentación("----AVANZA----");
                List<Object> valoresDevueltos = (List<Object>) evalua.visit(ctx.expr_func());
                flujoInstrucciones.muestraConIdentación("--FIN AVANZA--");
                valorAnteriorAvanza = (Integer) valoresDevueltos.get(1);
            } else {
                flujoInstrucciones.muestraConIdentación("----AVANZA----");
                List<Object> valoresDevueltos = (List<Object>) evalua.visit(ctx.expr_func());
                flujoInstrucciones.muestraConIdentación("--FIN AVANZA--");
                Integer valorActual = (Integer) valoresDevueltos.get(1);
                if(valorActual>=valorAnteriorAvanza) {
                    flujoInstrucciones.finalizaEjecución();
                    flujoInstrucciones.muestraConIdentación("(fin iteración) Iteración errónea." +
                            " Los valores de avanza no decrecen", 1);
                    return false;
                }
            }

        }
        return true;
    }

    private Anasint.SubprogramasContext subprogramaAPartirDeIteracion(Anasint.IteracionContext ctx) {
        ParserRuleContext padre = ctx.getParent();
        while(true) {
            if(padre.getChild(0).getText().equals("PROGRAMA")) {
                break;
            }
            padre = padre.getParent();
        }
        return (Anasint.SubprogramasContext) padre.getChild(2);
    }
}