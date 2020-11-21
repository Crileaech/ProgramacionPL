import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.HashMap;
import java.util.Map;
public class Anasem_listener extends AnasintBaseListener {
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
    public Map<Object,Object> variables=new HashMap<>();
    
    public void exitIdentificador(Anasint.IdentificadorContext ctx, String var, Anasint.TiposContext tiposContext) {
        variables.put(var, tiposContext);
    }

    public void exitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx) {

    }
    @Override
    public void exitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx) {
        if(ctx.exitRule(exitIdentificador((Anasint.IdentificadorContext) variables)){
            System.out.println("NO ERROR");
        } else if (ctx.exitRule(exitDeclaracion_subprogramas())){
            Map<Object,Object> f = new HashMap<>();
            if(exitIdentificador){
                System.out.println("NO ERROR");
            } else {
                System.out.println("ERROR");
            }
        }else{
            System.out.println("ERROR");
        }
    }


}
