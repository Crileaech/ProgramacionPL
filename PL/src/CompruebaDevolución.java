import jdk.dynalink.linker.LinkerServices;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Collectors;

public class CompruebaDevolución extends AnasintBaseVisitor<Object>{

    public Object visitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx) {
        String nombreFunc = ctx.funcion().variable().getText();
        System.out.println("COMPROBACIÓN DEVOLUCIÓN EN "+nombreFunc + ":");
        Map<String,String> varsADevolver = anasem.almacenF.get(nombreFunc).get("DEV");
        Map<String,String> params = anasem.almacenF.get(nombreFunc).get("PARAM");
        Map<String,String> cuerpo = anasem.almacenF.get(nombreFunc).get("CUERPO");
        List<String> tiposADevolver = varsADevolver.values().stream().collect(Collectors.toList());
        List<ParseTree> instrucciones = ctx.funcion().instrucciones().children;
        try {
            List<String> variables = (List<String>) visit(instrucciones.get(instrucciones.size()-1));
            if(variables.size()!=tiposADevolver.size()) {
                System.out.println("    ERROR: Se esperaba devolver "
                        + tiposADevolver.size() + ". Han sido devueltos " + variables.size() + ".");
            } else {
                for(int i = 0; i<variables.size(); i++) {
                    String var = variables.get(i);
                    if(varsADevolver.containsKey(var)) { //si la variable que se devuelve está en dev y el tipo coincide -> ok
                        String tipo = varsADevolver.get(var);
                        if(tipo.equals(tiposADevolver.get(i))) {
                            System.out.println("    "+var + " (" + tipo + ") en DEV coincide con " + tipo + " en DEV --> OK");
                        } else {
                            System.out.println("    ERROR: Se esperaba " + tiposADevolver.get(i) + " y se recibió " + var + " (" + tipo + ")");
                        }
                    } else if(!params.isEmpty() && params.containsKey(var)) {
                        //compruebo que el tipo de la variable coincida con el que se desea devolver
                        String tipo = params.get(var);
                        if(tipo.equals(tiposADevolver.get(i))) {
                            System.out.println("    "+var + " (" + tipo + ") en PARAM coincide con " + tipo + " en DEV --> OK");
                        } else {
                            System.out.println("    ERROR: Se esperaba " + tiposADevolver.get(i) + " y se recibió " + var + " ("+tipo+")");
                        }
                    } else if(!cuerpo.isEmpty() && cuerpo.containsKey(var)) {
                        //compruebo que el tipo de la variable coincida con el que se desea devolver
                        String tipo = cuerpo.get(var);
                        if(tipo.equals(tiposADevolver.get(i))) {
                            System.out.println("    " +var + " (" + tipo + ") en CUERPO coincide con " + tipo + " en DEV --> OK");
                        } else {
                            System.out.println("    ERROR: Se esperaba " + tiposADevolver.get(i) + " y se recibió " + var + " ("+tipo+")");
                        }
                    } else {
                        System.out.println("    ERROR: Devolución de variable no declarada");
                    }
                }
            }
        } catch(Exception e) {
            String inst = instrucciones.get(instrucciones.size()-1).getText();
            if(!inst.startsWith("dev")) {
                System.out.println("ERROR: La última instrucción de una función debe ser la devolución");
            }
        }
        return null;
    }
    public ParseTree tree;

    public CompruebaDevolución(ParseTree tree) {
        this.tree = tree;
    }

    public static void main(String[] args) {
        System.out.println("estoy");
    }

    public List<String> visitDeclaracion_instrucciones(Anasint.Declaracion_instruccionesContext ctx) {
        return (List<String>) visit(ctx.devolucion());
    }

    public List<String> visitDevolucion(Anasint.DevolucionContext ctx)  {
        List<String> devs =  new ArrayList<>();
        for (Anasint.ExprContext hijo:ctx.expr()) {
            devs.add((String) visit(hijo));
        }
        return devs;
    }

    public String visitExpr(Anasint.ExprContext ctx) { return (String) visit(ctx.expr_integer().variable()); }

    public String visitVariable(Anasint.VariableContext ctx) {
        return ctx.getText();
    }
}
