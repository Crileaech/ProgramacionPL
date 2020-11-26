import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ErroresParámetros extends AnasintBaseVisitor<Object>{

    public Object visitExpr_func(Anasint.Expr_funcContext ctx) {
        String nombreSub = ctx.children.get(0).getChild(0).getText();
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
        yaComprobados.put(nombreSub,1);
        return "";
    }

    //para evitar comprobaciones múltiples.
    Map<String,Integer> yaComprobados = new HashMap<>();

    public List<String> obtencionTipos(List<ParseTree> hijos) {
        List<String> tipos = new LinkedList<>();
        for(ParseTree hijo:hijos) {
            String tipo = (String) visit(hijo.getChild(0));
            tipos.add(tipo);
        }
        return tipos;
    }
    public void comprobarAsignacionesAParámetros(List<String> tiposEntradaNecesita, List<String> tiposDadas) {
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
        for(int i = 0; i < ctx.children.size(); i++) {
            try {
                if(anasem.almacenF.containsKey(ctx.children.get(i).getChild(0).getChild(0).getText())){
                    visitExpr_func((Anasint.Expr_funcContext) ctx.getChild(i).getChild(0));
                }
            } catch(Exception e) {
            }
        }
        return "NUM";
    }
    //necesito comprobar también que expr_func tenga parámetros correctos en una asignación.

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
        for(int i = 0; i < ctx.children.size(); i++) {
            try {
                if(anasem.almacenF.containsKey(ctx.children.get(i).getChild(0).getChild(0).getText())){
                    visitExpr_func((Anasint.Expr_funcContext) ctx.getChild(i).getChild(0));
                }
            } catch(Exception e) {
            }
        }
        return "LOG";
    }
    public String visitParentesisOpBool(Anasint.ParentesisOpBoolContext ctx) {
        for(int i = 0; i < ctx.children.size(); i++) {
            try {
                if(anasem.almacenF.containsKey(ctx.children.get(i).getChild(0).getChild(0).getText())){
                    visitExpr_func((Anasint.Expr_funcContext) ctx.getChild(i).getChild(0));
                }
            } catch(Exception e) {
            }
        }
        return "LOG";
    }
    public String visitOpBool(Anasint.OpBoolContext ctx) {
        for(int i = 0; i < ctx.children.size(); i++) {
            try {
                String nombreFunc = ctx.children.get(i).getChild(0).getChild(0).getText();
                if(anasem.almacenF.containsKey(ctx.children.get(i).getChild(0).getChild(0).getText())
                                        &&yaComprobados.get(nombreFunc)!=1){
                    visitExpr_func((Anasint.Expr_funcContext) ctx.getChild(i).getChild(0));
                }
            } catch(Exception e) {
            }
        }
        return "LOG";
    }
    public String visitCompararSeq(Anasint.CompararSeqContext ctx) {
        for(int i = 0; i < ctx.children.size(); i++) {
            try {
                if(anasem.almacenF.containsKey(ctx.children.get(i).getChild(0).getChild(0).getText())){
                    visitExpr_func((Anasint.Expr_funcContext) ctx.getChild(i).getChild(0));
                }
            } catch(Exception e) {
            }
        }
        return "LOG";
    }
    public String visitCompararInteger(Anasint.CompararIntegerContext ctx) {
        for(int i = 0; i < ctx.children.size(); i++) {
            try {
                if(anasem.almacenF.containsKey(ctx.children.get(i).getChild(0).getChild(0).getText())){
                    visitExpr_func((Anasint.Expr_funcContext) ctx.getChild(i).getChild(0));
                }
            } catch(Exception e) {
            }
        }
        return "LOG";
    }
    public String visitNegacionBool(Anasint.NegacionBoolContext ctx) {
        for(int i = 0; i < ctx.children.size(); i++) {
            try {
                if(anasem.almacenF.containsKey(ctx.children.get(i).getChild(0).getChild(0).getText())){
                    visitExpr_func((Anasint.Expr_funcContext) ctx.getChild(i).getChild(0));
                }
            } catch(Exception e) {
            }
        }
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
}
