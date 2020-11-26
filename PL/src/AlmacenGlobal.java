import java.util.*;
import java.util.stream.Collectors;

public class AlmacenGlobal extends AnasintBaseVisitor<Object>{


    /*(parámetro de salida n)
        variables: VARIABLES (m=declaracion_variables {almacenar m en n})*;
         */
    public static  Map<String,String> almacenGlobal = new LinkedHashMap<String, String>();

    public static List<String> variablesUsadas = new ArrayList<String>();

    public static  Map<String, String> getAlmacenGlobal() {
        return almacenGlobal;
    }

    public Map<String,String> visitPrograma(Anasint.ProgramaContext ctx) {
        Map<String,String> res = (Map<String, String>) visit(ctx.variables());
        almacenGlobal = res;
        //System.out.println(res.toString());
        return res;
    }

    //Decisión de diseño 6: error por declaración múltiple de una variable
    // si ident se encuentra ya en almacén del subprograma error
    // sino añade ident al almacén del subprograma

    public Map<String,String> visitVariables(Anasint.VariablesContext ctx){
        Map<String, String> n = new LinkedHashMap<>();
        for (int i=1;i<ctx.children.size();i++) {
            Map<String, String> m = (Map<String, String>) visit(ctx.getChild(i));
            List<String> aux = m.keySet().stream().collect(Collectors.toList());
            for (int j = 0; j < aux.size(); j++) {
                if (compruebaDeclarados.compruebaYaDeclarados(aux.get(j), n)) {
                    System.out.println("Error: Variable " + aux.get(j) + " ya declarada en Almacén Principal");
                    m.remove(aux.get(j));
                }
            }
            n.putAll(m);
        }
        return n;
    }

    public String visitTipos(Anasint.TiposContext ctx) {
        return (String) visit(ctx.getChild(0));
    }

    public String visitTipos_elementales(Anasint.Tipos_elementalesContext ctx) {
        return ctx.getText();
    }

    public String visitTipos_no_elementales(Anasint.Tipos_no_elementalesContext ctx) {
        return ctx.getText();
    }



    //Decisión de diseño 6: error por declaración múltiple de una variable
        // si al declarar varias varibles en una sola línea (es decir cuelgan de la misma rama del árbol), alguna está repetida ERROR
            // sino se añade al almacén varYTipo

    // Ejemplo: i,j,i:NUM;  -----> ERROR
    // Almacén: {i,j}

    public Map<String, String> visitElementales(Anasint.ElementalesContext ctx) {
        Map<String, String> varYTipo = new LinkedHashMap<>();
        String tipo = ctx.getChild(ctx.children.size()-1).getText(); //el último hijo es tipo_elementales o tipo_no_elementales
        for(int i = 0; i<ctx.children.size()-1;i=i+2) { //de dos en dos para saltarme , y :
            String r = ctx.getChild(i).getText();
            if(compruebaDeclarados.compruebaYaDeclarados(r,varYTipo)){
                System.out.println("Error: Variable "+r+" ya declarada en la línea de código");
            }else{
                varYTipo.put(r,tipo);
            }
        }
        return varYTipo;
    }

    //Decisión de diseño 6: error por declaración múltiple de una variable
    // si al declarar varias varibles en una sola línea (es decir cuelgan de la misma rama del árbol), alguna está repetida ERROR
    // sino se añade al almacén varYTipo

    // Ejemplo: i,j,i:SEQ(NUM);  -----> ERROR
    // Almacén: {i,j}

    public Map<String, String> visitSecuencias(Anasint.SecuenciasContext ctx) {
        Map<String, String> varYTipo = new LinkedHashMap<>();
        String tipo = ctx.getChild(2).getText();
        String r = ctx.getChild(0).getText();
        if(compruebaDeclarados.compruebaYaDeclarados(r,varYTipo)){
            System.out.println("Error: Variable "+r+" ya declarada en la línea de código");
        }else{
            varYTipo.put(r,tipo);
        }
        return varYTipo;
    }

    public Map<String, String> visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx) {
        return (Map<String, String>) visit(ctx.identificador());
    }

    public Map<String, String> visitIdentificador(Anasint.IdentificadorContext ctx) {
        return (Map<String, String>) visit(ctx.getChild(0));
    }

    public String visitVariable(Anasint.VariableContext ctx) {
        return ctx.getText();
    }
}

