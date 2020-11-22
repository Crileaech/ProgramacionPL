

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

public class compruebaYaDeclarados  {

    public  Map<String,Integer> almacen = new HashMap<String,Integer>();

    public Boolean compruebaYaDeclarados(String ident) {
        Integer aux = almacen.get(ident);
        Boolean res = false;
        if (aux == null) {

        } else {
            res = true;
        }
        return res;
    }

    public Integer visitTipos_elementales(Anasint.Tipos_elementalesContext ctx, String var) {
        Boolean varLibre=compruebaYaDeclarados(var);
        if(varLibre==true){
            almacen.put(var,new Integer(ctx.getStart().getType()));
        }else{
            System.out.println("Error: Variable ya declarada");
        }
        return null;
    }

    public Integer visitTipos_no_elementales(Anasint.Tipos_no_elementalesContext ctx, String var) {
        Boolean varLibre=compruebaYaDeclarados(var);
        if(varLibre==true){
            almacen.put(var,new Integer(ctx.getStart().getType()));
        }else{
            System.out.println("Error: Variable ya declarada");
        }
        return null;
    }



}


