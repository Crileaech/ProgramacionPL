import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.swing.*;
import java.util.Arrays;

public class iterador extends AnasintBaseVisitor<Object>{

    ParseTreeWalker walker = new ParseTreeWalker();
    private final evaluaExpr evalua = new evaluaExpr();

    public Object visitIt(Anasint.ItContext ctx) {
        return visit(ctx.iteracion());
    }

    public Object visitIteracion(Anasint.IteracionContext ctx) {
        //miro si se cumple la condición del while
        Boolean cond = (Boolean) evalua.visit(ctx.expr_bool());
        if(cond) System.out.println("(iteración) mientras " + ctx.expr_bool().getText());
        Boolean entra = cond; //centinela para ver si ha entrado al menos una vez.
        //si es así pongo mensaje de fin de iteración

        //¿por qué compruebo si la cima es true para entrar en este while? Porque aunque en el enterIt solo llame
        //a esta clase si pila.peek es true, si en algunas de estas instrucciones de dentro del while hay una
        // ruptura, la cima será false y deberemos parar este while. Es cierto que al estar la cima a false,
        //las instrucciones del while no se ejecutarían, pero al no ejecutarse no se modificarían variables
        // y cond siempre sería true -> bucle infinito. De ninguna de las maneras debemos entrar en este while
        //en este caso.
        while(cond&&Principal.asig.pila.peek()) {
            //mientras se cumpla la condición
            for(int i = 0; i < ctx.getChildCount(); i++) {
                //llamo al walker para que camine sobre los hijos de la iteración.
                walker.walk(Principal.asig,ctx.getChild(i));
            }
            cond = (Boolean) evalua.visit(ctx.expr_bool());
        }
        if(entra) System.out.println("(fin iteración)");

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
}