import java.io.*;
public class EntradaCompilador
{
 static Integer i,j;
 static Boolean l;
 static Integer[] s;
 public static void main(String[] args) {
  i=1;
  System.out.println("(Compilador) i ---> "+i);
  j=4;
  System.out.println("(Compilador) j ---> "+j);
  s=new Integer[]{14,25,65,10};
  System.out.println("(Compilador) s ---> "+s);
  if(s[i]>15){
  System.out.println(s[i]);
    System.out.println("(Compilador) i ---> "+i);
}
 }
}