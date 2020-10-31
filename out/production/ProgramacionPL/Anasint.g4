parser grammar Anasint;
options{ tokenVocab=Analex; }

programa: PROGRAMA variables subprogramas instrucciones EOF;

variables: VARIABLES (declaracion_variables)*;
subprogramas: SUBPROGRAMAS (declaracion_subprogramas)*;
instrucciones: INSTRUCCIONES (declaracion_instrucciones)*;

//---VARIABLES---

declaracion_variables: identificador PyC;

identificador: elementales
             | secuencias
             ;

elementales: (VAR COMA)* VAR DOSPTOS tipos_elementales;

secuencias: VAR DOSPTOS tipos_no_elementales;

tipos: tipos_elementales
     | tipos_no_elementales
     ;

tipos_elementales: NUMERO
                 | BOOL
                 ;

tipos_no_elementales: SEQ_NUM
                    | SEQ_BOOL
                    ;
//---SUBPROGRAMAS---

declaracion_subprogramas: funcion
                        | procedimiento
                        ;

funcion: FUNCION VAR PA (params)? PC RETURN PA params PC variables instrucciones FFUNCION;

procedimiento: PROCEDIMIENTO VAR PA (params)? PC variables instrucciones FPROCEDIMIENTO;

params: tipos VAR
      | tipos VAR COMA params
      ;

//---TIPOS/EXPRESIONES---

expr: expr_integer
    | expr_bool
    | expr_seq
    ;

expr_integer: NUM
            | expr_integer (POR|SUMA|RESTA) expr_integer
            | VAR CA expr_integer CC // variable que almacena una secuencia de enteros
            | expr_func // en caso de que devuelva un entero
            | VAR
            ;

expr_bool: T
         | F
         | VAR (IGUALL|DISTINTO) VAR
         | expr_integer (MENORIGUAL|MAYORIGUAL|MENOR|MAYOR) expr_integer
         | NO expr_bool
         | expr_bool (AND|OR) expr_bool
         | VAR CA expr_integer CC //VAR en este caso sería una variable que almacena una secuencia de boolean
         | expr_func //en caso de que llamar a esa función devuelva un boolean
         | VAR
         ;

expr_seq: CA CC // []
        | CA (expr_integer COMA)* expr_integer CC
        | CA (expr_bool COMA)* (expr_bool) CC
        | expr_func
        | VAR
        ;

expr_avanza: LA AVANZA DOSPTOS expr_func LC;

//antes: VAR PA (VAR) (COMA var)* PC
expr_func: VAR PA (VAR|expr) (COMA VAR|expr)* PC;

//---INSTRUCCIONES---

declaracion_instrucciones: asignacion
                         | condicion
                         | iteracion
                         | BREAK PyC
                         | RETURN expr PyC
                         | mostrar
                         | asertos
                         | expr_func PyC
                         ;

//antes: (VAR COMA)* VAR IGUAL (expr COMA)* (expr) PyC;
asignacion: (VAR COMA)* VAR IGUAL ((VAR|expr) COMA)* (VAR|expr) PyC;

condicion: IF PA expr_bool PC THEN (declaracion_instrucciones)+ (blq_sino)? ENDIF;

blq_sino: ELSE (declaracion_instrucciones)+;

iteracion: WHILE PA expr_bool PC DO (expr_avanza)? (declaracion_instrucciones)+ ENDWHILE;

mostrar: MOSTRAR PA (expr COMA)* expr PC PyC;

asertos: LA ( expr | cuantificador ) LC;

cuantificador: cuantificadorUniversal
             | cuantificadorExistencial
             ;

cuantificadorUniversal: FORALL cuantificacion;

cuantificadorExistencial: EXISTS cuantificacion;

//DUDA EXPR BOOLEANA
cuantificacion: PA VAR DOSPTOS CA expr_integer COMA expr_integer CC COMA expr_bool PC;