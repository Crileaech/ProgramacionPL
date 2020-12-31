import org.antlr.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Compilador extends AnasintBaseListener {
    ///////////////////////////
    // VARIABLES GLOBALES
    //////////////////////////
    Generador generador = new Generador(); //traductor de árbolparse a texto
    ExtraerVarsExpr extractor = new ExtraerVarsExpr(); //extractor de variables de una expresión
    FileWriter fichero; //Fichero para escribir el resultado de la compilación

    String EntradaCompilador = null; //Nombre del fichero compilador
    int espacios = 0; //Contador de espacios en blanco. Sirve para indentar el código generado.
    Map<String, Anasint.ExprContext> almacen_definiciones_Integer = new HashMap<>(); //almacen de las definiciones de variables
    Map<String, Anasint.ExprContext> almacen_definiciones_Bool = new HashMap<>();
    public static Map<String, Anasint.ExprContext> almacen_definiciones_Seq_Integer = new HashMap<>();
    public static Map<String, Anasint.ExprContext> almacen_definiciones_Seq_Bool = new HashMap<>();
    Map<String, Anasint.ExprContext> almacen_definiciones_Temporal = new HashMap<>();

    ///////////////////////////
    // METODOS GLOBALES
    //////////////////////////
    //Nombre del fichero sin la extensión
    public void init(String f){
        EntradaCompilador=new String(f.substring(0,17)); }
    //Abrir fichero
    private void open_file(){
        try{
            fichero = new FileWriter("src/"+EntradaCompilador+".java");
        }catch(IOException e)
        {System.out.println("open_file (exception): "+e.toString());}
    }
    //Cerrar fichero
    private void close_file(){
        try{
            fichero.close();
        }catch(IOException e)
        {System.out.println("close_file (exception): "+e.toString());}
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Integer(List<TerminalNode> var) {
        String aux = new String();
        for (int i = 0; i < var.size(); i++) {
            aux = var.get(i).getText();
            almacen_definiciones_Integer.put(aux, null);
        }
    }
    public void declarar_variable_Seq_Integer(String var) {
            almacen_definiciones_Seq_Integer.put(var, null);
    }
        public void declarar_variable_Bool(List<TerminalNode> var) {
            String aux = new String();
            for (int i = 0; i < var.size(); i++) {
                aux = var.get(i).getText();
                almacen_definiciones_Bool.put(aux, null);
            }
        }

    public void declarar_variable_Seq_Bool(String var) {
        almacen_definiciones_Seq_Bool.put(var, null);
    }
         //definición por defecto (null equivaldría a 0)

    //Actualizar la definición de una variable
    public void definir_variable_Integer(String var, Anasint.ExprContext expr){
        almacen_definiciones_Integer.put(var,expr);
    }

    public void definir_variable_Seq_Integer(String var, Anasint.ExprContext expr){
        almacen_definiciones_Seq_Integer.put(var,expr);
    }

    public void definir_variable_Bool(String var, Anasint.ExprContext expr){
        almacen_definiciones_Bool.put(var,expr);
    }

    public void definir_variable_Seq_Bool(String var, Anasint.ExprContext expr){
        almacen_definiciones_Seq_Bool.put(var,expr);
    }
    //Escribir espacios en blanco en fichero de salida
    private void gencode_espacios(){
        try{
            for (int i = 1; i<=espacios;i++)
                fichero.write(" ");
        }catch(IOException e)
        {System.out.println("gencode_espacios (exception): "+e.toString());}
    }

    //Generar código para v = exp
    public void gencodigo_asignacion(ParseTree var, Anasint.ExprContext exp){
        String txt_exp="0";
        String v = new String();
        v = var.getText();
        if (exp != null)
            txt_exp = generador.visit(exp);
        gencode_espacios();

        try {
            fichero.write(v + "=" + txt_exp + ";\n"); //código de una asignación
        } catch (IOException e) {
            e.getMessage();
        }

    }

    //Generar código comienzo clase
    private void gencode_begin_class(){
        try{
            gencode_espacios();
            fichero.write("import java.io.*;\n");
            gencode_espacios();
            fichero.write("public class "+EntradaCompilador+"\n");
            gencode_espacios();
            fichero.write("{\n");
            espacios++;
        }catch(IOException e){}
    }
    //Generar código comienzo main
    private void gencode_begin_main(){
        try{
            gencode_espacios();
            fichero.write("public static void main(String[] args) {\n");
            espacios++;
        }catch(IOException e){}
    }
    //Generar código fin main
    private void gencode_end_main(){
        try{
            espacios--;
            gencode_espacios();
            fichero.write("}\n");
        }catch(IOException e){}
    }
    //Generar código fin clase
    private void gencode_end_class(){
        try{
            espacios--;
            gencode_espacios();
            fichero.write("}");
        }catch(IOException e){}
    }
    //Generar código declaración de variables
    private void gencode_declarar_variables_Integer(){
        try{
            Set<String> aux = almacen_definiciones_Integer.keySet();
            if (aux.size()>0){
                gencode_espacios();
                fichero.write("Integer ");
                Iterator<String> it = aux.iterator();
                while (it.hasNext()){
                    fichero.write(it.next());
                    if (it.hasNext())
                        fichero.write(",");
                }
                fichero.write(";\n");
            }
        }catch(IOException e){}
    }

    private void gencode_declarar_variables_Seq_Integer(){
        try{
            Set<String> aux = almacen_definiciones_Seq_Integer.keySet();
            if (aux.size()>0){
                gencode_espacios();
                fichero.write("Integer[] ");
                Iterator<String> it = aux.iterator();
                while (it.hasNext()){
                    fichero.write(it.next());
                    if (it.hasNext())
                        fichero.write(",");
                }
                fichero.write(";\n");
            }
        }catch(IOException e){}
    }

    private void gencode_declarar_variables_Bool(){
        try{
            Set<String> aux = almacen_definiciones_Bool.keySet();
            if (aux.size()>0){
                gencode_espacios();
                fichero.write("Boolean ");
                Iterator<String> it = aux.iterator();
                while (it.hasNext()){
                    fichero.write(it.next());
                    if (it.hasNext())
                        fichero.write(",");
                }
                fichero.write(";\n");
            }
        }catch(IOException e){}
    }

    private void gencode_declarar_variables_Seq_Bool(){
        try{
            Set<String> aux = almacen_definiciones_Seq_Bool.keySet();
            if (aux.size()>0){
                gencode_espacios();
                fichero.write("Boolean[] ");
                Iterator<String> it = aux.iterator();
                while (it.hasNext()){
                    fichero.write(it.next());
                    if (it.hasNext())
                        fichero.write(",");
                }
                fichero.write(";\n");
            }
        }catch(IOException e){}
    }

    //Generar código mostrar el valor de variable en una evaluación
    public void gencode_evaluar_variable(String var){
        try{
            gencode_espacios();
            fichero.write("System.out.println(\"(Compilador) "+
                    var+" ---> \""+"+"+var+");\n");
        }catch(IOException e){}
    }

    // Generar código condicional (Falta conseguir que las instrucciones se ejecuten dentro de las llaves)
    public void gencodigo_condicional(Anasint.Expr_boolContext expr, List<Anasint.Declaracion_instruccionesContext> ls){
        try{
            gencode_espacios();
            fichero.write("if("+generador.visit(expr)+"){");
            System.out.println(ls.get(0).getText());
            for(int i=0;i<ls.size();i++){
                if(ls.get(i).getText().startsWith("si ") || ls.get(i).getText().startsWith("si")){
                    Anasint.CondContext aux = (Anasint.CondContext) ls.get(i);
                    gencodigo_condicional(aux.condicion().expr_bool(),aux.condicion().declaracion_instrucciones());
                }
                if(ls.get(i).getText().startsWith("mientras ") || ls.get(i).getText().startsWith("mientras")){
                    Anasint.ItContext aux = (Anasint.ItContext) ls.get(i);
                    gencodigo_iteracion(aux.iteracion().expr_bool(),aux.iteracion().declaracion_instrucciones());
                }
                if(ls.get(i).getText().startsWith("mostrar ") || ls.get(i).getText().startsWith("mostrar")){
                    Anasint.ShowContext aux = (Anasint.ShowContext) ls.get(i);
                    gencodigo_mostrar(aux.mostrar().expr());
                }
                if(ls.get(i).getText().startsWith("ruptura ") || ls.get(i).getText().startsWith("ruptura")){
                //TODO
                }
                if(ls.get(i).getText().startsWith("dev ") || ls.get(i).getText().startsWith("dev")){
                    //TODO
                }
                if(ls.get(i).getText().startsWith("{ ") || ls.get(i).getText().startsWith("{")){
                    //TODO
                }
                // Falta diferenciar asignación de expresión función

            }
            fichero.write("}\n");
        }catch (IOException e){

        }
    }
    // Generar código iteración (ocurre lo mismo que en condicional)
    public void gencodigo_iteracion(Anasint.Expr_boolContext expr,List<Anasint.Declaracion_instruccionesContext> ls){
        try{
            Anasint.Declaracion_instruccionesContext aux;
            gencode_espacios();
            fichero.write("while("+generador.visit(expr)+"){");
            fichero.write("}\n");
        }catch (IOException e){

        }
    }

    private String convertir(String tipo,Anasint.Tipos_elementalesContext ctx){
        String resultado = new String();
        switch(tipo){
//            case ctx.BOOL().toString(): resultado=new String("boolean");
//                break;
        }
        return resultado;
    }

    //Generar codigo mostrar por pantalla
    Set<String>vars=new HashSet<String>();

    public  void gencodigo_mostrar(List<Anasint.ExprContext> exprs){
        String res = new String();
        for(int i=0;i< exprs.size();i++){
            gencode_espacios();
            res += "System.out.println(";
            res += generador.visit(exprs.get(i));
            res += ");\n";

        }
        try{
            fichero.write(res);
            gencode_espacios();
        }catch(IOException e){

        }
    }

    public void gencodigo_devolucion(List<Anasint.ExprContext> exprs){
        String res = "return ";
        for(int i=0;i< exprs.size();i++){
            res += generador.visit(exprs.get(i));
            if(i+1 != exprs.size()){
                res += ",";
            }else{
                res +=";";
            }
        }
        try{
            gencode_espacios();
            fichero.write(res);
            gencode_espacios();
        }catch(IOException e){

        }
    }

    public void gencodigo_break(){
        String res = "break;\n";
        try{
            fichero.write(res);
            gencode_espacios();
        }catch(IOException e){

        }
    }


    /////////////////////////
    // REGLAS. ATRIBUCIONES.
    /////////////////////////
    public void enterPrograma(Anasint.ProgramaContext ctx) {
        init("EntradaCompilador.java");
        open_file();
        gencode_begin_class();
        gencode_begin_main();
    }
    public void enterVariable(Anasint.VariableContext ctx) {
        //gencode_begin_main();
        gencode_evaluar_variable(ctx.VAR().getText());
    }

    public void exitVariables(Anasint.VariablesContext ctx){
        gencode_declarar_variables_Integer();
        gencode_declarar_variables_Bool();
        gencode_declarar_variables_Seq_Integer();
        gencode_declarar_variables_Seq_Bool();
    }



    public void enterElementales(Anasint.ElementalesContext ctx){
          if(ctx.tipos_elementales().getChild(0)==ctx.tipos_elementales().NUMERO()) {
              declarar_variable_Integer(ctx.VAR());
          }
        if(ctx.tipos_elementales().getChild(0)==ctx.tipos_elementales().BOOL()) {
            declarar_variable_Bool(ctx.VAR());
        }

    }

    public void enterSecuencias(Anasint.SecuenciasContext ctx){
        if(ctx.tipos_no_elementales().getChild(0)==ctx.tipos_no_elementales().SEQ_NUM()){
            declarar_variable_Seq_Integer(ctx.getChild(0).getText());
        }
        if(ctx.tipos_no_elementales().getChild(0)==ctx.tipos_no_elementales().SEQ_BOOL()){
            declarar_variable_Seq_Bool(ctx.getChild(0).getText());
        }
    }

    public void enterAsig(Anasint.AsigContext ctx){
        System.out.println(ctx.getParent().getText());
        if(ctx.getParent().getText().startsWith("INSTRUCCIONES")) {
            int suma = ctx.asignacion().variable().size() + ctx.asignacion().expr_sacar_elem().size();
            int pos = 0;
            for (int i = 0; i < (suma * 2 - 1); i = i + 2) { // Por las comas
                if (ctx.asignacion().getChild(i).getText().contains("[")) {
                    gencodigo_asignacion(ctx.asignacion().getChild(i), ctx.asignacion().expr(pos));
                    pos++;
                } else {
                    gencodigo_asignacion(ctx.asignacion().getChild(i), ctx.asignacion().expr(pos));
                    pos++;
                }
            }
        }
    }

    public void enterCond(Anasint.CondContext ctx){
        gencodigo_condicional(ctx.condicion().expr_bool(),ctx.condicion().declaracion_instrucciones());
    }

    public void enterIt(Anasint.ItContext ctx){
        gencodigo_iteracion(ctx.iteracion().expr_bool(),ctx.iteracion().declaracion_instrucciones());
    }

    public void enterDev(Anasint.DevContext ctx){
        gencodigo_devolucion(ctx.devolucion().expr());
    }

    public void enterMostrar(Anasint.MostrarContext ctx){
        gencodigo_mostrar(ctx.expr());
    }

    public void enterBreak(Anasint.BreakContext ctx){
        gencodigo_break();
    }

    public void enterInstrs(Anasint.Declaracion_instruccionesContext ctx) {
//        gencodigo_condicional(tipo, ctx);
//        gencodigo_iteracion
//        gencodigo_ruptura
//        gencodigo_declaracionSubprograma
//        gencodigo_retorno
//        gencodigo_mostrar(exprs);
//        gencodigo_aserto
    }
    public void exitPrograma(Anasint.ProgramaContext ctx) {
        gencode_end_main();
        gencode_end_class();
        close_file();
    }
}