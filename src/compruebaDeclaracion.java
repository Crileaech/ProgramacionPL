import java.util.Map;
public class compruebaDeclaracion extends AnasintBaseListener {

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


    public void cumpruebaDeclarada(Anasint.Declaracion_variablesContext ctx)  {
        Map<String, String> almacenPrograma = Almacenes.almacenGlobal;// {i:NUM,s:SEQ(NUM),b:LOG}
        Map<String,Map<String,Map<String, String>>> almacenF = Almacenes.almacenF;  //{PARAM:{i:NUM,s:SEQ(NUM),b:LOG},DEV:{i:NUM,s:SEQ(NUM),b:LOG}}
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
