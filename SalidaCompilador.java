import java.io.*;
public class SalidaCompilador
{
 static Integer a,b,min,max,i;
 static Boolean b2;
 static Integer[] s;
 static Boolean[] s2;
public static Integer bucle_1_avance(Integer[] s,Integer i){
 i=ultima_posicion(s)-i;
 System.out.println("(Compilador) i ---> "+i);
 return i; }
public static Integer[] prueba(Integer j){
 Integer min,max,i,k;
 Integer[] s;
 s=new Integer[]{3,4,2,7,9,0,11};
 System.out.println("(Compilador) s ---> "+s);
 min=0;
 System.out.println("(Compilador) min ---> "+min);
 max=12;
 System.out.println("(Compilador) max ---> "+max);
 i=123123;
 System.out.println("(Compilador) i ---> "+i);
 k=j+1;
 System.out.println("(Compilador) k ---> "+k);
 System.out.println(5);
   Integer[]  res_compilador= new Integer[] {i,k};
return res_compilador;
  }
public static void sustituir(Integer anterior,Integer aaaaaa,Integer nuevo){
 anterior=nuevo;
 System.out.println("(Compilador) anterior ---> "+anterior);
}
 public static void main(String[] args) {
  i=0;
  System.out.println("(Compilador) i ---> "+i);
  s=new Integer[]{3,4,2,7,9,0,11};
  System.out.println("(Compilador) s ---> "+s);
  while(i<=ultima_posicion(s)){
  System.out.println(i);
    i=i+1;
  System.out.println("(Compilador) i ---> "+i);
}
  s2=null;
  System.out.println("(Compilador) s2 ---> "+s2);
  min=2;
  System.out.println("(Compilador) min ---> "+min);
  min=prueba(6)[0]; 
  max=prueba(6)[1]; 
  System.out.println("(Compilador) min ---> "+min);
  System.out.println("(Compilador) max ---> "+max);
  a=prueba(2)[0]; 
  b=prueba(2)[1]; 
  System.out.println("(Compilador) a ---> "+a);
  System.out.println("(Compilador) b ---> "+b);
  min=null;
  System.out.println("(Compilador) min ---> "+min);
  i=7;
  System.out.println("(Compilador) i ---> "+i);
 }
public static Integer ultima_posicion(Integer[] s){return s.length-1;}
public static Integer ultima_posicion(Boolean[] s){return s.length-1;}
}