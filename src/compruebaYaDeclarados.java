

import com.sun.jdi.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* DECISIONES DE DISEÑO error 6 (error por declaración múltiple de una misma variable):

         (DECISIÓN 6.1)
         P no permitirá la declaración de una misma variable múltiples veces.

         función compruebaYaDeclarados(identificadores) // i,max,j:NUM; -> identificadores = {i,max,j}
         para cada ident en identificadores
         si compruebaDeclaracion(ident) no error //compruebaDeclaración devuelve error si no existe en almacén
         error
         sino
         no error
*/

public class compruebaYaDeclarados extends AnasintBaseVisitor<Object>  {

    public  Map<String,String> almacen = new HashMap<String,String>();
    
    public Boolean compruebaYaDeclarados(String ident) { //Falta añadir el almacen que la función debe mirar
        String aux = almacen.get(ident);
        Boolean res = false;
        if (aux == null) {
            System.out.println("NO ERROR");
        } else {
            res = true;
            System.out.println("Error: Variable ya declarada");
        }
        return res;
    }

    public String visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx){

        return ctx.getText();
    }

    public Map<String, String> visitIdentificador(Anasint.IdentificadorContext ctx) {
        return (Map<String, String>) visit(ctx.getChild(0));
    }

    public Map<String, String> visitElementales(Anasint.ElementalesContext ctx) {
        Map<String, String> varYTipo = new HashMap<>();
        String tipo = ctx.getChild(ctx.children.size()-1).getText(); //el último hijo es tipo_elementales o tipo_no_elementales
        for(int i = 0; i<ctx.children.size()-1;i=i+2) { //de dos en dos para saltarme , y :
            String r = ctx.getChild(i).getText();
            Boolean aux = compruebaYaDeclarados(r);
            if(aux==false) {
                varYTipo.put(r,tipo);
            }
        }
        return varYTipo;
    }

    public Map<String, String> visitSecuencias(Anasint.SecuenciasContext ctx) {
        Map<String, String> varYTipo = new HashMap<>();
        String tipo = ctx.getChild(2).getText();
        String r = ctx.getChild(0).getText();
        Boolean aux = compruebaYaDeclarados(r);
        if(aux==false) {
            varYTipo.put(r,tipo);
        }
        return varYTipo;
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



}


