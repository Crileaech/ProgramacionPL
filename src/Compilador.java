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
    FileWriter fichero; //Fichero para escribir el resultado de la compilación
    String SalidaCompilador = null; //Nombre del fichero compilador
    int espacios = 0; //Contador de espacios en blanco. Sirve para indentar el código generado.
    Map<String, Anasint.ExprContext> almacen_definiciones_Integer = new HashMap<>(); //almacen de las definiciones de variables
    Map<String, Anasint.ExprContext> almacen_definiciones_Bool = new HashMap<>();
    public static Map<String, Anasint.ExprContext> almacen_definiciones_Seq_Integer = new HashMap<>();
    public static Map<String, Anasint.ExprContext> almacen_definiciones_Seq_Bool = new HashMap<>();
    Map<String, Anasint.ExprContext> almacen_definiciones_Integer_Temporal = new HashMap<>();
    Map<String, Anasint.ExprContext> almacen_definiciones_Bool_Temporal = new HashMap<>();
    public static Map<String, Anasint.ExprContext> almacen_definiciones_Seq_Integer_Temporal = new HashMap<>();
    public static Map<String, Anasint.ExprContext> almacen_definiciones_Seq_Bool_Temporal = new HashMap<>();
    int aux_subprogramas=0; // para decidir si las variables se declaran en el programa principal o en un subprograma.
    int ruptura_condicional=0; // para decidir si hay una ruptura dentro de un condicional.
    int hayElse=0; // para decidir si hay else dentro de un if.
    String tipo; // tipo de la función.

    ///////////////////////////
    // METODOS GLOBALES
    //////////////////////////
    //Nombre del fichero sin la extensión
    public void init(String f){
        SalidaCompilador=f.substring(0,16); }
    //Abrir fichero
    private void open_file(){
        try{
            fichero = new FileWriter(SalidaCompilador+".java");
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
    public void declarar_variable_Integer_Temporal(List<TerminalNode> var) {
        String aux;
        for (TerminalNode nodo: var) {
            aux = nodo.getText();
            almacen_definiciones_Integer_Temporal.put(aux, null);
        }
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Bool_Temporal(List<TerminalNode> var) {
        String aux;
        for (TerminalNode nodo: var) {
            aux = nodo.getText();
            almacen_definiciones_Bool_Temporal.put(aux, null);
        }
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Integer(List<TerminalNode> var) {
        String aux;
        for (TerminalNode nodo: var) {
            aux = nodo.getText();
            almacen_definiciones_Integer.put(aux, null);
        }
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Seq_Integer(String var) {
        almacen_definiciones_Seq_Integer.put(var, null);
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Bool(List<TerminalNode> var) {
        String aux;
        for (TerminalNode nodo: var) {
            aux = nodo.getText();
            almacen_definiciones_Bool.put(aux, null);
        }
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Seq_Bool(String var) {
        almacen_definiciones_Seq_Bool.put(var, null);
    }
    //definición por defecto (null equivaldría a 0)

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
        String v;
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
            fichero.write("public class "+SalidaCompilador+"\n");
            gencode_espacios();
            fichero.write("{\n");
            espacios++;
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Generar código comienzo main
    private void gencode_begin_main(){
        try{
            gencode_espacios();
            fichero.write("public static void main(String[] args) {\n");
            espacios++;
        }catch(IOException e){System.out.println("Error: "+e.toString());}
    }
    //Generar código fin main
    private void gencode_end_main(){
        try{
            espacios--;
            gencode_espacios();
            fichero.write("}\n");
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Generar código fin clase
    private void gencode_end_class(){
        try{
            espacios--;
            gencode_espacios();
            fichero.write("}");
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Generar código declaración de variables Integer
    private void gencode_declarar_variables_Integer(){
        try{
            Set<String> aux = almacen_definiciones_Integer.keySet();
            if (aux.size()>0){
                gencode_espacios();
                fichero.write("static Integer ");
                Iterator<String> it = aux.iterator();
                while (it.hasNext()){
                    fichero.write(it.next());
                    if (it.hasNext())
                        fichero.write(",");
                }
                fichero.write(";\n");
            }
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Generar código declaración de variables de secuencia de Integer
    private void gencode_declarar_variables_Seq_Integer(){
        try{
            Set<String> aux = almacen_definiciones_Seq_Integer.keySet();
            if (aux.size()>0){
                gencode_espacios();
                fichero.write("static Integer[] ");
                Iterator<String> it = aux.iterator();
                while (it.hasNext()){
                    fichero.write(it.next());
                    if (it.hasNext())
                        fichero.write(",");
                }
                fichero.write(";\n");
            }
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Generar código declaración de variables Bool
    private void gencode_declarar_variables_Bool(){
        try{
            Set<String> aux = almacen_definiciones_Bool.keySet();
            if (aux.size()>0){
                gencode_espacios();
                fichero.write("static Boolean ");
                Iterator<String> it = aux.iterator();
                while (it.hasNext()){
                    fichero.write(it.next());
                    if (it.hasNext())
                        fichero.write(",");
                }
                fichero.write(";\n");
            }
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Generar código declaración de variables de tipo secuencia de Boolean
    private void gencode_declarar_variables_Seq_Bool(){
        try{
            Set<String> aux = almacen_definiciones_Seq_Bool.keySet();
            if (aux.size()>0){
                gencode_espacios();
                fichero.write("static Boolean[] ");
                Iterator<String> it = aux.iterator();
                while (it.hasNext()){
                    fichero.write(it.next());
                    if (it.hasNext())
                        fichero.write(",");
                }
                fichero.write(";\n");
            }
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Genera código declaración de variables de tipo Integer para subprogramas
    private void gencode_declarar_variables_Integer_Temporal(){
        try{
            Set<String> aux = almacen_definiciones_Integer_Temporal.keySet();
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
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Genera código declaración de variables de tipo secuencia de Integer para subprogramas
    private void gencode_declarar_variables_Seq_Integer_Temporal(){
        try{
            Set<String> aux = almacen_definiciones_Seq_Integer_Temporal.keySet();
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
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Genera código declaración de variables de tipo Boolean para subprogramas
    private void gencode_declarar_variables_Bool_Temporal(){
        try{
            Set<String> aux = almacen_definiciones_Bool_Temporal.keySet();
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
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }
    //Genera código declaración de variables de tipo secuencia de Boolean para subprogramas
    private void gencode_declarar_variables_Seq_Bool_Temporal(){
        try{
            Set<String> aux = almacen_definiciones_Seq_Bool_Temporal.keySet();
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
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }

    //Generar código mostrar el valor de variable en una evaluación
    public void gencode_evaluar_variable(String var){
        try{
            gencode_espacios();
            fichero.write("System.out.println(\"(Compilador) "+
                    var+" ---> \""+"+"+var+");\n");
        }catch(IOException e){
            System.out.println("Error: "+e.toString());
        }
    }

    // Generar código condicional
    public void gencodigo_condicional(Anasint.Expr_boolContext expr) {

        try {
            gencode_espacios();
            fichero.write("if(" + generador.visit(expr) + "){\n");
        } catch (IOException e) {
            System.out.println("Error: "+e.toString());
        }
    }
    //Genera código de los bloques else
        public void gencodigo_blq_sino(){
            try{
                hayElse++;
                gencode_espacios();
                fichero.write("}else{\n");
            }catch (IOException e){
                System.out.println("Error: "+e.toString());
            }


        }
        // Generar código iteración
        public void gencodigo_iteracion(Anasint.Expr_boolContext expr){
            try{
                gencode_espacios();
                fichero.write("while("+generador.visit(expr)+"){\n");
            }catch (IOException e){
                System.out.println("Error: "+e.toString());
            }
        }
        // Genera código funciones
        private void gencodigo_funcion(Anasint.FuncionContext ctx){
            tipo="";
            String aux = new String();
            int auxParams=0;
            String aux2 = ctx.getChild(3).getText();
            if(aux2.equals(")")){
            }else{
                String[] partes = aux2.split(",");
                for(int i=0; i< partes.length;i++){
                    if(partes[i].startsWith("NUM")){
                        aux +="Integer ";
                        aux += partes[i].substring(3,partes[i].length());
                    }
                    if(partes[i].startsWith("LOG")){
                        aux +="Boolean ";
                        aux += partes[i].substring(3,partes[i].length());
                    }
                    if(partes[i].startsWith("SEQ(NUM)")){
                        aux +="Integer[] ";
                        aux += partes[i].substring(8,partes[i].length());
                    }
                    if(partes[i].startsWith("SEQ(BOOL)")){
                        aux +="Boolean[] ";
                        aux += partes[i].substring(9,partes[i].length());
                    }
                    if((i+1)< partes.length){
                        aux += ",";
                    }
                }
            }
            System.out.println(ctx.params(0).getText());
            System.out.println(auxParams);
            String[] partes2 = ctx.params(1).getText().split(",");
            auxParams = partes2.length;
            if(auxParams<2) {
                if (ctx.params(1).getText().startsWith("NUM")) {
                    tipo = "Integer ";
                }
                if (ctx.params(1).getText().startsWith("LOG")) {
                    tipo = "Boolean ";
                }
                if (ctx.params(1).getText().startsWith("SEQ(NUM)")) {
                    tipo = "Integer[]";
                }
                if (ctx.params(1).getText().startsWith("SEQ(BOOL)")) {
                    tipo = "Boolean[]";
                }
            }
            else if(ctx.params(1).getText().startsWith("NUM")){
                tipo = "Integer[] ";
            }else if(ctx.params(1).getText().startsWith("LOG")){
                tipo = "Boolean[] ";
            }
            try{
                fichero.write("public static "+tipo+ ctx.variable().VAR().getText()+"("+aux+"){\n");
            }catch (IOException e){
                System.out.println("Error: "+e.toString());
            }
        }

    // Genera código procedimientos
        private void gencodigo_procedimientos(Anasint.ProcedimientoContext ctx){

            String aux = "";
            String aux2 = ctx.getChild(3).getText();
            System.out.println(ctx.getChild(3).getText());
            if(!aux2.equals(")")){
                String[] partes = aux2.split(",");
                for(int i=0; i< partes.length;i++){
                    if(partes[i].startsWith("NUM")){
                        aux +="Integer ";
                        aux += partes[i].substring(3);
                    }
                    if(partes[i].startsWith("LOG")){
                        aux +="Boolean ";
                        aux += partes[i].substring(3);
                    }
                    if(partes[i].startsWith("SEQ(NUM)")){
                        aux +="Integer[] ";
                        aux += partes[i].substring(8);
                    }
                    if(partes[i].startsWith("SEQ(BOOL)")){
                        aux +="Boolean[] ";
                        aux += partes[i].substring(9);
                    }

                    if((i+1)< partes.length){
                        aux += ",";
                    }
                }
            }
            try{
                fichero.write("public static void "+ctx.variable().VAR().getText()+"("+aux+"){\n");
            }catch (IOException e){
                System.out.println("Error: "+e.toString());
            }

        }

        //Generar codigo mostrar por pantalla

        private  void gencodigo_mostrar(List<Anasint.ExprContext> exprs){
            String res = "";
            for(Anasint.ExprContext expr: exprs){
                gencode_espacios();
                res += "System.out.println(";
                res += generador.visit(expr);
                res += ");\n";

            }
            try{
                fichero.write(res);
                gencode_espacios();
            }catch(IOException e){
                System.out.println("Error: "+e.toString());
            }
        }
        // Genera código return
        private void gencodigo_devolucion(List<Anasint.ExprContext> exprs){
            String res = "return ";
            String res2 = "";
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
                if(res.contains(",")){
                    String[] partes = res.split(",");
                    partes[0] = partes[0].substring(7,partes[0].length());
                    partes[partes.length-1]= partes[partes.length-1].substring(0,partes[partes.length-1].length()-1);
                    res2 = tipo+" res_compilador= new "+tipo+"{"+partes[0];
                    for(int i=1;i< partes.length;i++){
                        if(i+1<= partes.length){
                            res2 += ","+partes[i]+"};\n";
                        }else{
                            res2 += ","+partes[i];
                        }
                    }
                    res2 += "return res_compilador;\n";
                    gencode_espacios();
                    fichero.write(res2);
                    gencode_espacios();

                }else{
                    fichero.write(res);
                }
                gencode_espacios();
            }catch(IOException e){
                System.out.println("Error: "+e.toString());
            }
        }
        // Genera código de ruptura
        private void gencodigo_break(Anasint.BreakContext ctx) {
            System.out.println(ctx.getParent().getText());
            if (ctx.getParent().getText().startsWith("mientras")) {
                try {
                    fichero.write("break;\n");
                } catch (IOException e) {
                    System.out.println("Error: "+e.toString());
                }
            }
            if (ctx.getParent().getText().startsWith("si")) {
                ruptura_condicional++;
            }
            if (ctx.getParent().getText().startsWith("INSTRUCCIONES")) {
                try {
                    fichero.write("System.exit(0);\n");
                } catch (IOException e) {
                    System.out.println("Error: "+e.toString());
                }
            }


        }

        private void gencodigo_asertos(Anasint.AsertosContext ctx){

        }


        /////////////////////////
        // REGLAS. ATRIBUCIONES.
        /////////////////////////
        public void enterPrograma(Anasint.ProgramaContext ctx) {
            init("SalidaCompilador.java");
            open_file();
            gencode_begin_class();

        }
        public void enterVariable(Anasint.VariableContext ctx) {
            //gencode_evaluar_variable(ctx.VAR().getText());
        }

        public void exitSubprogramas(Anasint.SubprogramasContext ctx){
            gencode_begin_main();
        }

        public void exitDeclaracion_subprogramas(Anasint.Declaracion_subprogramasContext ctx){
            try{
                fichero.write("}\n");
            }catch (IOException e){
                System.out.println("Error: "+e.toString());
            }
            almacen_definiciones_Integer_Temporal.clear();
            almacen_definiciones_Bool_Temporal.clear();
            almacen_definiciones_Seq_Integer_Temporal.clear();
            almacen_definiciones_Seq_Bool_Temporal.clear();
        }

        public void exitVariables(Anasint.VariablesContext ctx){
            if(ctx.getParent().getText().startsWith("FUNCION") || ctx.getParent().getText().startsWith("PROCEDIMIENTO")){
                gencode_declarar_variables_Integer_Temporal();
                gencode_declarar_variables_Bool_Temporal();
                gencode_declarar_variables_Seq_Integer_Temporal();
                gencode_declarar_variables_Seq_Bool_Temporal();
            }else {
                gencode_declarar_variables_Integer();
                gencode_declarar_variables_Bool();
                gencode_declarar_variables_Seq_Integer();
                gencode_declarar_variables_Seq_Bool();
            }
        }



        public void enterElementales(Anasint.ElementalesContext ctx){

            if(aux_subprogramas > 0){
                if (ctx.tipos_elementales().getChild(0) == ctx.tipos_elementales().NUMERO()) {
                    declarar_variable_Integer_Temporal(ctx.VAR());
                }
                if (ctx.tipos_elementales().getChild(0) == ctx.tipos_elementales().BOOL()) {
                    declarar_variable_Bool_Temporal(ctx.VAR());
                }
            }else {
                if (ctx.tipos_elementales().getChild(0) == ctx.tipos_elementales().NUMERO()) {
                    declarar_variable_Integer(ctx.VAR());
                }
                if (ctx.tipos_elementales().getChild(0) == ctx.tipos_elementales().BOOL()) {
                    declarar_variable_Bool(ctx.VAR());
                }
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
            if(ruptura_condicional==0){
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
            if(ruptura_condicional==0){
                gencodigo_condicional(ctx.condicion().expr_bool());
            }
        }

        public void exitCondicion(Anasint.CondicionContext ctx){
            if(ruptura_condicional==0 || ruptura_condicional==1){
                try{
                    if(hayElse==0) {
                        ruptura_condicional = 0;
                        fichero.write("}\n");
                    }else{
                        ruptura_condicional = 0;
                        hayElse=0;
                    }
                }catch (IOException e){
                    System.out.println("Error: "+e.toString());
                }
            }else{
                ruptura_condicional = 0;
            }
        }

        public void enterBlq_sino(Anasint.Blq_sinoContext ctx){
            if(ruptura_condicional==0){
                gencodigo_blq_sino();
            }
        }

        public void exitBlq_sino(Anasint.Blq_sinoContext ctx){
            try{
                if(ruptura_condicional==0) {
                    fichero.write("}\n");
                }
            }catch (IOException e){
                System.out.println("Error: "+e.toString());
            }
        }

        public void enterIt(Anasint.ItContext ctx){
            if(ruptura_condicional==0){
                gencodigo_iteracion(ctx.iteracion().expr_bool());
            }
        }

        public void exitIteracion(Anasint.IteracionContext ctx){
            try {
                if (ruptura_condicional==0){
                    fichero.write("}\n");
                }
            }catch (IOException e){
                System.out.println("Error: "+e.toString());
            }
        }

        public void enterDev(Anasint.DevContext ctx){
            gencodigo_devolucion(ctx.devolucion().expr());

        }

        public void enterMostrar(Anasint.MostrarContext ctx){
            if(ruptura_condicional==0){
                gencodigo_mostrar(ctx.expr());
            }
        }

        public void enterBreak(Anasint.BreakContext ctx){
            if(ruptura_condicional==0){
                gencodigo_break(ctx);
            }
        }

        public void enterFuncion(Anasint.FuncionContext ctx){
            aux_subprogramas++;
            gencodigo_funcion(ctx);

        }

        public void enterProcedimiento(Anasint.ProcedimientoContext ctx){
            aux_subprogramas++;
            gencodigo_procedimientos(ctx);
        }

        public void enterAsertos(Anasint.AsertosContext ctx){
            gencodigo_asertos(ctx);
        }

        public void exitAsig(Anasint.AsigContext ctx){
            if(ruptura_condicional==0){
                int suma = ctx.asignacion().variable().size() + ctx.asignacion().expr_sacar_elem().size();
                for (int i = 0; i < (suma * 2 - 1); i = i + 2) { // Por las comas
                    gencode_evaluar_variable(ctx.asignacion().getChild(i).getText());
                }
            }

        }
        public void exitPrograma(Anasint.ProgramaContext ctx) {
            gencode_end_main();
            try{
                fichero.write("public static Integer ultima_posicion(Integer[] s){"+
                    "return s.length-1;"+
                "}\n"+
                "public static Integer ultima_posicion(Boolean[] s){"+
                    "return s.length-1;"
                +"}\n");
            }catch (IOException e){
                System.out.println("Error: "+e.toString());
            }
            gencode_end_class();
            close_file();
        }
    }