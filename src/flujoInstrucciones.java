import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class flujoInstrucciones extends AnasintBaseListener{
    public static Stack<Boolean> pila = new Stack<>();
    public static Map<String,Object> asig = new LinkedHashMap<>();
    private iterador it = new iterador();
    private evaluaExpr evalua = new evaluaExpr();

    // Función para establecer un mapa asig ya definido
    public static void setMap(Map<String,Object> m) {
        asig = m;
    }

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
    public void enterDecVarElem(Anasint.DecVarElemContext ctx) {
        if(pila.peek()) {
            for(int i = 0; i<ctx.getChildCount()-1; i+=2) {
                asig.put(ctx.getChild(i).getText(), null);
            }
        }
    }
    public void enterDecVarSeq(Anasint.DecVarSeqContext ctx) {
        if(pila.peek()) {
            asig.put(ctx.getChild(0).getText(), null);
        }
    }
    public void exitVariables(Anasint.VariablesContext ctx) {
        pila.pop();
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
    public void enterDeclaracion_instrucciones(Anasint.Declaracion_instruccionesContext ctx) {
        pila.push(pila.peek());
    }
    public void enterAsignacion(Anasint.AsignacionContext ctx) {
        if(pila.peek()) {
            List<String> vars = ctx.variable().stream().map(v -> v.getText()).collect(Collectors.toList());
            List<Anasint.ExprContext> asign = ctx.expr();
            for(int i=0; i<vars.size(); i++) {
                //Object res = evalua.visit(asign.get(i));
                asig.put(vars.get(i), evalua.visit(asign.get(i)));
                String exprAsignada = asig.get(vars.get(i)).toString();
                if (!asign.get(i).getText().equals(exprAsignada)) exprAsignada+= " (" + asign.get(i).getText() + ")";
                System.out.println("(asignación) " + vars.get(i) + " <- " + exprAsignada);
            }
        }
    }
    public void exitInstrucciones(Anasint.InstruccionesContext ctx) {
        pila.pop();
    }
    public void exitDeclaracion_instrucciones(Anasint.Declaracion_instruccionesContext ctx) {
        if(pila.peek()&&ctx.BREAK()!=null) {
            pila.pop();
            pila.push(false);
            System.out.println("(ruptura)");
        } else {
            pila.pop();
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
    public void enterBlq_sino(Anasint.Blq_sinoContext ctx) {
        Boolean cumpleSi = (Boolean) evalua.visit(ctx.getParent().getChild(2));
        //¿Se cumplió la condición del if?
        //si se cumplió no se debe ejecutar el else. En caso contrario sí se deberá ejecutar.
        //pudiera parecer que cumpleSi coincide con pila.peek(). Desafortunadamente esto no
        //es del todo cierto -> si hay ruptura en la cima habrá false aunque se cumpla if.
        pila.push(!cumpleSi);
    }
    public void exitCondicion(Anasint.CondicionContext ctx) {
        pila.pop();
        System.out.println("(fin condicional)");
    }
    public void exitBlq_sino(Anasint.Blq_sinoContext ctx) {
        pila.pop();
    }
    public void enterMostrar(Anasint.MostrarContext ctx) {
        if(pila.peek()) {
            for(Anasint.ExprContext expr :ctx.expr()) {
                System.out.println("(mostrar) " + evalua.visit(expr));
            }
        }
    }
    public void enterIteracion(Anasint.IteracionContext ctx) {
        if(pila.peek()) {
            pila.push(true);
            it.visit(ctx);
        }
    }
    public void exitIteracion(Anasint.IteracionContext ctx) {
        pila.pop();
    }
}
