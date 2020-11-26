import org.antlr.v4.runtime.tree.ParseTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ErroresParametros extends AnasintBaseVisitor<Object>{
    //DECISIÓN DE DISEÑO 2.2
    public Object visitExpr_func(Anasint.Expr_funcContext ctx) {
        String nombreSub = ctx.children.get(0).getText();
        Boolean existeSub = anasem.almacenF.containsKey(nombreSub);
        if(existeSub) {
            System.out.println("COMPROBACIÓN DE PARÁMETROS INTRODUCIDOS EN " + nombreSub + ": ");
            List<String> tiposEntradaNecesita = anasem.almacenF.get(nombreSub).get("PARAM")
                    .values().stream().collect(Collectors.toList());
            List<ParseTree> elementosDados = new LinkedList<>();
            for(int i = 2; i < ctx.getChildCount(); i=i+2) {
                elementosDados.add(ctx.children.get(i));
            }
            List<String> tiposDadas = obtencionTipos(elementosDados);
            comprobarAsignacionesAParámetros(tiposEntradaNecesita,tiposDadas);
        } else {
            System.out.println("El subprograma " +nombreSub+ " no existe.\n");
        }
        return "";
    }

    public List<String> obtencionTipos(List<ParseTree> hijos) {
        List<String> tipos = new LinkedList<>();
        for(ParseTree hijo:hijos) {
            String tipo = (String) visit(hijo.getChild(0));
            tipos.add(tipo);
        }
        return tipos;
    }

    public String visitSacarElemInteger(Anasint.SacarElemIntegerContext ctx) {
        String nombreFunc = null;
        if(!ctx.getParent().getParent().getParent().getParent().getParent().getChild(0).getText().equals("PROGRAMA")) {
            nombreFunc = ctx.getParent().getParent().getParent().getParent().getParent().getChild(1).getText();
        }
        String tipo = extraeTipo(ctx.getChild(0).getChild(0).getText(),nombreFunc);
        if(tipo.equals("SEQ(NUM)")) {
            return "NUM";
        } else {
            return "LOG";
        }
    }
    public String visitParentesisOpInteger(Anasint.ParentesisOpIntegerContext ctx) {
        return "NUM";
    }
    public String visitOpInteger(Anasint.OpIntegerContext ctx) {
        return "NUM";
    }
    public String visitExprFuncInt(Anasint.ExprFuncIntContext ctx) {
        return "NO PERMITIDO";
    }

    public Object visitAsig(Anasint.AsigContext ctx) {
        for(int i = 0; i<ctx.asignacion().expr().size(); i++) {
            try {
                String nombreFunc = ctx.asignacion().expr(i).getChild(0).getChild(0).getChild(0).getText();
                if(anasem.almacenF.containsKey(nombreFunc)) {
                    return visit(ctx.asignacion().expr(i).getChild(0).getChild(0));
                }
            } catch(Exception e) {
            }
        }
        return "";
    }

    public String visitNum(Anasint.NumContext ctx) {
        return "NUM";
    }
    public String visitVarInt(Anasint.VarIntContext ctx) {
        String nombreFunc = null;
        if(!ctx.getParent().getParent().getParent().getParent().getParent().getChild(0).getText().equals("PROGRAMA")) {
            nombreFunc = ctx.getParent().getParent().getParent().getParent().getParent().getChild(1).getText();
        }
        return extraeTipo(ctx.getText(), nombreFunc);
    }

    public String visitTrue(Anasint.TrueContext ctx) {
        return "LOG";
    }
    public String visitFalse(Anasint.FalseContext ctx) {
        return "LOG";
    }
    public String visitSacarElemBool(Anasint.SacarElemBoolContext ctx) {
        String nombreFunc = null;
        if(!ctx.getParent().getParent().getParent().getParent().getParent().getChild(0).getText().equals("PROGRAMA")) {
            nombreFunc = ctx.getParent().getParent().getParent().getParent().getParent().getChild(1).getText();
        }
        String tipo = extraeTipo(ctx.getChild(0).getChild(0).getText(),nombreFunc);
        if(tipo.equals("SEQ(NUM)")) {
            return "NUM";
        } else {
            return "LOG";
        }
    }
    public String visitCompararBool(Anasint.CompararBoolContext ctx) {
        return "LOG";
    }
    public String visitParentesisOpBool(Anasint.ParentesisOpBoolContext ctx) {
        return "LOG";
    }
    public String visitOpBool(Anasint.OpBoolContext ctx) {
        return "LOG";
    }
    public String visitCompararSeq(Anasint.CompararSeqContext ctx) {
        return "LOG";
    }
    public String visitCompararInteger(Anasint.CompararIntegerContext ctx) {
        return "LOG";
    }
    public String visitNegacionBool(Anasint.NegacionBoolContext ctx) {
        return "LOG";
    }
    public String visitExprFuncBool(Anasint.ExprFuncBoolContext ctx) throws IllegalArgumentException {
        return "NO PERMITIDO";
    }
    public String visitVarBool(Anasint.VarBoolContext ctx) {
        String nombreFunc = null;
        if(!ctx.getParent().getParent().getParent().getParent().getParent().getChild(0).getText().equals("PROGRAMA")) {
            nombreFunc = ctx.getParent().getParent().getParent().getParent().getParent().getChild(1).getText();
        }
        return extraeTipo(ctx.getText(), nombreFunc);
    }

    public String visitVaciaSeq(Anasint.VaciaSeqContext ctx) {
        //por defecto una secuencia vacía será SEQ(NUM)
        return "SEQ(NUM)";
    }
    public String visitSeq(Anasint.SeqContext ctx) {
        String tipoInt = (String) visit(ctx.getChild(1));
        if(tipoInt.equals("NUM")) {
            return "SEQ(NUM)";
        } else {
            return "SEQ(LOG)";
        }
    }
    public String visitExprFuncSeq(Anasint.ExprFuncSeqContext ctx) {
        return "NO PERMITIDO";
    }
    public String visitVarSeq(Anasint.VarSeqContext ctx) {
        String nombreFunc = null;
        if(!ctx.getParent().getParent().getParent().getParent().getParent().getChild(0).getText().equals("PROGRAMA")) {
            nombreFunc = ctx.getParent().getParent().getParent().getParent().getParent().getChild(1).getText();
        }
        return extraeTipo(ctx.getText(), nombreFunc);
    }

    public String visitExpr_seq(Anasint.Expr_seqContext ctx) {
        //pillo el primer elemento de la secuencia
        ParseTree hijo = ctx.getChild(1).getChild(0);
        String tipoInterno = (String) visit(hijo);
        if(tipoInterno.equals("NUM")) {
            return "SEQ(NUM)";
        } else {
            return "SEQ(LOG)";
        }
    }

    public String extraeTipo(String var, String nombreFunc) {
        Map<String,String> almacenGlobal = anasem.almacenGlobal;
        String tipo;
        if(almacenGlobal.containsKey(var)) {
            tipo = almacenGlobal.get(var);
        } else if(nombreFunc!=null) {
            Map<String,Map<String,String>> m = anasem.almacenF.get(nombreFunc);
            if(m.get("PARAM").containsKey(var)) {
                tipo = m.get("PARAM").get(var);
            } else if(m.get("DEV").containsKey(var)) {
                tipo = m.get("DEV").get(var);
            } else if(m.get("CUERPO").containsKey(var)) {
                tipo = m.get("CUERPO").get(var);
            } else {
                System.out.println("EXCEPCIÓN: La variable " + var + " no ha sido declarada.");
                throw new IllegalArgumentException("ERROR: La variable introducida no ha sido declarada");
            }
        } else {
            System.out.println("EXCEPCIÓN: La variable " + var + " no ha sido declarada.");
            throw new IllegalArgumentException("ERROR: La variable introducida no ha sido declarada");
        }
        return tipo;
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
    public void comprobarAsignacionesAParámetros(List<String> tiposEntradaNecesita, List<String> tiposDadas) {
        System.out.println(tiposDadas);
        for(int i = 0; i < tiposDadas.size(); i++) {
            if(!tiposDadas.get(i).equals(tiposEntradaNecesita.get(i))) {
                if(tiposDadas.get(i).equals("NO PERMITIDO")) {
                    System.out.println("    ERROR: No se permite la introducción de subprogramas como parámetros");
                } else {
                    System.out.println("    ERROR: Se esperaba " + tiposEntradaNecesita.get(i)
                            + " y se dió " + tiposDadas.get(i));
                }
            } else {
                System.out.println("    Se introdujo " +tiposDadas.get(i) + " y se esperaba " + tiposEntradaNecesita.get(i) + " --> OK");
            }
        }
        System.out.println("");
    }
}
