import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Anasem extends AnasintBaseListener{

    public static Map<String,Map<String, Map<String, String>>> almacenF = new HashMap<>();
    public static Map<String,String> almacenGlobal = new HashMap<>();

    public Anasem(ParseTree tree) {
        AlmacenGlobal g = new AlmacenGlobal();
        AlmacenFunciones v = new AlmacenFunciones();
        this.almacenGlobal = (Map<String,String>) g.visit(tree);
        this.almacenF = (Map<String, Map<String, Map<String, String>>>) v.visit(tree);
        ErroresParámetros e = new ErroresParámetros();
        CompruebaDevolución c = new CompruebaDevolución();
        e.visit(tree);
        c.visit(tree);
        System.out.println("c"+ almacenF);
    }


    /*DECISIONES DE DISEÑO error 4 (error por uso de variables ambiguas):

    (DECISIÓN 4.1)
    Una variable ambigua es aquella a la que aún no se le ha asociado ningún valor o en su defecto, aquella a la que
    se le ha asociado una expresión formada al menos por una variable ambigua.

    En caso del uso de una variable bien declarada pero local (de subprograma) en una instrucción de programa se produ-
    ciría un error, error capturado por la decisión de diseño 5. No es necesario por tanto, discernir en este caso
    entre variables locales y de programa.*/

    VerificarAmbiguedad verificador = new VerificarAmbiguedad();

    //cada vez que declaro una variable nueva, en el almacén de ambigüedades la almaceno junto con un true,
    //indicando de esta forma que es ambigua hasta que se le asigne un valor.


    /*public void exitDecVarElem(Anasint.DecVarElemContext ctx){
        //se recorre ctx.VAR() porque en el caso de las variables elementales SIEMPRE es una lista
        //por la posibilidad de declarar varias a la vez, de modo que individualmente introducimos
        //las variables de la lista en el almacén y les asignamos true
        for(TerminalNode p: ctx.VAR())
            verificador.aAmbiguedad.put(p.getText(), true);

        //System.out.println("declarada(s) variable(s) elemental(es) "+ctx.VAR()+" y puesta(s) como ambigua(s)");
    }

    public void exitDecVarSeq(Anasint.DecVarSeqContext ctx){
        verificador.aAmbiguedad.put(ctx.VAR().getText(), true);

        //System.out.println("declarada secuencia "+ctx.VAR().getText()+" y puesta como ambigua");
    }*/

    public void exitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx){

        ParseTree subp = ctx.getChild(0);
        String nombreFuncion = subp.getChild(1).getText();
        verificador.aAmbiguedadFunciones.put(nombreFuncion, new HashMap<>());

        //parametros de entrada
        verificador.aux.putAll((Map<String,Boolean>) verificador.visit(subp.getChild(3)));

        //parametros de salida en caso de ser funcion
        if (subp.getChild(0).getText().equals("FUNCION"))
                verificador.aux.putAll((Map<String,Boolean>) verificador.visit(subp.getChild(7)));


        //declaracion de variables
            //si es funcion
        if (subp.getChild(0).getText().equals("FUNCION") && subp.getChild(9).getChildCount()>1)
            for (int i = 1; i < subp.getChild(9).getChildCount(); i++)
                verificador.aux.putAll((Map<String, Boolean>) verificador.visit(subp.getChild(9).getChild(i)));

            //si es procedimiento
        else
            if (subp.getChild(5).getChildCount()>1)
                for (int i = 1; i<subp.getChild(5).getChildCount(); i++)
                    verificador.aux.putAll((Map<String,Boolean>) verificador.visit(subp.getChild(5).getChild(i)));


        //asignacion de variables
            //si es funcion
        if (subp.getChild(0).getText().equals("FUNCION") && subp.getChild(10).getChildCount()>1)
            for (int i = 1; i<subp.getChild(10).getChildCount(); i++)
                verificador.aux.putAll((Map<String,Boolean>) verificador.visit(subp.getChild(10).getChild(i).getChild(0)));

            //si es procedimiento
        else
            if (subp.getChild(5).getChildCount()>1)
                for (int i = 1; i<subp.getChild(5).getChildCount(); i++)
                    verificador.aux.putAll((Map<String,Boolean>) verificador.visit(subp.getChild(5).getChild(i).getChild(0)));

        verificador.aAmbiguedadFunciones.get(nombreFuncion).putAll(verificador.aux);
        verificador.aux.clear();

        verificador.aAmbiguedad.put(nombreFuncion, false);
    }

    public void exitPrograma(Anasint.ProgramaContext ctx){

        //declaracion de variables
        for(int i = 1; i<ctx.variables().getChildCount(); i++)
            verificador.aux.putAll((Map<String,Boolean>) verificador.visit(ctx.variables().getChild(i)));




        //asignacion de variables
        List<Anasint.Declaracion_instruccionesContext> x = ctx.instrucciones().declaracion_instrucciones();
        Boolean existeDeclaracion = true;

        for (int i = 0; i<x.size(); i++) {
            System.out.println();
            if (x.get(i) != null && (x.get(i).getChild(0).getChild((x.get(i).getChild(0).getChildCount()/2)-1).equals("=")))
                //System.out.println(x.get(i).asignacion().getClass().getName());
                verificador.aux.putAll((Map<String, Boolean>) verificador.visit(x.get(i)));
        }

        verificador.aAmbiguedad.putAll(verificador.aux);
        verificador.aux.clear();
        System.out.println(verificador.aAmbiguedad);
        System.out.println(verificador.aAmbiguedadFunciones);
    }

    /*public void exitAsignacion(Anasint.AsignacionContext ctx){
        Boolean c = (Boolean) verificador.visit(ctx.expr(0));
        //System.out.println("asignacion: "+ctx.variable().get(0).VAR()+""+ctx.getChild(1).getText()+""+ctx.getChild(2).getText());

        verificador.aAmbiguedad.put(ctx.variable().get(0).VAR().getText(), c);

        System.out.println(verificador.aAmbiguedad);
        //System.out.println("----");
    }*/
}
