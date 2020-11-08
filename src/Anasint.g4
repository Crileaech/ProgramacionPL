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

variable: VAR;
declaracion_subprogramas: funcion
                        | procedimiento
                        ;

funcion: FUNCION variable PA (params)? PC RETURN PA params PC variables instrucciones FFUNCION;

procedimiento: PROCEDIMIENTO variable PA (params)? PC variables instrucciones FPROCEDIMIENTO;

params: tipos variable
      | tipos variable COMA params
      ;

//---TIPOS/EXPRESIONES---

op_integer: POR
          | SUMA
          | RESTA
          ;

comp_integer: MENORIGUAL
            | MAYORIGUAL
            | MENOR
            | MAYOR
            | comp_bool
            ;

op_bool: AND
       | OR
       ;

comp_bool: IGUALL
         | DISTINTO
         ;

expr: expr_integer
    | expr_bool
    | expr_seq
    | expr_func
    | expr_sacar_elem
    ;

expr_integer: expr_integer op_integer expr_integer
            | NUM
            | variable
            ;

expr_bool: T
         | F
         | expr_bool comp_bool expr_bool
         | expr_seq comp_bool expr_seq
         | expr_integer comp_integer expr_integer
         | NO expr_bool
         | expr_bool op_bool expr_bool
         | variable
         ;

expr_seq: CA CC // []
        | CA (expr COMA)* expr CC
        | variable
        ;

expr_sacar_elem: variable CA expr_integer CC;

expr_avanza: LA AVANZA DOSPTOS expr_func LC;

//antes: VAR PA (VAR) (COMA var)* PC
expr_func: variable PA (variable|expr) (COMA variable|expr)* PC;

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
asignacion: (variable COMA)* variable IGUAL ((variable|expr) COMA)* (variable|expr) PyC;

condicion: IF PA expr_bool PC THEN (declaracion_instrucciones)+ (blq_sino)? ENDIF;

blq_sino: ELSE (declaracion_instrucciones)+;

iteracion: WHILE PA expr_bool PC DO (expr_avanza)? (declaracion_instrucciones)+ ENDWHILE;

mostrar: MOSTRAR PA (expr COMA)* expr PC PyC;

asertos: LA ( expr_bool | cuantificador ) LC;

cuantificador: cuantificadorUniversal
             | cuantificadorExistencial
             ;

cuantificadorUniversal: FORALL cuantificacion;

cuantificadorExistencial: EXISTS cuantificacion;

//DUDA EXPR BOOLEANA
cuantificacion: PA variable DOSPTOS CA expr_integer COMA expr_integer CC COMA expr_bool PC;

