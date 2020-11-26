
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompruebaDevolución extends AnasintBaseVisitor<Object> {

    public Object visitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx) {
        try {
            return visit(ctx.funcion());
        } catch(Exception e) {
            //si es un procedimiento...
            return null;
        }
    }
    public static String nombreFunc;
    public static String[] ruleNames;

    public Object visitFuncion(Anasint.FuncionContext ctx) {
        nombreFunc = ctx.variable().getText();
        System.out.println("COMPROBACIÓN DEVOLUCIÓN EN " + nombreFunc + ":");
        Map<String,String> varsADevolver = anasem.almacenF.get(nombreFunc).get("DEV");
        List<String> tiposADevolver = varsADevolver.values().stream().collect(Collectors.toList());
        List<ParseTree> instrucciones = ctx.instrucciones().children;
        try {
            List<String> tiposDevueltos = (List<String>) visit(instrucciones.get(instrucciones.size() - 1));
            if (tiposDevueltos.size() != tiposADevolver.size()) {
                System.out.println("    ERROR: Se esperaba devolver "
                        + tiposADevolver.size() + ". Han sido devueltos " + tiposDevueltos.size() + ".");
            } else {
                compruebaDevoluciones(tiposDevueltos, tiposADevolver, nombreFunc);
            }
        } catch (Exception e) {
            String inst = instrucciones.get(instrucciones.size() - 1).getText();
            if (!inst.startsWith("dev")) {
                System.out.println("ERROR: La última instrucción de una función debe ser la devolución\n");
            }
        }
        return null;
    }
    //DECISIÓN DE DISEÑO 3.1. Aunque en la implementación recibe las variables en lugar del tipo de variables,
    //por temas de eficiencia.
    public void compruebaDevoluciones(List<String> tiposDevueltos, List<String> tiposADevolver, String nombreFunc) {
        for (int i = 0; i < tiposDevueltos.size(); i++) {
            if(!tiposDevueltos.get(i).equals(tiposADevolver.get(i))) {
                System.out.println("    ERROR: Se esperaba " + tiposADevolver.get(i) + " y se recibió (" + tiposDevueltos.get(i) + ")");
            } else {
                System.out.println("    Se esperaba " + tiposADevolver.get(i) + " y se recibió " + tiposDevueltos.get(i) + " --> OK");
            }
        }
        System.out.println("");
    }

    public List<String> visitDeclaracion_instrucciones(Anasint.Declaracion_instruccionesContext ctx){
        for(int i = 0; i<ctx.children.size(); i++) {
            if(ctx.getChild(i).getText().substring(0,3).equals("dev")) {
                return (List<String>) visit(ctx.getChild(i));
            }
        }
        return null;
    }

    public List<String> visitDev(Anasint.DevContext ctx){
        List<String> devs = new ArrayList<>();
        for (Anasint.ExprContext hijo : ctx.devolucion().expr()) {
            devs.add((String) visit(hijo));
        }
        return devs;
    }

    public String visitExpr(Anasint.ExprContext ctx){
        return (String) visit(ctx.getChild(0));
    }

    public String visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx) {
        String tipo = extraeTipo(ctx.getChild(0).getChild(0).getText());
        if(tipo.equals("SEQ(NUM)")) {
            return "NUM";
        } else {
            return "LOG";
        }
    }
    public String visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx) {
        return "NUM";
    }
    public String visitOpInteger(Anasint.OpIntegerContext ctx) {
        return "NUM";
    }
    public String visitExprFuncInt(Anasint.ExprFuncIntContext ctx) {
            return "NO PERMITIDO";
    }
    public String visitNum(Anasint.NumContext ctx) {
        return "NUM";
    }
    public String visitVarInt(Anasint.VarIntContext ctx) {
        String var = ctx.getText();
        return extraeTipo(var);
    }

    public String visitTrue(Anasint.TrueContext ctx) {
        return "LOG";
    }
    public String visitFalse(Anasint.FalseContext ctx) {
        return "LOG";
    }
    public String visitSacarElemBool(Anasint.SacarElemBoolContext ctx) {
        String tipo = extraeTipo(ctx.getChild(0).getChild(0).getText());
        if(tipo.equals("SEQ(NUM)")) {
            return "NUM";
        } else {
            return "LOG";
        }
    }
    public String visitCompararBool(Anasint.CompararBoolContext ctx) {
        return "LOG";
    }
    public String ParentesisOpBool(Anasint.ParentesisOpBoolContext ctx) {
        return "LOG";
    }
    public String OpBool(Anasint.OpBoolContext ctx) {
        return "LOG";
    }
    public String CompararSeq(Anasint.CompararSeqContext ctx) {
        return "LOG";
    }
    public String CompararInteger(Anasint.CompararIntegerContext ctx) {
        return "LOG";
    }
    public String NegacionBool(Anasint.NegacionBoolContext ctx) {
        return "LOG";
    }
    public String ExprFuncBool(Anasint.ExprFuncBoolContext ctx) {
        return "NO PERMITIDO";
    }
    public String VarBool(Anasint.VarBoolContext ctx) {
        return "LOG";
    }

    public String visitVaciaSeq(Anasint.VaciaSeqContext ctx) {
        //por defecto una secuencia vacía será SEQ(NUM)
        return "SEQ(NUM)";
    }
    public String visitSeq(Anasint.SeqContext ctx) {
        String tipoInt = (String) visit(ctx.getChild(1));
        if(tipoInt.equals("NUM")) {
            return "SEQ(NUM)";
        } else {
            return "SEQ(LOG)";
        }
    }
    public String visitExprFuncSeq(Anasint.ExprFuncSeqContext ctx) {
        return "NO PERMITIDO";
    }
    public String visitVarSeq(Anasint.VarSeqContext ctx) {
        return extraeTipo(ctx.getText());
    }

    public String extraeTipo(String var) {
        Map<String, String> varsADevolver = anasem.almacenF.get(nombreFunc).get("DEV");
        Map<String, String> params = anasem.almacenF.get(nombreFunc).get("PARAM");
        Map<String, String> cuerpo = anasem.almacenF.get(nombreFunc).get("CUERPO");
        Map<String,String> global = anasem.almacenGlobal;
        String tipo = "no declarada";
        if (varsADevolver.containsKey(var)) { //si la variable que se devuelve está en dev y el tipo coincide -> ok
            tipo = varsADevolver.get(var);
        } else if (!params.isEmpty() && params.containsKey(var)) {
            //compruebo que el tipo de la variable coincida con el que se desea devolver
            tipo = params.get(var);
        } else if (!cuerpo.isEmpty() && cuerpo.containsKey(var)) {
            //compruebo que el tipo de la variable coincida con el que se desea devolver
            tipo = cuerpo.get(var);
        } else if (!global.isEmpty() && global.containsKey(var)) {
            tipo = global.get(var);
        } else {
            System.out.println("    ERROR: Devolución de variable no declarada");
        }
        return tipo;
    }

    public String visitVariable (Anasint.VariableContext ctx){
        return ctx.getText();
    }

}
