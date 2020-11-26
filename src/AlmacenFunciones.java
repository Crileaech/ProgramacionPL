import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class AlmacenFunciones extends AnasintBaseVisitor<Object> {
    //DECISIÓN DE DISEÑO 2
    /*  ------------------------------------------------------------
          func1   |      PARAM             DEV             CUERPO
          (f1)    |---------------------------------------------------
                  |variables tipos | variables tipos | variables tipos
                  |
                  |
          ------------------------------------------------------------
          func2   |      PARAM             DEV             CUERPO
          (f2)    |---------------------------------------------------
                  |variables tipos | variables tipos | variables tipos
                  |
                  |
          (fn) n=num de funciones
          almacenF = {func1:{PARAM:[[i,NUM],[s,SEQ(NUM)],[b,LOG]],DEV:[[i,NUM],[s,SEQ(NUM)],[b,LOG]],...},
          func2:{PARAM:[[i,NUM],[s,SEQ(NUM)],[b,LOG]],DEV:[[i,NUM],[s,SEQ(NUM)],[b,LOG]],...},
          func3:{PARAM:[[i,NUM],[s,SEQ(NUM)],[b,LOG]],DEV:[[i,NUM],[s,SEQ(NUM)],[b,LOG]],...}}
    */
    public Map<String,Map<String,Map<String, String>>> visitPrograma(Anasint.ProgramaContext ctx) {
        return visitSubprogramas(ctx.subprogramas());
    }

    public Map<String,Map<String,Map<String, String>>> visitSubprogramas(Anasint.SubprogramasContext ctx) {
        Map<String,Map<String,Map<String, String>>> almacenF = new HashMap<>();
        for(int i = 1; i<ctx.children.size(); i++) {
            almacenF.putAll((Map<String,Map<String,Map<String, String>>>) visit(ctx.getChild(i)));
        }
        System.out.println(almacenF);
        return almacenF;
    }

    public Map<String,Map<String,Map<String, String>>> visitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx) {
        Map<String,Map<String,Map<String, String>>> F = new HashMap<>();
        String nombre = ctx.getChild(0).getChild(1).getText(); //declaracion_subprogramas tiene un solo hijo, que es funcion o procedimiento
        //tomo el primero hijo. El segundo hijo de funcion o procedimiento es variable, que almacena el nombre del subprograma.
        Map<String,Map<String, String>> func = (Map<String,Map<String, String>>) visit(ctx.getChild(0));
        F.put(nombre,func);
        return F;
    }
    /*
      (parámetro de salida f)
      funcion: FUNCION variable PA (PARAM=params)? PC RETURN PA DEV=params PC CUERPO=variables instrucciones FFUNCION;
     {Almacena en f PARAM, DEV y CUERPO}
     */
    public Map<String,Map<String, String>> visitFuncion(Anasint.FuncionContext ctx) {
        Map<String,Map<String, String>> func = new HashMap<>(); //{PARAM:{i:NUM,s:SEQ(NUM),b:LOG},DEV:{i:NUM,s:SEQ(NUM),b:LOG}}
        Map<String, String> PARAM = (Map<String, String>) visit(ctx.getChild(3));
        Map<String, String> DEV = (Map<String, String>) visit(ctx.getChild(7));
        Map<String, String> CUERPO = (Map<String, String>) visit(ctx.variables());
        func.put("PARAM",PARAM); func.put("DEV",DEV); func.put("CUERPO",CUERPO);
        return func;
    }
    /*
    (parámetro de salida f)
    procedimiento: PROCEDIMIENTO variable PA (PARAM=params)? PC CUERPO=variables instrucciones FPROCEDIMIENTO;
    {Almacena en f PARAM, DEV (vacío) y CUERPO}
    */

    public Map<String,Map<String, String>> visitProcedimiento(Anasint.ProcedimientoContext ctx) {
        Map<String,Map<String, String>> func = new HashMap<>(); //{PARAM:{i:NUM,s:SEQ(NUM),b:LOG},CUERPO:{i:NUM,s:SEQ(NUM),b:LOG}}
        Map<String, String> PARAM = (Map<String, String>) visit(ctx.getChild(3)); //
        Map<String, String> CUERPO = (Map<String, String>) visit(ctx.variables());
        func.put("DEV",new HashMap<>()); func.put("PARAM",PARAM); func.put("CUERPO",CUERPO);
        return func;
    }

    public String visitTipos(Anasint.TiposContext ctx) {
        return (String) visit(ctx.getChild(0));
    }

    public String visitTipos_elementales(Anasint.Tipos_elementalesContext ctx) {
        return ctx.getText();
    }

    public String visitTipos_no_elementales(Anasint.Tipos_no_elementalesContext ctx) {
        return ctx.getText();
    }

    public String visitVariable(Anasint.VariableContext ctx) {
        return ctx.getText();
    }
    /*
    (parámetro de salida (r,t))
    elementales: (VAR {incluir VAR en r} COMA)* VAR {incluir VAR en r} DOSPTOS t=tipos_elementales {incluir r y t en (r,t)};
     */
    public Map<String, String> visitElementales(Anasint.ElementalesContext ctx) {
        Map<String, String> varYTipo = new HashMap<>();
        String tipo = ctx.getChild(ctx.children.size()-1).getText(); //el último hijo es tipo_elementales o tipo_no_elementales
        for(int i = 0; i<ctx.children.size()-1;i=i+2) { //de dos en dos para saltarme , y :
            String r = ctx.getChild(i).getText();
            varYTipo.put(r,tipo);
        }
        return varYTipo;
    }
    /*
    (parámetro de salida (r,t))
    secuencias: VAR {incluir VAR en r} DOSPTOS t=tipos_no_elementales {incluir r_y_t en (r,t)};
     */
    public Map<String, String> visitSecuencias(Anasint.SecuenciasContext ctx) {
        Map<String, String> varYTipo = new HashMap<>();
        String tipo = ctx.getChild(2).getText();
        String r = ctx.getChild(0).getText();
        varYTipo.put(r,tipo);
        return varYTipo;
    }

    public Map<String, String> visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx) {
        return (Map<String, String>) visit(ctx.identificador());
    }

    public Map<String, String> visitIdentificador(Anasint.IdentificadorContext ctx) {
        return (Map<String, String>) visit(ctx.getChild(0));
    }
    /*
    (parámetro de salida n)
    variables: VARIABLES (m=declaracion_variables {almacenar m en n})*;
    */
    public Map<String, String> visitVariables(Anasint.VariablesContext ctx) {
        Map<String, String> n = new HashMap<>();
        for(int i = 1; i<ctx.children.size();i++) {
            Map<String, String> m = (Map<String, String>) visit(ctx.getChild(i));
            n.putAll(m);
        }
        return n;
    }
    /*
     (parámetro de salida PARAM o DEV)
      params: t=tipos r=variable {Almacena en PARAM o DEV t y r}
            | t=tipos r=variable COMA params {Almacena en PARAM o DEV t y r}
            ; (obtención de m vista en la decisión de diseño del error 1)
     */
    public Map<String, String> visitParams(Anasint.ParamsContext ctx) {
        Map<String, String> params = new HashMap<>(); //{i:NUM,s:SEQ(NUM),b:LOG}
        String nombre = (String) visit(ctx.variable());
        String tipo = (String) visit(ctx.tipos());
        params.put(nombre,tipo);
        if(ctx.children.size()>2) {
            Map<String, String> params2 = (Map<String, String>) visit(ctx.params());
            params.putAll(params2);
        }
        return params;
    }

    //COMPROBACIÓN DE ERRORES EN LA DEVOLUCIÓN.
    // DECISIÓN DISEÑO 3.1

}