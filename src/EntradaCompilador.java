public class EntradaCompilador
{
    public static Integer main(String[] args) {

//        PROGRAMA
//
//                VARIABLES
//        i,j,max,min:NUM;
//        s:SEQ(NUM);
//
        Integer i,j,max,min, pos, r = 0;

//        SUBPROGRAMAS
//        FUNCION bucle_1_avance(SEQ(NUM) seq, NUM pos) dev (NUM r)
//        VARIABLES
//                INSTRUCCIONES
//        r=ultima_posicion(s,1)-i;
//        dev r;
//        FFUNCION
//
//        FUNCION f(NUM pos) dev (NUM r)
//        VARIABLES
//                INSTRUCCIONES
//        si (pos>0) entonces
        if(pos>0){
            if(pos<5){
                r = 1;
            } else {
                r = 2;
            }
        }
        return r;
//        si (pos<5) entonces
//                r=1;
//        dev r;
//        sino
//                r=2;
//        fsi
//                fsi
//        FFUNCION
//
//                INSTRUCCIONES
        Boolean asertos = true;
//        { T }
        Integer[] secuenciaInteger = new Integer[] {3,4,2,7,9,0,11};
        secuenciaInteger[0] = 3;
        secuenciaInteger[1] = 4;
        Boolean [] secuenciaBoolean = new Boolean[]{Boolean.TRUE, Boolean.FALSE};
        Boolean [] b =new Boolean[]{true, false};

        i=0+j;
        min=secuenciaInteger[i];
        max=secuenciaInteger[i];
        Integer[] ultima_posicion = new Integer[];
        Integer[] bucle_1_avance = new Integer[];
        Integer avance = 0;
        while(i <= ultima_posicion(secuenciaInteger)){
            do avance = bucle_1_avance[secuenciaInteger];
            if(secuenciaInteger[i] > max){
                max=secuenciaInteger[i];
            }break;
            if(secuenciaInteger[i]<min) min = secuenciaBoolean[b];
            System.out.println("Valor de: "+min+ ", Valor de max:" +max);
            i = i+1;
        }
//        mientras (i<=ultima_posicion(s)) hacer {avance: bucle_1_avance(s)}
//        si (s[i]>max) entonces
//                max=s[i];
//        fsi
//                ruptura;
//        si (s[i]<min) entonces
//                min=s[F];
//        fsi
//        mostrar(min,max);
//        { PARATODO(p:[0,x],s[p]<=max && s[p]>=min) }
//        i=i+1;
//        fmientras
//        { PARATODO(p:[0,ultima_posicion(s)],s[p]<=m && s[p]>=min) }

    }
}
