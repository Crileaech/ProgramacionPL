//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class compruebaDeclaracion extends AnasintBaseVisitor<Object>{
//    /*
//    * DECISIONES DE DISEÑO error 5 (error por uso de variable no declarada):
//
//     (DECISIÓN 5.1)
//     P no permite el uso de variables que no están declaradas. //resoluble en funcion tipoVariable de manera más eficiente.
//
//     función compruebaDeclaración(identificador)
//        si identificador en almacen de programa //significaría que es una variable global
//            no error
//        si estamos en un subprograma
//            f = almacén de variables del subprograma
//            si identificador está en alguno de los almacenes de f(=PARAM, DEV, CUERPO) //variable local
//                no error
//            sino  //si no es ni local ni global no ha sido declarada
//                error
//        sino
//            error //si no estamos en subprograma y se hace uso de una variable que no es global, error.
//
//     Por cada aparición de una variable deberemos hacer uso de esta función para asegurarnos que haya sido declarada.
//     * */
//    public static void main(String[] args) throws Exception{
//        // Función main usada para pruebas
//        Map<String,String> almacen = new HashMap<String, String>();
//        Map<String,Map<String,Map<String, String>>> almacenF = new HashMap<String,Map<String,Map<String, String>>>();
//        almacen.put("i","NUM");
//        if(compruebaDeclaracion("b",almacen, almacenF)){
//            System.out.println("Variables que no están declaradas");
//        }else{
//            System.out.println("Todo correcto");
//        }
//    }
//    public Object visitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx) {
//        try {
//            return visit(ctx.funcion());
//        } catch(Exception e) {
//            //si es un procedimiento...
//            return null;
//        }
//    }
//
//    public static Boolean compruebaDeclaracion(String ident, Map<String, String> almacen, Map<String, Map<String, Map<String, String>>> almacenF) {
//        String aux = almacen.get(ident);
//        Boolean res = false;
//        if (!(aux == null)) {
//            res = true;
//        } else if (this.visitDeclaracion_subprogramas()!= null){
//           aux = String.valueOf(almacenF.get(ident));
//           if(aux != null){
//               res= true;
//           }else{
//              res=true;
//           }
//
//        }else {
//            res = false;
//        }
//        return res;
//    }
//
//    public static Boolean compruebaNombreFuncion(String ident, Map<String,Map<String,Map<String, String>>> almacen){
//        List<String> aux = almacen.keySet().stream().collect(Collectors.toList());
//        //System.out.println(ident2);
//        Boolean res = false;
//        for(int i=0;i< aux.size();i++){
//            if(aux.get(i).equals(ident)){
//                res=true;
//            }
//        }
//        return res;
//    }
//}
