import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class AlmacenGlobal extends AnasintBaseVisitor<Object>{
    /*(parámetro de salida n)
    variables: VARIABLES (m=declaracion_variables {almacenar m en n})*;
     */
    public Map<String,String> visitPrograma(Anasint.ProgramaContext ctx) {
        return (Map<String, String>) visit(ctx.variables());
    }
    public Map<String,String> visitVariables(Anasint.VariablesContext ctx){
        Map<String, String> n = new LinkedHashMap<>();
        for (int i=1;i<ctx.children.size();i++){
            Map<String,String> m = (Map<String,String>)visit(ctx.getChild(i));
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

    public String visitVariable(Anasint.VariableContext ctx) {
        return ctx.getText();
    }

    public Map<String, String> visitElementales(Anasint.ElementalesContext ctx) {
        Map<String, String> varYTipo = new LinkedHashMap<>();
        String tipo = ctx.getChild(ctx.children.size()-1).getText(); //el último hijo es tipo_elementales o tipo_no_elementales
        for(int i = 0; i<ctx.children.size()-1;i=i+2) { //de dos en dos para saltarme , y :
            String r = ctx.getChild(i).getText();
            varYTipo.put(r,tipo);
        }
        return varYTipo;
    }

    public Map<String, String> visitSecuencias(Anasint.SecuenciasContext ctx) {
        Map<String, String> varYTipo = new LinkedHashMap<>();
        String tipo = ctx.getChild(2).getText();
        String r = ctx.getChild(0).getText();
        varYTipo.put(r,tipo);
        return varYTipo;
    }

    public Map<String, String> visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx) {
        return (Map<String, String>) visit(ctx.identificador());
    }

    public Map<String, String> visitIdentificador(Anasint.IdentificadorContext ctx) {
        return (Map<String, String>) visit(ctx.getChild(0));
    }
}

