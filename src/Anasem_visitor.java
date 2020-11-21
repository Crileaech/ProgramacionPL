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

public class Anasem_visitor extends AnasintBaseVisitor<Object>{
    /*(parámetro de salida n)
    variables: VARIABLES (m=declaracion_variables {almacenar m en n})*;
     */
    public Object visitVariables(Anasint.VariablesContext ctx){
        Map<String,Integer> n= new HashMap<>();
        for (int i=1;i<ctx.children.size();i++){
            Map<String,Integer>m = (Map<String,Integer>)visit(ctx.children.get(i));
            n.putAll(m);
        }
        return n;
    }

    /*
       (parámetro de salida m)
       declaracion_variables: (r,t)=identificador PyC; {Almacenar en m cada variable en r con tipo t}
   */
    public Object visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx){
        Map<String,Integer> m= new HashMap<>();
        Set<String>r = (Set<String>)visit(ctx);
        Integer t = (Integer)visit(ctx.identificador());
        r.stream().forEach((v)->m.put(v,t));
        return m;
    }
    /*(parámetro de salida (r,t))
    elementales: (VAR {incluir VAR en r} COMA)* VAR {incluir VAR en r} DOSPTOS t=tipos_elementales {incluir r y t en (r,t)};
     */
    public Object visitElementales(Anasint.ElementalesContext ctx){
        Set<Object> r = new HashSet<>();
        r.add(ctx.variable());
        if(ctx.getChildCount() > 1 ) {
            Set<Object> t = (Set<Object>) visit(ctx.tipos_elementales());
            r.addAll(t);
        }
        return r;
    }

    /*(parámetro de salida (r,t))
    secuencias: VAR {incluir VAR en r} DOSPTOS t=tipos_no_elementales {incluir r_y_t en (r,t)};
    */
    public Object visitSecuencias(Anasint.SecuenciasContext ctx){
        Set<Object> r = new HashSet<>();
        r.add(ctx.variable());
        if(ctx.getChildCount() > 1 ) {
            Set<Object> t = (Set<Object>) visit(ctx.tipos_no_elementales());
            r.addAll(t);
        }
        return r;
    }

    /*(parámetro de salida t)
    tipos: tipos_elementales
             | tipos_no_elementales
    ;

    /*tipos_elementales: NUMERO {t=numero}
                         | BOOL {t=lógico}
    ;
    */
    public Object visitNum(Anasint.Tipos_elementalesContext ctx){
        return Anasint.NUMERO;
    }
    public Object visitBoolean(Anasint.Tipos_elementalesContext ctx){
        return Anasint.BOOL;
    }
    /*tipos_no_elementales: SEQ_NUM {t=secuencia numérica}
                            | SEQ_BOOL {t=secuencia lógica}
    ;
    */
    public Object visitSeqNum(Anasint.Tipos_no_elementalesContext ctx){
        return Anasint.SEQ_NUM;
    }
    public Object visitSeqBool(Anasint.Tipos_no_elementalesContext ctx){
        return Anasint.SEQ_BOOL;
    }



}
    