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
    FileWriter fichero; //Fichero para escribir el resultado de la compilación
    String EntradaCompilador = null; //Nombre del fichero compilador
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
    String tipo = new String(); // tipo de la función.

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
    public void declarar_variable_Integer_Temporal(List<TerminalNode> var) {
        String aux = new String();
        for (int i = 0; i < var.size(); i++) {
            aux = var.get(i).getText();
            almacen_definiciones_Integer_Temporal.put(aux, null);
        }
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Seq_Integer_Temporal(String var) {
        almacen_definiciones_Seq_Integer_Temporal.put(var, null);
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Bool_Temporal(List<TerminalNode> var) {
        String aux = new String();
        for (int i = 0; i < var.size(); i++) {
            aux = var.get(i).getText();
            almacen_definiciones_Bool_Temporal.put(aux, null);
        }
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Seq_Bool_Temporal(String var) {
        almacen_definiciones_Seq_Bool_Temporal.put(var, null);
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Integer(List<TerminalNode> var) {
        String aux = new String();
        for (int i = 0; i < var.size(); i++) {
            aux = var.get(i).getText();
            almacen_definiciones_Integer.put(aux, null);
        }
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Seq_Integer(String var) {
        almacen_definiciones_Seq_Integer.put(var, null);
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Bool(List<TerminalNode> var) {
        String aux = new String();
        for (int i = 0; i < var.size(); i++) {
            aux = var.get(i).getText();
            almacen_definiciones_Bool.put(aux, null);
        }
    }
    //Declarar variable con definición por defecto
    public void declarar_variable_Seq_Bool(String var) {
        almacen_definiciones_Seq_Bool.put(var, null);
    }
    //definición por defecto (null equivaldría a 0)

    //Actualizar la definición de una variable
    public void definir_variable_Integer(String var, Anasint.ExprContext expr){
        almacen_definiciones_Integer.put(var,expr);
    }
    //Actualizar la definición de una variable
    public void definir_variable_Seq_Integer(String var, Anasint.ExprContext expr){
        almacen_definiciones_Seq_Integer.put(var,expr);
    }
    //Actualizar la definición de una variable
    public void definir_variable_Bool(String var, Anasint.ExprContext expr){
        almacen_definiciones_Bool.put(var,expr);
    }
    //Actualizar la definición de una variable
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
        }catch(IOException e){}
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
        }catch(IOException e){}
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
        }catch(IOException e){}
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
        }catch(IOException e){}
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
        }catch(IOException e){}
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
        }catch(IOException e){}
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
        }catch(IOException e){}
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

    // Generar código condicional
    public void gencodigo_condicional(Anasint.Expr_boolContext expr, List<Anasint.Declaracion_instruccionesContext> ls) {

        try {
            gencode_espacios();
            fichero.write("if(" + generador.visit(expr) + "){\n");
        } catch (IOException e) {
        }
    }
    //Genera código de los bloques else
    public void gencodigo_blq_sino(List<Anasint.Declaracion_instruccionesContext> ls){
        try{
            hayElse++;
            gencode_espacios();
            fichero.write("}else{\n");
        }catch (IOException e){

        }


    }
    // Generar código iteración
    public void gencodigo_iteracion(Anasint.Expr_boolContext expr,List<Anasint.Declaracion_instruccionesContext> ls){
        try{
            gencode_espacios();
            fichero.write("while("+generador.visit(expr)+"){\n");
        }catch (IOException e){

        }
    }
    // Genera código funciones
    private void gencodigo_funcion(Anasint.FuncionContext ctx){
        tipo="";
        String aux = new String();

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
        if(ctx.params().size()<2){
            if(ctx.params(0).getText().startsWith("NUM")){
                tipo ="Integer ";
            }
            if(ctx.params(0).getText().startsWith("LOG")){
                tipo = "Boolean ";
            }
            if(ctx.params(0).getText().startsWith("SEQ(NUM)")){
                tipo = "Integer[]";
            }
            if(ctx.params(0).getText().startsWith("SEQ(BOOL)")){
                tipo = "Boolean[]";
            }
        }else if(ctx.params(0).getText().startsWith("NUM")){
            tipo = "Integer[] ";
        }else if(ctx.params(0).getText().startsWith("LOG")){
            tipo = "Boolean[] ";
        }

        try{
            fichero.write("public static "+tipo+ ctx.variable().VAR().getText()+"("+aux+"){\n");
        }catch (IOException e){

        }

    }
    // Genera código procedimientos
    private void gencodigo_procedimientos(Anasint.ProcedimientoContext ctx){

        String aux = new String();
        String aux2 = ctx.getChild(3).getText();
        System.out.println(ctx.getChild(3).getText());
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
        try{
            fichero.write("public static void "+ctx.variable().VAR().getText()+"("+aux+"){\n");
        }catch (IOException e){

        }

    }

    //Generar codigo mostrar por pantalla

    private  void gencodigo_mostrar(List<Anasint.ExprContext> exprs){
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
    // Genera código return
    private void gencodigo_devolucion(List<Anasint.ExprContext> exprs){
        String res = "return ";
        String res2 = new String();
        for(int i=0;i< exprs.size();i++){
            res += generador.visit(exprs.get(i));
            if(i+1 != exprs.size()){
                res += ",";
            }else{
                res +=";";
            }
        }
        try{
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

            }else {
                gencode_espacios();
                fichero.write(res);
                gencode_espacios();
            }
        }catch(IOException e){

        }
    }
    // Genera código de ruptura
    private void gencodigo_break(Anasint.BreakContext ctx){
        System.out.println(ctx.getParent().getText());
        if(ctx.getParent().getText().startsWith("mientras")){
            try{
                fichero.write("break;\n");
            }catch (IOException e){

            }
        }
        if(ctx.getParent().getText().startsWith("si")){
            ruptura_condicional++;
        }
        if(ctx.getParent().getText().startsWith("INSTRUCCIONES")){
            try{
                fichero.write("System.exit(0);\n");
            }catch (IOException e){

            }
        }


    }

    //Generar codigo asertos
    // 1 -> Si sus asertos son ciertos entonces el programa se considera correcto
    // 2 -> Un programa es incorrecto si alguno de sus asertos es falso en alguna de sus ejecuciones.
    // 3 -> Asertos son condiciones extendidas con dos tipos de posibles cuantificaciones:
    // 3.1 -> Cuantificación universal, ej. PARATODO(p:[0,ultima_posicion(s)],s[i]<=max)
    // 3.2 -> Cuantificación existencial ej. EXISTE(x:[0,ultima_posicion(s)],s[x]>10)
    private void gencodigo_asertos(Anasint.AsertoContext ctx){
        if(ctx.asertos().expr_bool() != null) { //En este caso {cierto} {falso} o equivalente.
            Boolean expr_booleana = Boolean.valueOf(generador.visit(ctx.asertos().expr_bool()));
            if(expr_booleana){
                System.out.println("(aserto) Si sus asertos son ciertos entonces el programa se considera correcto");
            } else {
                System.out.println("(aserto) Un programa es incorrecto si alguno de sus " +
                        "asertos es falso en alguna de sus ejecuciones.");
            }
        } else { //En este caso llamada a cuantificadores.
            Boolean expr_booleana = Boolean.valueOf(generador.visitAserto(ctx));
            if(expr_booleana && ctx.getText().startsWith("{PARATODO ( "+ctx) && ctx.getText().endsWith(")}") ) {
                System.out.println("(aserto) Si todos sus asertos son ciertos entonces el programa se considera correcto");
                this.gencodigo_aserto_universal(ctx.asertos());
            } else if(ctx.getText().startsWith("{EXISTE ( "+ctx) && ctx.getText().endsWith(")}")){
                System.out.println("(aserto) Un programa es correcto si alguno de sus " +
                        "asertos es cierto en alguna de sus ejecuciones.");
                this.gencodigo_aserto_existencial(ctx.asertos());

            }


        }
        try{
            gencode_espacios();
            String res = ctx.asertos().getText();
            fichero.write("System.out.println("+res+");\n");
            gencode_espacios();
        } catch (IOException e){}
    }

    //Generar codigo asertos 3.1 -> Cuantificación universal, ej. PARATODO(p:[0,ultima_posicion(s)],s[i]<=max)
    private Boolean gencodigo_aserto_universal(Anasint.AsertosContext ctx) {
        Map<String,Object> asig = new LinkedHashMap<>();
        Anasint.CuantificacionContext cuantificacionContext =
                ctx.cuantificador().cuantificadorUniversal().cuantificacion();
        String vars = cuantificacionContext.variable().getText();
        int ini = Integer.parseInt(generador.visit(cuantificacionContext.expr_integer(0)));
        int fin = Integer.parseInt(generador.visit(cuantificacionContext.expr_integer(1)));
        if(ini > fin) {
            return null;
        }
        asig.put(vars, ini);
        // TODO : Finalizar asertos universal
        boolean res = Boolean.parseBoolean(generador.visit(cuantificacionContext.expr_bool()));
        while(res && (Integer)asig.get(vars)<=fin) {
            res = res && Boolean.parseBoolean(generador.visit(cuantificacionContext.expr_bool()));
            asig.put(vars,(Integer)asig.get(vars)+1);
        }
        return res;

    }

    //Generar codigo asertos 3.2 -> Cuantificación existencial ej. EXISTE(x:[0,ultima_posicion(s)],s[x]>10)
    private Boolean gencodigo_aserto_existencial(Anasint.AsertosContext ctx) {
        Map<String,Object> asig = new LinkedHashMap<>();

        Anasint.CuantificacionContext cuantificacionExistencialContext = ctx.cuantificador()
                .cuantificadorExistencial().cuantificacion();
        String var = cuantificacionExistencialContext.variable().getText();

        int ini = Integer.parseInt(generador.visit(cuantificacionExistencialContext.expr_integer(0)));
        int fin = Integer.parseInt(generador.visit(cuantificacionExistencialContext.expr_integer(1)));

        if(ini > fin ) {return null;}
        asig.put(var,ini);
        while((Integer)asig.get(var)<=fin) {
            boolean res = Boolean.parseBoolean(generador.visit(cuantificacionExistencialContext.expr_bool()));
            if(res) { return true; }
            asig.put(var,(Integer)asig.get(var)+1);
        }
        return false;

    }


    /////////////////////////
    // REGLAS. ATRIBUCIONES.
    /////////////////////////
    public void enterPrograma(Anasint.ProgramaContext ctx) {
        init("EntradaCompilador.java");
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
            gencodigo_condicional(ctx.condicion().expr_bool(), ctx.condicion().declaracion_instrucciones());
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

            }
        }else{
            ruptura_condicional = 0;
        }
    }

    public void enterBlq_sino(Anasint.Blq_sinoContext ctx){
        if(ruptura_condicional==0){
            gencodigo_blq_sino(ctx.declaracion_instrucciones());
        }
    }

    public void exitBlq_sino(Anasint.Blq_sinoContext ctx){
        try{
            if(ruptura_condicional==0) {
                fichero.write("}\n");
            }
        }catch (IOException e){

        }
    }

    public void enterIt(Anasint.ItContext ctx){
        if(ruptura_condicional==0){
            gencodigo_iteracion(ctx.iteracion().expr_bool(), ctx.iteracion().declaracion_instrucciones());
        }
    }

    public void exitIteracion(Anasint.IteracionContext ctx){
        try {
            if (ruptura_condicional==0){
                fichero.write("}\n");
            }
        }catch (IOException e){

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

    public void enterAsertos(Anasint.AsertoContext ctx){
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

    public void exitDeclaracion_Instrucciones(Anasint.Declaracion_instruccionesContext ctx) {

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

        }
        gencode_end_class();
        close_file();
    }
}