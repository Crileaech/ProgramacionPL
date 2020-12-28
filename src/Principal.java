import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.swing.*;
import java.util.Arrays;
public class Principal {

    //se trata como un atributo. EL motivo es para que cuando llamemos a iterador, las modificaciones que se hagan
    //en dicho while se apliquen sobre el programa general. La única manera conocida de hacer esto es llamar al
    //walker sobre el mismo objeto. Para acceder fácilmente a este mismo objeto desde el iterador -> Principal.asig.
    public static flujoInstrucciones asig = new flujoInstrucciones();

    public static void main(String[] args) throws Exception{
        CharStream input = CharStreams.fromFileName(args[0]);
        Analex lexer = new Analex(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Anasint parser = new Anasint(tokens);
        ParseTree tree = parser.programa();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(asig,tree);

        JFrame frame = new JFrame("Antlr Árbol de Análisis");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewr.setScale(1);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setVisible(true);
    }
}