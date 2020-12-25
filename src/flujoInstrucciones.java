import java.util.*;
import java.util.stream.Collectors;

public class flujoInstrucciones extends AnasintBaseListener{
    //Clase que gestiona el flujo de instrucciones y contiene un almacén de asignaciones.
    //Pila para saber cuando se deben ejecutar las instrucciones de un árbol. Si llegados a un enter la parte
    //superior es false, no se ejecutan esas instrucciones ni la de sus hijos. peek se ve lo de arriba. pop lo saca.
    //push lo mete
    public static Stack<Boolean> pila = new Stack<>();
    public static Map<String,Object> asig = new LinkedHashMap<>();
    //iterador es una clase con un visitor para poder gestionar el flujo de ejecución de las iteraciones, ya que
    //no permite hacerlo los listener.
    private iterador it = new iterador();
    //evaluaExpr es una clase que dado un Anasint.ExprContext retorna su valor. Si le pasas 3+c -> lo calcula.
    private evaluaExpr evalua = new evaluaExpr();

    //Los enter se usaran usualmente para ver si debemos ejecutar o no la instrucciones del ctx, y ejecutarlas.
    //Se añadirá true (si se puede ejecutar) o false si no. Los exit se encargarán de una vez que el walker haya
    //pasado por el ctx retirar el centilena introducido en el enter.
    //es posible que en ciertos enter no se añada nada a la pila. Esto se hace si sabes que si tienes un true/false arriba
    //sí o sí vas a ejecutar o no la instrucción hija, porque si lo sabes para que vas a introducirla. Esto se ve en
    //enterAsignación.
    public void enterPrograma(Anasint.ProgramaContext ctx) {
        System.out.println("INTÉRPRETE");
        pila.push(true);
    }
    public void exitPrograma(Anasint.ProgramaContext ctx) {
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
            List<String> vars = ctx.variable().stream().map(v -> v.getText()).collect(Collectors.toList());
            List<Anasint.ExprContext> asign = ctx.expr();
            List<Object> asignEvaluadas = asign.stream().map(x -> evalua.visit(x))
                    .collect(Collectors.toList());
            for(int i=0; i<vars.size(); i++) {
                Object evaluacion = asignEvaluadas.get(i);
                asig.put(vars.get(i), evaluacion);
                String exprAsignada = evaluacion.toString();
                //si una asignación es una expresión compuesta, quiero que se observe a la
                //dcha de donde viene el resultado.
                if (!asign.get(i).getText().equals(exprAsignada)&&!asig.get(vars.get(i)).getClass().equals(ArrayList.class))
                    exprAsignada+= " (" + asign.get(i).getText() + ")";
                System.out.println("(asignación) " + vars.get(i) + " <- " + exprAsignada);
            }
        }
    }

    public void enterCondicion(Anasint.CondicionContext ctx) {
        Boolean tieneElse = ctx.getChildCount()==8;
        Boolean cond = (Boolean) evalua.visit(ctx.expr_bool());
        //si se cumple cond debe asignarse a la pila para que las instrucciones del
        //if sean ejecutadas. Sino se añadirá false
        System.out.print("(condicional) " + ctx.expr_bool().getText());
        if(cond) System.out.print(" se satisface ");
        else System.out.print(" no se satisface ");
        if(!cond&&tieneElse) System.out.println("ejecutando else:");
        else System.out.println("");
        pila.add(cond);
    }
    public void exitCondicion(Anasint.CondicionContext ctx) {
        pila.pop();
        System.out.println("(fin condicional)");
    }
    public void enterBlq_sino(Anasint.Blq_sinoContext ctx) {
        Boolean cumpleSi = (Boolean) evalua.visit(ctx.getParent().getChild(2));
        //¿Se cumplió la condición del if?
        //si se cumplió no se debe ejecutar el else. En caso contrario sí se deberá ejecutar.
        //pudiera parecer que cumpleSi coincide con pila.peek(). Desafortunadamente esto no
        //es del to do cierto -> si hay ruptura en la cima habrá false aunque se cumpla if.
        pila.push(!cumpleSi);
    }
    public void exitBlq_sino(Anasint.Blq_sinoContext ctx) {
        pila.pop();
    }

    public void enterShow(Anasint.ShowContext ctx) {
        if(pila.peek()) {
            for(Anasint.ExprContext expr :ctx.mostrar().expr()) {
                System.out.println("(mostrar) " + evalua.visit(expr));
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
            System.out.println("(ruptura)");
        }
    }
}
