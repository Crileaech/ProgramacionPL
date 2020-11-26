import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

public class compruebaYaDeclarados {
    public static void main(String[] args) throws Exception{
        // Función main usada para pruebas
        Map<String,String> almacen = new HashMap<String, String>();
        Map<String,Map<String,Map<String, String>>> almacenF = new HashMap<String,Map<String,Map<String, String>>>();
        almacen.put("i","NUM");
        if(compruebaYaDeclarados("b",almacen)){
            System.out.println("Variable ya declarada");
        }else{
            System.out.println("Todo correcto");
        }
    }

    public static Boolean compruebaYaDeclarados(String ident, Map<String,String> almacen) { //Falta añadir el almacen que la función debe mirar
        String aux = almacen.get(ident);
        Boolean res = false;
        if (!(aux == null)) {
            res = true;
        }
        return res;
    }

    public static Boolean compruebaNombreFuncion(String ident, Map<String,Map<String,Map<String, String>>> almacen){
        List<String> aux = almacen.keySet().stream().collect(Collectors.toList());
        //System.out.println(ident2);
        Boolean res = false;
        for(int i=0;i< aux.size();i++){
            if(aux.get(i).equals(ident)){
                res=true;
            }
        }
        return res;
    }


}