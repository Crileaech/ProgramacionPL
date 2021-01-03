import java.io.*;
public class EntradaCompilador
{
 static Integer max,i,j;
 static Integer[] s;
 public static void main(String[] args) {
  s=new Integer[]{3,4,2,7,9,0,11};
  i=0;
  System.out.println("(Compilador) s ---> "+s);
  System.out.println("(Compilador) i ---> "+i);
  s[i]=10;
  max=s[i];
  System.out.println("(Compilador) s[i] ---> "+s[i]);
  System.out.println("(Compilador) max ---> "+max);
  while(i<=ultima_posicion(s)){
  if(max<s[i]&&i!=10){
  max=s[i];
  System.out.println("(Compilador) max ---> "+max);
  }else{
  if(max==10){
}
}
  i=i+1;
  System.out.println("(Compilador) i ---> "+i);
}
  System.out.println(max);
   }
public static Integer ultima_posicion(Integer[] s){return s.length-1;}
public static Integer ultima_posicion(Boolean[] s){return s.length-1;}
}