import org.antlr.runtime.RecognitionException;

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
    int espacios = 0; //Contador de espacios en blanco. Sirve para indentarel código generado.
    Map<String, Anasint.ExprContext> almacen_definiciones = new HashMap<>(); //almacen de las definiciones de variables

    ///////////////////////////
    // METODOS GLOBALES
    //////////////////////////
    //Nombre del fichero sin la extensión
    public void init(String f){
        EntradaCompilador=new String(f.substring(0,f.length()-4)); }
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
    public void declarar_variable(String var){
        almacen_definiciones.put(var,null); //definición por defecto (null equivaldría a 0)
    }
    //Actualizar la definición de una variable
    public void definir_variable(String var, Anasint.ExprContext expr){
        almacen_definiciones.put(var,expr);
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
    public void gencodigo_asignacion(String v, Anasint.ExprContext exp){
        String txt_exp="0";
        if (exp!=null)
            txt_exp = generador.visit(exp);
            gencode_espacios();
        try{
            fichero.write(v+"="+txt_exp+";\n"); //código de una asignación
        }catch(IOException e){e.getMessage();}
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
    private void gencode_declarar_variables(){
        try{
            Set<String> aux = almacen_definiciones.keySet();
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
    //Generar código mostrar el valor de variable en una evaluación
    public void gencode_evaluar_variable(String var){
        try{
            gencode_espacios();
            fichero.write("System.out.println(\"(Compilador) "+
                    var+" ---> \""+"+"+var+");\n");
        }catch(IOException e){}
    }

    // Generar código condicional
    public void gencodigo_condicional(String tipo, Anasint.Tipos_elementalesContext ctx){
        if (tipo!=ctx.BOOL().getText())
            System.out.println("Condicion mal tipada: "+" "+convertir(tipo,ctx));
    }
    private String convertir(String tipo,Anasint.Tipos_elementalesContext ctx){
        String resultado = new String();
        switch(tipo){
            case ctx.BOOL().toString(): resultado=new String("boolean");
                break;
        }
        return resultado;
    }
    
    //Generar codigo mostrar por pantalla
    Set<String>vars=new HashSet<String>();

   public  void gencodigo_mostrar(Anasint.ExprContext exprs){
        Anasint.ExprContext expr = exprs;
        String s = new String(" System.out.println()");
        while (expr!=null){
           if (!vars.contains(expr.getText()))
                 s+="\"indefinido\"";
           else
                    s+=expr.getText();
        }
        s+=");\n";
        gencode_espacios();
    }



    /////////////////////////
    // REGLAS. ATRIBUCIONES.
    /////////////////////////
    public void enterPrograma(Anasint.ProgramaContext ctx) {
        init("EntradaCompilador.java");
        open_file();
        gencode_begin_class(); }
    public void enterVariable(Anasint.VariableContext ctx) {
        gencode_begin_main();
        gencode_declarar_variables();
        gencode_evaluar_variable("VAR");
    }
    public void enterInstrs(Anasint.Declaracion_instruccionesContext ctx) {
//        gencodigo_asignacion(v.getText(),exp);
//        gencodigo_condicional(tipo, ctx);
//        gencodigo_iteracion
//        gencodigo_ruptura
//        gencodigo_declaracionSubprograma
//        gencodigo_retorno
//        gencodigo_mostrar(exprs)
//        gencodigo_aserto
    }
    public void exitPrograma(Anasint.ProgramaContext ctx) {
        gencode_end_main();
        gencode_end_class();
        close_file();
    }
}


