import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import javax.swing.*;
import java.util.Arrays;
public class Principal {
    public static void main(String[] args) throws Exception{
        CharStream input = CharStreams.fromFileName(args[0]);
        Analex lexer = new Analex(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Anasint anasint = new Anasint(tokens);
        ParseTree tree = anasint.programa();// begin parsing at init rule

//        VerificarAmbiguedad visitAmbiguedad = new VerificarAmbiguedad();
//        visitAmbiguedad.visit(tree);
//        System.out.println(visitAmbiguedad.visit(tree));

//    AlmacenGlobal visitor = new AlmacenGlobal();
//    visitor.visit(tree);
//        System.out.println(visitor.visit(tree));
//
//    AlmacenFunciones loader = new AlmacenFunciones();
//    loader.visit(tree);
//        System.out.println(loader.visit(tree)); // print results

        // Create a generic parse tree walker that can trigger callbacks
        ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks
        Compilador compi = new Compilador();
        walker.walk(compi, tree);
        System.out.println("PRUEBA COMPILADOR: "+walker); // print a \n after translation

        JFrame frame = new JFrame("Árbol de Análisis");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                anasint.getRuleNames()),tree);
        viewr.setScale(1);//scale a little

        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setVisible(true);
    }
}