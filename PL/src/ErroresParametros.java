import org.antlr.v4.runtime.tree.ParseTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ErroresParametros extends AnasintBaseListener{
    //DECISIÓN DE DISEÑO 2.2
   public void exitExpr_func(Anasint.Expr_funcContext ctx) {
        String nombreSub = ctx.children.get(0).getText();
        Boolean existeSub = anasem.almacenF.containsKey(nombreSub);
        if(existeSub) {
            System.out.println("COMPROBACIÓN DE PARÁMETROS INTRODUCIDOS EN " + nombreSub + ": ");
            List<String> tiposEntradaNecesita = anasem.almacenF.get(nombreSub).get("PARAM")
                    .values().stream().collect(Collectors.toList());
            List<String> varsDadas = new LinkedList<>();
            for(int i = 2; i < ctx.getChildCount(); i=i+2) {
                varsDadas.add(ctx.children.get(i).getText());
            }
            List<String> tiposDadas = compruebaDadas(varsDadas,ctx);
            comprobarAsignacionesAParámetros(tiposEntradaNecesita,tiposDadas,varsDadas);
        } else {
            System.out.println("El subprograma " +nombreSub+ " no existe.\n");
        }
    }

    //DECISIÓN DE DISEÑO 2.2
    /*
      función comprobarAsignacionesAParámetros(tipo_parametros, tipo_exprs)
         almacen n
         pares = pares_var_expr(tipo_parametros, tipo_exprs)
         para cada par en pares:
             añado en n comprobarAsignaciónAParámetro(tipo_param en par, tipo_expr en par)
         si en n no error entonces
             no error
         sino
             error

     función comprobarAsignaciónAParámetro(tipo_parametro, tipo_expr)
        si tipo_parametro es igual a tipo_expr entonces
            no error
        sino
            error

     */
    public void comprobarAsignacionesAParámetros(List<String> tiposEntradaNecesita, List<String> tiposDadas, List<String> varsDadas) {
        for(int i = 0; i < tiposDadas.size(); i++) {
            if(!tiposDadas.get(i).equals(tiposEntradaNecesita.get(i))) {
                System.out.println("    ERROR: Se esperaba " + tiposEntradaNecesita.get(i)
                        + " y se dió " + tiposDadas.get(i));
            } else {
                System.out.println("    Se introdujo " + varsDadas.get(i)
                        + " (" +tiposDadas.get(i) +")"+ " y se esperaba " + tiposEntradaNecesita.get(i) + " --> OK");
            }
        }
        System.out.println("");
    }

    public List<String> compruebaDadas(List<String> varsDadas, Anasint.Expr_funcContext ctx) {
        Map<String,String> almacenGlobal = anasem.almacenGlobal;
        Boolean estamosEnFuncion = !ctx.getParent().getParent().getParent().getChild(0).getText().equals("PROGRAMA");
        List<String> tiposObtenidos = new LinkedList<>();
        for(String var: varsDadas) {
            if(almacenGlobal.containsKey(var)) {
                tiposObtenidos.add(almacenGlobal.get(var));
            } else if(estamosEnFuncion) {
                String nombreFunc = ctx.getParent().getParent().getParent().getChild(1).getText();
                Map<String,Map<String,String>> m = anasem.almacenF.get(nombreFunc);
                if(m.get("PARAM").containsKey(var)) {
                    tiposObtenidos.add(m.get("PARAM").get(var));
                } else if(m.get("DEV").containsKey(var)) {
                    tiposObtenidos.add(m.get("DEV").get(var));
                } else if(m.get("CUERPO").containsKey(var)) {
                    tiposObtenidos.add(m.get("CUERPO").get(var));
                } else {
                    System.out.println("EXCEPCIÓN: La variable " + var + " no ha sido declarada.");
                    throw new IllegalArgumentException("ERROR: La variable introducida no ha sido declarada");
                }
            } else {
                System.out.println("EXCEPCIÓN: La variable " + var + " no ha sido declarada.");
                throw new IllegalArgumentException("ERROR: La variable introducida no ha sido declarada");
            }
        }
        return tiposObtenidos;
    }
}
