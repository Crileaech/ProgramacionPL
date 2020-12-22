import java.io.*;
public class EntradaCompilador
{
    public static void main(String[] args) {

//        VARIABLES
//            x:NUM;
//        INSTRUCCIONES
//            {ERROR DE COMPILACION DECLARACION DE INSTRUCCION}
//            x=x+1 //error x+1 no tiene valor porque x no tiene valor

//        {Error de Compilacion si no llamamos a declaracion de instrucciones ruptura bucle infinito}
//        i=0;
//        mientras (i<=9) hacer
//                x=3;
//        ruptura;
//        i=i+1;
//        fmientras
        Integer x = 0;
        //0: estado=(x)
        x= x+1;

        System.out.println("(Compilador) x ---> "+x);

//        //1: estado=(x,0),(y,0),(z,0),(a,0),(b,0)
//        a=2;
//        b=a+1;
//        System.out.println("(Compilador) b ---> "+b);
//        //2: estado=(x,0),(y,0),(z,0),(a,0),(b,3)
//        y=0;
//        z=2*y;
//        System.out.println("(Compilador) z ---> "+z);
//        //3: estado=(x,0),(y,0),(z,0),(a,0),(b,3)
//        b = null;
//        System.out.println("(Compilador) b ---> "+b);
//        //4: estado=(x,0),(y,0),(z,0),(a,0),(b,INDEF)
    }
}
