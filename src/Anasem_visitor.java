import java.util.HashMap;
import java.util.Map;

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

        Map<String,String> n= new HashMap<>();
        for (int i=1;i<ctx.children.size();i++){
            Map<String,String> m = (Map<String,String>)visit(ctx.getChild(i));
            n.putAll(m);
        }
        return n;
    }

    /*
       (parámetro de salida m)
       declaracion_variables: (r,t)=identificador PyC; {Almacenar en m cada variable en r con tipo t}
   */
//    public Object visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx){
//        Map<String,Integer> m= new HashMap<>();
//        Set<String>r = (Set<String>)visit(ctx);
//        Integer t = (Integer)visit(ctx.identificador());
//        r.stream().forEach((v)->m.put(v,t));
//        return m;
//    }
    /*(parámetro de salida (r,t))
    elementales: (VAR {incluir VAR en r} COMA)* VAR {incluir VAR en r} DOSPTOS t=tipos_elementales {incluir r y t en (r,t)};
     */
//    public Object visitElementales(Anasint.ElementalesContext ctx){
//        Set<Object> r = new HashSet<>();
//        r.add(ctx.variable());
//        if(ctx.getChildCount() > 1 ) {
//            Set<Object> t = (Set<Object>) visit(ctx.tipos_elementales());
//            r.addAll(t);
//        }
//        return r;
//    }

    /*(parámetro de salida (r,t))
    secuencias: VAR {incluir VAR en r} DOSPTOS t=tipos_no_elementales {incluir r_y_t en (r,t)};
    */
//    public Object visitSecuencias(Anasint.SecuenciasContext ctx){
//        Set<Object> r = new HashSet<>();
//        r.add(ctx.variable());
//        if(ctx.getChildCount() > 1 ) {
//            Set<Object> t = (Set<Object>) visit(ctx.tipos_no_elementales());
//            r.addAll(t);
//        }
//        return r;
//    }

    /*(parámetro de salida t)
    tipos: tipos_elementales
             | tipos_no_elementales
    ;

     */
    public Integer visitTipos(Anasint.TiposContext ctx, String var) {
        Map<String, Integer> variables = new HashMap<>();
        variables.put(var, ctx.getStart().getType());
        return null;
    }

    /*tipos_elementales: NUMERO {t=numero}
                         | BOOL {t=lógico}
    ;
    */
    public Integer visitNum(Anasint.Tipos_elementalesContext ctx){
        return Anasint.NUMERO;
    }
    public Integer visitBoolean(Anasint.Tipos_elementalesContext ctx){
        return Anasint.BOOL;
    }
    /*tipos_no_elementales: SEQ_NUM {t=secuencia numérica}
                            | SEQ_BOOL {t=secuencia lógica}
    ;
    */
    public Integer visitSeqNum(Anasint.Tipos_no_elementalesContext ctx){
        return Anasint.SEQ_NUM;
    }
    public Integer visitSeqBool(Anasint.Tipos_no_elementalesContext ctx){
        return Anasint.SEQ_BOOL;
    }

    /* (DECISIÓN 1.3)
     El cálculo del tipo de una expresión se basa en las siguientes funciones.

     funcion tipoOperaciónNumérica(tipo1,tipo2)
           si tipo1 o tipo2 es igual a tipo inválido entonces
                 tipo = tipo inválido
           sino
                 si tipo1 es igual a tipo2 entonces //no hay que mirar si tipo1 o tipo2 son numéricos pues ya lo comprueba el sintáctico
                     tipo = tipo1
                 sino
                     tipo = tipo inválido

     */
    public Integer visitOp_integer(Anasint.Op_integerContext ctx) {
        Integer t1 = (Integer) visit(ctx.POR());
        Integer t2 = (Integer) visit(ctx.RESTA());
        if (t1==null || t2==null) return null;
        else
        if (t1.equals(t2) && t1==Anasint.NUM) return Anasint.NUM;
        else return null;
    }


    /*funcion tipoComparaciónNumérica(tipo1,tipo2)
          si tipo1 o tipo2 es igual a tipo inválido entonces
                tipo = tipo inválido
          sino
                 si tipo1 y tipo2 son iguales entonces //no hay que mirar si tipo1 o tipo2 son numéricos pues ya lo comprueba el sintáctico
                     tipo = lógico
                 sino
                     tipo = tipo inválido*/

    public Integer visitComp_integer(Anasint.Comp_integerContext ctx) {
        Integer t1 = (Integer) visit(ctx.MAYOR());
        Integer t2 = (Integer) visit(ctx.MENOR());
        if (t1==null || t2==null) return null;
        else
        if (t1.equals(t2) && t1==Anasint.NUM) return Anasint.NUM;
        else return null;
    }
    /*
    * funcion tipoComparaciónIgualdad(tipo1,tipo2)
          si tipo1 o tipo2 es igual a tipo inválido entonces
                tipo = tipo inválido
          sino
                 tipo = lógico
    */
    public Integer visitComp_bool(Anasint.Comp_boolContext ctx) {
        Integer t1 = (Integer) visit(ctx.DISTINTO());
        Integer t2 = (Integer) visit(ctx.IGUALL());
        if (t1==null || t2==null) return null;
        else
        if (t1.equals(t2) && t1==Anasint.BOOL) return Anasint.BOOL;
        else return null;
    }
    /*funcion tipoOperaciónLógica(tipo1,tipo2)
            si tipo1 o tipo2 es igual a tipo inválido entonces
                  tipo = tipo inválido
            sino
                  si tipo1 y tipo2 son iguales entonces
                      tipo = tipo1
                  sino
                      tipo = tipo inválido
     */
    public Integer visitOp_bool(Anasint.Op_boolContext ctx) {
        Integer t1 = (Integer) visit(ctx.AND());
        Integer t2 = (Integer) visit(ctx.OR());
        if (t1==null || t2==null) return null;
        else
        if (t1.equals(t2) && t1==Anasint.BOOL) return Anasint.BOOL;
        else return null;
    }
}
    