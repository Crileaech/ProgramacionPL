import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class VerificarAmbiguedad extends AnasintBaseVisitor<Object>{

    //almacen de ambigüedades
    public Map<String,Boolean> aAmbiguedad = new HashMap <>();
    public Map<String, Map<String, Boolean>> aAmbiguedadFunciones = new HashMap<>();
    public Map<String,Boolean> aux = new HashMap<>();


    /*--------------------------------------------------------------
    |                             ENTEROS                          |
    ---------------------------------------------------------------*/
    public Boolean visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx){
        //comprueba si la secuencia existe
        //y si la variable parámetro es entera
        String nVariable = ctx.expr_sacar_elem().variable().VAR().getText();
        return  !aux.get(nVariable) && (Boolean) visit(ctx.expr_sacar_elem().expr_integer());
    }

    //terminada
    public Boolean visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx){
        return (Boolean) visit(ctx.getChild(1)) || (Boolean) visit(ctx.getChild(3));
    }

    //terminada
    public Boolean visitOpInteger(Anasint.OpIntegerContext ctx){
        return (Boolean) visit(ctx.getChild(0)) || (Boolean) visit(ctx.getChild(2));
    }

    //terminada
    public Boolean visitExprFuncInt(Anasint.ExprFuncIntContext ctx){
        //si existe la función, no es ambiguo
        String nombreF = ctx.expr_func().variable().VAR().getText();
        Boolean c = true;
        if (aAmbiguedadFunciones.get(nombreF) != null)
            c = false;
        return c;
    }

    //terminada
    public Boolean visitNum(Anasint.NumContext ctx){
        return false;
    }

    //terminada
    public Boolean visitVarInt(Anasint.VarIntContext ctx){
        String posibleAmbig = ctx.getChild(0).getText();
        return !aux.containsKey(posibleAmbig) || aux.get(posibleAmbig);


        /*Boolean b;
        if (aAmbiguedad.containsKey(posibleAmbig))
            b = aAmbiguedad.get(posibleAmbig);
        else
            b = true;
        return b;*/
    }

    /*--------------------------------------------------------------
    |                           BOOLEANOS                          |
    ---------------------------------------------------------------*/

    //terminada
    public Boolean visitTrue(Anasint.TrueContext ctx){
        return false;
    }

    //terminada
    public Boolean visitFalse(Anasint.FalseContext ctx){
        return false;
    }

    //terminada
    public Boolean visitSacarElemBool(Anasint.SacarElemBoolContext ctx){
        //¿existe la secuencia?
        System.out.println(ctx.expr_sacar_elem().variable().VAR().getText());
        return true;
    }

    //terminada
    public Boolean visitCompararBool(Anasint.CompararBoolContext ctx){
        return (Boolean) visit(ctx.getChild(0)) || (Boolean) visit(ctx.getChild(2));
    }

    //terminada
    public Boolean visitParentesisOpBool(Anasint.ParentesisOpBoolContext ctx){
        return (Boolean) visit(ctx.getChild(1)) || (Boolean) visit(ctx.getChild(3));
    }

    //terminada
    public Boolean visitOpBool(Anasint.OpBoolContext ctx){
        return (Boolean) visit(ctx.getChild(0)) || (Boolean) visit(ctx.getChild(2));
    }

    //terminada
    public Boolean visitCompararSeq(Anasint.CompararSeqContext ctx){
        return (Boolean) visit(ctx.getChild(0)) || (Boolean) visit(ctx.getChild(2));
    }

    //terminada
    public Boolean visitCompararInteger(Anasint.CompararIntegerContext ctx){
        return (Boolean) visit(ctx.getChild(0)) || (Boolean) visit(ctx.getChild(2));
    }

    //terminada
    public Boolean visitNegacionBool(Anasint.NegacionBoolContext ctx){
        return (Boolean) visit(ctx.expr_bool());
    }

    //terminada
    public Boolean visitExprFuncBool(Anasint.ExprFuncBoolContext ctx){
        String nombreF = ctx.expr_func().variable().VAR().getText();
        Boolean c = true;
        if (aAmbiguedadFunciones.get(nombreF) != null)
            c = false;
        return c;
    }

    //terminada
    public Boolean visitVarBool(Anasint.VarBoolContext ctx){
        String posibleAmbig = ctx.getChild(0).getText();
        return !aux.containsKey(posibleAmbig) || aux.get(posibleAmbig);
    }

    /*--------------------------------------------------------------
    |                           SECUENCIAS                         |
    ---------------------------------------------------------------*/
    //terminada
    public Boolean visitVaciaSeq(Anasint.VaciaSeqContext ctx){
        return false;
    }

    //terminada
    public Boolean visitSeq(Anasint.SeqContext ctx){
        return false;
    }

    //terminada
    public Boolean visitExprFuncSeq(Anasint.ExprFuncSeqContext ctx){
        String nombreF = ctx.expr_func().variable().VAR().getText();
        Boolean c = true;
        if (aAmbiguedadFunciones.get(nombreF) != null)
            c = false;
        return c;
    }

    //terminada
    public Boolean visitVarSeq(Anasint.VarSeqContext ctx){
        String posibleAmbig = ctx.getChild(0).getText();
        return !aux.containsKey(posibleAmbig) || aux.get(posibleAmbig);
    }


    /*---------------------------------------------------------------
    |                   DECLARACIONES Y ASIGNACIONES                |
    ---------------------------------------------------------------*/

    //terminada
    /*public Map<String, Map<String,Boolean>> visitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx) {
        System.out.println(ctx.getChild(0).getChild(1).getText());
        return (Map<String,Map<String,Boolean>>) visit(ctx.getChild(0));
    }

    public Map<String, Map<String,Boolean>> visitFuncion(Anasint.FuncionContext ctx) {
        Map<String, Map<String,Boolean>> params = new HashMap<>();
        Map<String,Boolean> params2 = new HashMap<>();

        for(int i = 0; i < ctx.params().size(); i++){
           auxFunciones.put(ctx.variable().VAR().getText(), (Map<String,Boolean>) visit(ctx.params(i)));
        }

        for (int i = 0; i < ctx.variables().declaracion_variables().size(); i++){
            params2.putAll((Map<String,Boolean>) visit(ctx.variables().declaracion_variables(i)));
        }

        for (int i = 0; i < ctx.instrucciones().declaracion_instrucciones().size(); i++)
            params2.putAll((Map<String,Boolean>) visit(ctx.instrucciones().declaracion_instrucciones(i)));

        params.put(ctx.variable().VAR().getText(), params2);
        return params;
    }

    public Map<String, Map<String,Boolean>> visitProcedimiento(Anasint.ProcedimientoContext ctx) {
        Map<String, Map<String,Boolean>> params = new HashMap<>();
        Map<String,Boolean> params2 = new HashMap<>();

        params2.putAll((Map<String,Boolean>) visit(ctx.params()));

        for (int i = 0; i < ctx.variables().declaracion_variables().size(); i++)
            params2.putAll((Map<String,Boolean>) visit(ctx.variables().declaracion_variables(i)));

        params.put(ctx.variable().VAR().getText(), params2);

        return params;
    }*/

    //terminada
    public Map<String, Boolean> visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx){
        Map<String, Boolean> params = new HashMap<>();
        params.putAll((Map<String,Boolean>) visit(ctx.identificador()));

        return params;
    }

    //terminada
    public Map<String, Boolean> visitIdentificador(Anasint.IdentificadorContext ctx){
        Map<String, Boolean> params = new HashMap<>();

        for(int i = 0; i < ctx.getChild(0).getChildCount()-2; i+=2){
            params.put(ctx.getChild(0).getChild(i).getText(), true);
        }

        return params;
    }

    //terminada
    public Map<String,Boolean> visitAsignacion(Anasint.AsignacionContext ctx){
        Map<String, Boolean> params = new HashMap<>();
        int n_hijos = ctx.getChildCount();

        //asignación simple
        if (n_hijos == 4)
            params.put(ctx.variable(0).VAR().getText(), (Boolean) visit(ctx.expr(0)));

        //asignación múltiple
        else
            if (ctx.variable().size() == ctx.expr().size())
                for(int i = 0; i < ctx.variable().size(); i++)
                    params.put(ctx.variable(i).VAR().getText(), (Boolean) visit(ctx.expr(i)));



        return params;
    }

    //terminada
    public Map<String,Boolean> visitParams(Anasint.ParamsContext ctx){
        Map<String,Boolean> params = new HashMap<>();
        params.put(ctx.variable().VAR().getText(), false);

        if(ctx.children.size()>2){
            params.putAll((Map<String,Boolean>) visit(ctx.params()));
        }

        return params;
    }
}
