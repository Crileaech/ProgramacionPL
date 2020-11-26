import java.util.Map;
public class compruebaDeclaracion extends AnasintBaseListener {
    Map<String, String> almacenPrograma = Almacenes.almacenGlobal;// {i:NUM,s:SEQ(NUM),b:LOG}
    Map<String,Map<String,Map<String, String>>> almacenF = Almacenes.almacenF;  //{PARAM:{i:NUM,s:SEQ(NUM),b:LOG},DEV:{i:NUM,s:SEQ(NUM),b:LOG}}

    /*(DECISIÓN 1.2)
     Una asignación está bien tipada sí y solo sí el tipo de la variable coincide con el tipo de la expresión asignada.

     funcion comprobarTiposAsignación(tipo_var, tipo_expr)
         si tipo expr es igual a tipo invalido
             error
         sino
             si tipo_var es igual a tipo_expr entonces
                 no error
             sino
                 error

     funcion comprobaciónTiposAsignaciones(tipo_vars, tipo_exprs) //para asignaciones múltiples.
         almacen n
         pares = pares_var_expr(tipo_vars, tipo_exprs)
         para cada par en pares:
             añado en n comprobarTiposAsignación(tipo_var en par, tipo_expr en par)
         si en n no error entonces
             no error
         sino
             error*/
    private void comprobarTiposAsignación(Integer tipo_var, Integer tipo_expr) {
        if(tipo_expr==null){
            System.out.println("ERROR EN EL TIPO DE EXPRESION");
        }else {
            if(tipo_var==tipo_expr) {
                System.out.println("NO ERROR");
            }else {

            }
        }
    }

    /*


      (DECISIÓN 5.1)
     P no permite el uso de variables que no están declaradas. //resoluble en funcion tipoVariable de manera más eficiente.

     función compruebaDeclaración(identificador)
        si identificador en almacen de programa //significaría que es una variable global
            no error
        si estamos en un subprograma
            f = almacén de variables del subprograma
            si identificador está en alguno de los almacenes de f(=PARAM, DEV, CUERPO) //variable local
                no error
            sino  //si no es ni local ni global no ha sido declarada
                error
        sino
            error //si no estamos en subprograma y se hace uso de una variable que no es global, error.
     */


    public void exitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx)  {
        Integer subprograma = Anasint.SUBPROGRAMAS;
        if(!almacenPrograma.containsKey(ctx.identificador().getChild(0).getChild(1).getText()) && almacenPrograma.isEmpty()){
            System.out.println("NO ERROR");
        }else if(subprograma !=null){
            if(!almacenF.containsKey(ctx.identificador().getChild(0).getChild(1).getText())){
                System.out.println("NO ERROR");
            } else {
                System.out.println("ERROR");
            }
        } else {System.out.println("ERROR");}
    }

}
