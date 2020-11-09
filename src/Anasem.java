import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import  org.antlr.v4.runtime.RuleContext;

/*
Aunque existe dos implementaciones alternativas de la gramática atribuida
nostros la vamos a llevar a acabo mediante visitante.

Para completar el visitante, hay que implementar el código de visita
para las reglas de la gramática atribuida que usen parámetros o realice
alguna acción (acción = sentencias entre llaves). El código de visita es un
método visit con un sufijo que identifica la regla de la gramática

*/

public class Anasem extends AnasintBaseVisitor<Object>{
    /*(parámetro de salida t)
   tipo: NUMERO {t=entero}
    | BOOL {t=booleana}
    | SEQ(NUM) {t=secuencia numerica}
    | SEQ(LOG) {t=secuencia logica}
    ;*/
    public Object visitTipo(Anasint.ElementalesContext ctx){
        Integer t = ctx.getStart().getType();
        return t;
    }
    /* (parámetro de salida r)
    vars : (variable {incluir variable en r} COMA)* variable
     */
    public Object visitVars(Anasint.IdentificadorContext ctx){
        Set<String> r = new HashSet<String>();
        r.add(ctx.elementales().VAR());
        if (ctx.getChildCount()>1){
            Set<String> s = (Set<String>)visit(ctx.elementales());
            r.addAll(s);
        }
        return r;
    }

    /*
    * (parámetro de salida m)
   decl_vars : r=vars DOSPTOS t=tipo PyC {almacenar en m cada variable en r con tipo t}(parámetro de salida m)
    */
    public Object visitDecl_vars(Anasint.Declaracion_variablesContext ctx){
        Map<String,Integer> m= new HashMap<>();
        Set<String>r = (Set<String>)visit(ctx.identificador().elementales());
        Integer t = (Integer)visit(ctx.identificador());
        r.stream().forEach((v)->m.put(v,t));
        return m;
    }

    /* (parámetro de salida n)
       variables : VARIABLES (m=decl_vars {almacenar m en n})*
    */
    public Object visitVariables(Anasint.VariablesContext ctx){
        Map<String,Integer> n= new HashMap<>();
        for (int i=1;i<ctx.children.size();i++){
            Map<String,Integer>m = (Map<String,Integer>)visit(ctx.children.get(i));
            n.putAll(m);
        }
        return n;
    }





}
    