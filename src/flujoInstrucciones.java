import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class flujoInstrucciones extends AnasintBaseListener{
    //Clase que gestiona el flujo de instrucciones y contiene un almacén de asignaciones.
    //Pila para saber cuando se deben ejecutar las instrucciones de un árbol. Si llegados a un enter la parte
    //superior es false, no se ejecutan esas instrucciones ni la de sus hijos. peek se ve lo de arriba. pop lo saca.
    //push lo mete
    public static Stack<Boolean> pila = new Stack<>();
    public static Map<String,Object> asig = new LinkedHashMap<>();
    //iterador es una clase con un visitor para poder gestionar el flujo de ejecución de las iteraciones, ya que
    //no permite hacerlo los listener.

    //ayuda a las funciones a comprobar que todo

    private iterador it = new iterador();
    //evaluaExpr es una clase que dado un Anasint.ExprContext retorna su valor. Si le pasas 3+c -> lo calcula.
    private evaluaExpr evalua;
    //clase que dado un Anasint.AsertoContext te dice si la ejecución del programa es correcta(true) o incorrecta(false)
    private asertos evaluaAsert = new asertos();

    flujoInstrucciones(){}

    flujoInstrucciones(Map<String,Object> funcParams){
        asig.putAll(funcParams);

        //evaluaExpr no necesita parámetros si el objeto flujoInstrucciones se crea desde la
        //evaluación de un subprograma
        evalua = new evaluaExpr();
    }


    //Los enter se usaran usualmente para ver si debemos ejecutar o no la instrucciones del ctx, y ejecutarlas.
    //Se añadirá true (si se puede ejecutar) o false si no. Los exit se encargarán de una vez que el walker haya
    //pasado por el ctx retirar el centilena introducido en el enter.
    //es posible que en ciertos enter no se añada nada a la pila. Esto se hace si sabes que si tienes un true/false arriba
    //sí o sí vas a ejecutar o no la instrucción hija, porque si lo sabes para que vas a introducirla. Esto se ve en
    //enterAsignación.
    public void enterPrograma(Anasint.ProgramaContext ctx) {
        System.out.println("INTÉRPRETE");
        pila.push(true);

        //evaluaExpr tiene un constructor al que se le pasan los subprogramas para que a la hora de asignar una función
        //a una variable, podamos comprobar el subprograma al que nos estamos refiriendo y visitarlo
        evalua = new evaluaExpr(ctx.subprogramas());
    }
    public void exitPrograma(Anasint.ProgramaContext ctx) {
        System.out.println(asig);
        System.out.println("FIN INTÉRPRETE");
        pila.pop();
    }

    public void enterVariables(Anasint.VariablesContext ctx) {
        pila.push(pila.peek());
    }
    public void exitVariables(Anasint.VariablesContext ctx) {
        pila.pop();
    }
    public void enterElementales(Anasint.ElementalesContext ctx) {
        if(pila.peek()) {
            for(int i = 0; i<ctx.getChildCount()-1; i+=2) {
                asig.put(ctx.getChild(i).getText(), null);
            }
        }
    }
    public void enterSecuencias(Anasint.SecuenciasContext ctx) {
        if(pila.peek()) {
            asig.put(ctx.getChild(0).getText(), null);
        }
    }

    public void enterSubprogramas(Anasint.SubprogramasContext ctx) {
        //no queremos que se procesen las instrucciones de subprograma
        //salvo que sea llamado
        pila.push(false);
    }
    public void exitSubprogramas(Anasint.SubprogramasContext ctx) {
        pila.pop();
    }

    public void enterInstrucciones(Anasint.InstruccionesContext ctx) {
        pila.push(pila.peek());

    }
    public void exitInstrucciones(Anasint.InstruccionesContext ctx) {
        pila.pop();
    }

    public void enterAsignacion(Anasint.AsignacionContext ctx) {
        if(pila.peek()) {
            List<Anasint.ExprContext> asign = ctx.expr();
            List<Object> asignEvaluadasAux = asign.stream().map(x -> evalua.visit(x))
                    .collect(Collectors.toList());
            List<Object> asignEvaluadas = new ArrayList<>();

            //Aplana la lista de asignaciones, porque las funciones devuelven listas cuando tienen múltiples valores,
            //en caso de que haya alguna función que devuelva múltiples valores
            if(asignEvaluadasAux.stream().anyMatch(x -> x instanceof List)) {
                for (int i = 0; i < asignEvaluadasAux.size(); i++) {
                    if (asignEvaluadasAux.get(i) instanceof List) {
                        if(!((List<Object>) asignEvaluadasAux.get(i)).isEmpty() && ((List<Object>) asignEvaluadasAux.get(i)).get(0).equals("func")) {
                            ((List<Object>) asignEvaluadasAux.get(i)).remove(0);
                            asignEvaluadas.addAll((List<Object>)asignEvaluadasAux.get(i));
                            //si devuelve más de una cosa la funciójn debemos añadir a la lista asign ExprContext de la función
                            //para que aparezca al lado del valor el nombre de la función (de donde viene). Es un detalle esté-
                            //tico.
                            for(int j = 1; j < ((List<Object>)asignEvaluadasAux.get(i)).size(); j++) {
                                asign.add(i, asign.get(i));
                            }
                        } else {
                            asignEvaluadas.add(asignEvaluadasAux.get(i));
                        }
                    } else {
                        asignEvaluadas.add(asignEvaluadasAux.get(i));
                    }
                }
            }
            else {
                asignEvaluadas.addAll(asignEvaluadasAux);
            }
            Object evaluacion = null;
            for(int j = 0; j<asign.size(); j++) {
                if (j<asignEvaluadas.size())
                    evaluacion = asignEvaluadas.get(j);
                if(evaluacion==null) {
                    break;
                }
                if(ctx.getChild(j*2).getClass()==Anasint.Expr_sacar_elemContext.class) {
                    Anasint.Expr_sacar_elemContext elem = (Anasint.Expr_sacar_elemContext) ctx.getChild(j*2);
                    String nombreVar = elem.getChild(0).getText();
                    int pos = Integer.parseInt(elem.getChild(2).getText());
                    List<Object> seq = (List<Object>) asig.get(nombreVar);
                    String antes = seq.toString();
                    seq.set(pos, evaluacion);
                    String dsps = seq.toString();
                    asig.put(nombreVar,seq);
                    String exprAsignada = evaluacion.toString();
                    //si el valor a asignar viene de una operación, deseo que se observe la operación realizada.
                    if (!asign.get(j).getText().equals(exprAsignada))
                        exprAsignada+= " (" + asign.get(j).getText() + ")";

                    if(pila.peek()) {
                        muestraConIdentación("(asignación) " + elem.getText() + " <- "
                                + exprAsignada + ". Antes: " + antes + ". Ahora: " + dsps);
                    }
                } else {
                    Anasint.VariableContext elem = (Anasint.VariableContext) ctx.getChild(j*2);
                    asig.put(elem.getText(), evaluacion);
                    String exprAsignada = evaluacion.toString();
                    //si una asignación es una expresión compuesta, quiero que se observe a la
                    //dcha de donde viene el resultado.

                    if (j<asign.size()&&!asign.get(j).getText().equals(exprAsignada)&&!asig.get(elem.getText()).getClass().equals(ArrayList.class))
                        exprAsignada+= " (" + asign.get(j).getText() + ")";
                    if(pila.peek())
                        muestraConIdentación("(asignación) " + elem.getText() + " <- " + exprAsignada);
                }
            }
        }
    }

    public void enterCondicion(Anasint.CondicionContext ctx) {
        if(pila.peek()) {
            Anasint.Blq_sinoContext blqSino = ctx.blq_sino();
            Boolean tieneElse = blqSino!=null;
            Boolean cond = (Boolean) evalua.visit(ctx.expr_bool());
            //si se cumple cond debe asignarse a la pila para que las instrucciones del
            //if sean ejecutadas. Sino se añadirá false
            muestraConIdentación("(condicional) " + ctx.expr_bool().getText(), false);
            if(cond) System.out.print(" se satisface ");
            else System.out.print(" no se satisface ");
            if(!cond&&tieneElse) muestraConIdentación("ejecutando else:");
            else System.out.println("");
            pila.add(cond);
        } else {
            pila.push(pila.peek());
        }
    }
    public void exitCondicion(Anasint.CondicionContext ctx) {
        pila.pop();
        if(pila.peek()) { //pila.peek en el enterCondicion. Solo si fue true se ejecutó el if.
            muestraConIdentación("(fin condicional)");
        }
    }
    public void enterBlq_sino(Anasint.Blq_sinoContext ctx) {
        //¿Se cumplió la condición del if?
        //si se cumplió no se debe ejecutar el else. En caso contrario sí se deberá ejecutar.
        //pudiera parecer que cumpleSi coincide con pila.peek(). Desafortunadamente esto no
        //es del to do cierto -> si hay ruptura en la cima habrá false aunque se cumpla if.
        // pila: [ejecutando condición, no se debe ejecutar condicional,...] -> mirando los dos primeros
        //elementos de la cima podemos saber si se debe de ejecutar el sino o no.
        //Si false,true,... -> No se ha ejecutado cond pero pila.peek en el enterIt era true -> Se debe de ejecutar sino.
        //Si false,false,... -> No se ha ejecutado cond porque pila.peek en enterIt fue false -> No se debe de ejecutar sino.
        //Si true,true,... -> Se ejecutó cond. Luego no debe ser así con sino.
        //Si true,false,... -> Imposible su ejecución.
        Anasint.CondicionContext padre = (Anasint.CondicionContext) ctx.getParent();
        Stack<Boolean> pilaCopia = (Stack<Boolean>) pila.clone();
        pilaCopia.pop();
        pila.push(pilaCopia.peek()&&!(Boolean) evalua.visit(padre.expr_bool()));
    }
    public void exitBlq_sino(Anasint.Blq_sinoContext ctx) {
        pila.pop();
    }

    public void enterShow(Anasint.ShowContext ctx) {
        if(pila.peek()) {
            for(Anasint.ExprContext expr :ctx.mostrar().expr()) {
                muestraConIdentación("(mostrar) " + evalua.visit(expr));
            }
        }
    }
    public void enterIt(Anasint.ItContext ctx) {
        pila.push(pila.peek());
        if(pila.peek()) {
            it.visit(ctx); //si en la cima true se procesa el iterador
        }
    }
    public void exitIt(Anasint.ItContext ctx) {
        pila.pop();
    }
    public void exitBreak(Anasint.BreakContext ctx) {
        if(pila.peek()) {
            pila.pop();
            pila.push(false);
            muestraConIdentación("(ruptura)");
        }
    }

    public void exitDev(Anasint.DevContext ctx){
        if(pila.peek()) {
            pila.pop();
            pila.push(false);
            muestraConIdentación("(devolución)");
        }
    }

    public void enterAserto(Anasint.AsertoContext ctx) {
        if(pila.peek()) {
            if(ctx.asertos().expr_bool()!=null) { //en este caso es simple {cierto} {falso} o equivalente.
                Boolean eval = (Boolean) evalua.visit(ctx.asertos().expr_bool());
                if(eval) {
                    muestraConIdentación("(aserto) la ejecución del programa está siendo correcta.");
                } else {
                    muestraConIdentación("(aserto) el programa es incorrecto. La ejecución del programa ha sido finalizada.");
                    int tam = pila.size();
                    pila.clear();
                    for(int i = 0; i<tam; i++) { pila.push(false); }
                }
            } else {
                Boolean eval = evaluaAsert.visitAserto(ctx);
                if(eval) {
                    muestraConIdentación("(aserto) la ejecución del programa está siendo correcta.");
                } else if(!eval) {
                    int tam = pila.size();
                    pila.clear();
                    for(int i = 0; i<tam; i++) { pila.push(false); }
                    muestraConIdentación("(aserto) el programa es incorrecto. La ejecución del programa ha sido finalizada.");
                } else {
                    muestraConIdentación("(aserto) el aserto es indefinido. No se puede asegurar la corrección del programa.");
                }
            }
        }
        pila.push(pila.peek());
    }

    public void exitAserto(Anasint.AsertoContext ctx) { pila.pop(); }

    //dado un mensaje lo muestra con la identación adecuada. La identación base es pila tam 2.
    public static void muestraConIdentación(String mens) {
        int identacion = pila.size()-2;
        String r = "";
        for(int j = 0; j<identacion; j++)  {
            r+="\t";
        }
        System.out.println(r + mens);
    }

    //hace exactamente lo mismo que la anterior pero si recibe false no añade salto de línea.
    public static void muestraConIdentación(String mens, Boolean saltoLinea) {
        int identacion = pila.size()-2;
        String r = "";
        for(int j = 0; j<identacion; j++)  {
            r+="\t";
        }
        if(saltoLinea) {
            System.out.println(r + mens);
        } else {
            System.out.print(r + mens);
        }
    }

    //igual que la primera. Pero para retirar las identaciones que se deseen mediante reductor.
    public static void muestraConIdentación(String mens, int reductor) {
        int identacion = pila.size()-2-reductor;
        String r = "";
        for(int j = 0; j<identacion; j++)  {
            r+="\t";
        }
        System.out.println(r + mens);
    }

    public static void finalizaEjecución() {
        int tam = pila.size();
        pila.clear();
        for(int i = 0; i<tam; i++) { pila.push(false); }
    }
}
