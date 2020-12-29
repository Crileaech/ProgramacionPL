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

    String EntradaCompilador = new String(); //Nombre del fichero compilador
    int espacios = 0; //Contador de espacios en blanco. Sirve para indentarel código generado.
    Map<String, Anasint.ExprContext> almacen_definiciones = new HashMap<>(); //almacen de las definiciones de variables

    ///////////////////////////
    // METODOS GLOBALES
    //////////////////////////
    //Nombre del fichero sin la extensión
    public void init(String f){
        this.EntradaCompilador= f.substring(0, f.length() - 4); }
    //Abrir fichero
    private void open_file(){
        try{
            fichero = new FileWriter("src/"+this.EntradaCompilador+".java");
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
    //Calcular dependencias de variables por niveles
    //Necesario para generar código de la evaluación de una variable definida.

    //nivel representa el conjunto de variables al que se le calcula las dependencias
            // r representa las dependencias organizadas por niveles,
            // p.e. r=[[b], [a], [x, y]] representa b depende de a y a depende de x e  y
    public void calcular_dependencias_por_niveles(Set<String> nivel, List<Set<String>> r){
        ExtraerVarsExpr extractor = new ExtraerVarsExpr();
        if (!nivel.isEmpty()){
            Set<String>nivel_sig=new HashSet<String>();
            //nivel_sig representa las variables de las que dependen directamente las variables de nivel
            for(String v:nivel){
                Anasint.ExprContext def =
                        almacen_definiciones.get(v);
                Set<String>aux=new HashSet<>();
                if (def!=null)
                    aux=extractor.visit(def);
                nivel_sig.addAll(aux);
            }
            if (!nivel_sig.isEmpty()) r.add(nivel_sig); //actualización  de niveles de dependencia con nuevo nivel
            calcular_dependencias_por_niveles(nivel_sig,r);
        }
    }
    //Generar código para v = exp
    public void gencodigo_asignacion(String v, Anasint.ExprContext exp){
        String txt_exp="0";
        if (exp!=null)
            txt_exp = generador.visit(exp);
        gencode_espacios();
        try{
            fichero.write(v+"="+txt_exp+";\n"); //código de una asignación
        }catch(IOException e){}
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
    // Test de evaluaciones indefinidas.
    boolean test(String v){
        Anasint.ExprContext d = almacen_definiciones.get(v);
        Set<String> S = extractor.visit(d);
        if (S.isEmpty()) return false;
        else {
            List<String>aux=new LinkedList<String>();
            aux.add(v);
            return ciclo(aux,S);
        }
    }
    //Comprobar si algún elemento en S está en V
    boolean contiene_algun_elemento(List<String> V,Set<String> S){
        return S.stream().anyMatch((e)->V.contains(e));
    }
    //Testar ciclicidad en la definición de una variable v
    //V representa una secuencia de dependencias entre variables
    //S representa un conjunto de variables
    //Hay que comprobar si al anadir alguna variable de S en V se alcanza un ciclo
    boolean ciclo(List<String> V,Set<String> S){
        if (contiene_algun_elemento(V,S))
            return true;
        else
            for (String z:S){
                Anasint.ExprContext d = almacen_definiciones.get(z);
                Set<String> K = new HashSet<String>();
                if (d!=null) K=extractor.visit(d);
                List<String> aux = new LinkedList<String>();
                aux.addAll(V);aux.add(z);
                if (ciclo(aux,K)) return true;
            }
        return false;
    }
    /////////////////////////
    // REGLAS. ATRIBUCIONES.
    /////////////////////////
    public void enterProg(Anasint.ProgramaContext ctx) { open_file();
        gencode_begin_class(); }
    public void enterVars(Anasint.VariableContext ctx) { gencode_begin_main(); }
    public void enterInstrs(Anasint.InstruccionesContext ctx) {
        gencode_declarar_variables(); }
    public void exitProg(Anasint.ProgramaContext ctx) { gencode_end_main();
        gencode_end_class(); close_file(); }
}


