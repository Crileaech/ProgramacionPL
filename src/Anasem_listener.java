import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.HashMap;
import java.util.Map;
public class Anasem_listener extends AnasintBaseListener {
    /*
     (DECISIÓN 1.2)
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
             error
    * */
    public void exitAsignacion(Anasint.AsignacionContext ctx){
        if(ctx.variable()==null){
            System.out.println("ERROR");
        }else{
            if(ctx.variable().equals(ctx.expr())){
                System.out.println("NO ERROR");
            }else {
                System.out.println("ERROR");
            }
        }
    }
    /*
      (DECISIÓN 5.1)
     P no permite el uso de variables que no están declaradas. //resoluble en funcion tipoVariable de manera más eficiente.
     Almacén de variables globales (programa): (en el caso de comprobar asignaciones de subprogramas tendremos que mirar el almacén correspon-
                                                    diente en el almacén de subprogramas -> Ver decisión 2.1)
            variables   |    tipos
         --------------------------------------
             seq        |    Secuencia numérica
             i          |    Numérico
             loEs       |    Lógico

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


    @Override
    public void exitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx) {
        Map<Object,Object> almacenPrograma =new HashMap<>();// {i:NUM,s:SEQ(NUM),b:LOG}
        Integer subprograma = Anasint.SUBPROGRAMAS;
        if(!almacenPrograma.containsKey(ctx.identificador().getChild(0).getChild(1).getText())){
            System.out.println("NO ERROR");
        } else if (subprograma!=null){
            Map<String,Map<String,Map<String, String>>> almacenF = new HashMap<>();
            if(!almacenF.containsKey(ctx.identificador().getChild(0).getChild(1).getText())){
                System.out.println("NO ERROR");
            } else {
                System.out.println("ERROR");
            }
        }else{
            System.out.println("ERROR");
        }
    }

}
