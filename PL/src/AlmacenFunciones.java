import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlmacenFunciones extends AnasintBaseVisitor<Object> {
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
    public Map<String,Map<String,List<List<String>>>> visitSubprogramas(Anasint.SubprogramasContext ctx) {
        Map<String,Map<String,List<List<String>>>> almacenF = new HashMap<>();
        for(int i = 1; i<ctx.children.size(); i++) {
            almacenF.putAll((Map<String,Map<String,List<List<String>>>>) visit(ctx.getChild(i)));
        }
        System.out.println(almacenF);
        return almacenF;
    }

    public Map<String,Map<String,List<List<String>>>> visitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx) {
        Map<String,Map<String,List<List<String>>>> F = new HashMap<>();
        String nombre = ctx.getChild(0).getChild(1).getText(); //declaracion_subprogramas tiene un solo hijo, que es funcion o procedimiento
        //tomo el primero hijo. El segundo hijo de funcion o procedimiento es variable, que almacena el nombre del subprograma.
        Map<String,List<List<String>>> func = (Map<String, List<List<String>>>) visit(ctx.getChild(0));
        F.put(nombre,func);
        return F;
    }
    /*
      (parámetro de salida f)
      funcion: FUNCION variable PA (PARAM=params)? PC RETURN PA DEV=params PC CUERPO=variables instrucciones FFUNCION;
     {Almacena en f PARAM, DEV y CUERPO}
     */
    public Map<String,List<List<String>>> visitFuncion(Anasint.FuncionContext ctx) {
        Map<String,List<List<String>>> func = new HashMap<>(); //{PARAM:[[i,NUM],[s,SEQ(NUM)],[b,LOG]],DEV:[[i,NUM],[s,SEQ(NUM)],[b,LOG]],CUERPO:...}
        List<List<String>> PARAM = (List<List<String>>) visit(ctx.getChild(3));
        List<List<String>> DEV = (List<List<String>>) visit(ctx.getChild(7));
        List<List<String>> CUERPO = (List<List<String>>) visit(ctx.variables());
        func.put("PARAM",PARAM); func.put("DEV",DEV); func.put("CUERPO",CUERPO);
        return func;
    }
    /*
    (parámetro de salida f)
    procedimiento: PROCEDIMIENTO variable PA (PARAM=params)? PC CUERPO=variables instrucciones FPROCEDIMIENTO;
    {Almacena en f PARAM, DEV (vacío) y CUERPO}
    */

    public Map<String,List<List<String>>> visitProcedimiento(Anasint.ProcedimientoContext ctx) {
        Map<String,List<List<String>>> func = new HashMap<>(); //{PARAM:[[i,NUM],[s,SEQ(NUM)],[b,LOG]],DEV:null,CUERPO:...}
        List<List<String>> PARAM = (List<List<String>>) visit(ctx.getChild(3)); //
        List<List<String>> CUERPO = (List<List<String>>) visit(ctx.variables());
        func.put("PARAM",PARAM); func.put("CUERPO",CUERPO);
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
    public List<List<String>> visitElementales(Anasint.ElementalesContext ctx) {
        List<List<String>> varYTipo = new ArrayList<>();
        String tipo = ctx.getChild(ctx.children.size()-1).getText(); //el último hijo es tipo_elementales o tipo_no_elementales
        for(int i = 0; i<ctx.children.size()-1;i=i+2) { //de dos en dos para saltarme , y :
            List<String> r_y_t = new ArrayList<String>();
            r_y_t.add(ctx.getChild(i).getText()); r_y_t.add(tipo);
            varYTipo.add(r_y_t);
        }
        return varYTipo;
    }
    /*
    (parámetro de salida (r,t))
    secuencias: VAR {incluir VAR en r} DOSPTOS t=tipos_no_elementales {incluir r_y_t en (r,t)};
     */
    public List<List<String>> visitSecuencias(Anasint.SecuenciasContext ctx) {
        List<List<String>> varYTipo = new ArrayList<>();
        String tipo = ctx.getChild(2).getText();
        List<String> r_y_t = new ArrayList<String>();
        r_y_t.add(ctx.getChild(0).getText()); r_y_t.add(tipo);
        varYTipo.add(r_y_t);
        return varYTipo;
    }

    public List<List<String>> visitDeclaracion_variables(Anasint.Declaracion_variablesContext ctx) {
        return (List<List<String>>) visit(ctx.identificador());
    }

    public List<List<String>> visitIdentificador(Anasint.IdentificadorContext ctx) {
        return (List<List<String>>) visit(ctx.getChild(0));
    }
    /*
    (parámetro de salida n)
    variables: VARIABLES (m=declaracion_variables {almacenar m en n})*;
    */
    public List<List<String>> visitVariables(Anasint.VariablesContext ctx) {
        List<List<String>> n = new ArrayList<>();
        for(int i = 1; i<ctx.children.size();i++) {
            List<List<String>> m = (List<List<String>>) visit(ctx.getChild(i));
            n.addAll(m);
        }
        return n;
    }
    /*
     (parámetro de salida PARAM o DEV)
      params: t=tipos r=variable {Almacena en PARAM o DEV t y r}
            | t=tipos r=variable COMA params {Almacena en PARAM o DEV t y r}
            ; (obtención de m vista en la decisión de diseño del error 1)
     */
    public List<List<String>> visitParams(Anasint.ParamsContext ctx) {
        List<List<String>> params = new ArrayList<>(); //[[i,NUM],[s,SEQ(NUM)],[b,LOG]]
        String nombre = (String) visit(ctx.variable());
        String tipo = (String) visit(ctx.tipos());
        List<String> tNombre = new ArrayList<>();
        tNombre.add(nombre); tNombre.add(tipo);
        params.add(tNombre);
        if(ctx.children.size()>2) {
            List<List<String>> params2 = (List<List<String>>) visit(ctx.params());
            params.addAll(params2);
        }
        return params;
    }
}
