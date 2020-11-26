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

elementales: (variable COMA)* variable DOSPTOS tipos_elementales;

secuencias: variable DOSPTOS tipos_no_elementales;

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

expr: expr_integer
    | expr_bool
    | expr_seq
    | expr_func
    ;

op_integer: (POR|SUMA|RESTA) ;

expr_integer:  expr_sacar_elem                              #sacarElemInteger
            | PA expr_integer op_integer expr_integer PC    #parentesisOpInteger
            | expr_integer op_integer expr_integer          #opInteger
            | expr_func                                     #exprFuncInt
            | NUM                                           #num
            | variable                                      #varInt
            ;

op_bool: AND
       | OR
       ;

comp_bool: IGUALL
         | DISTINTO
         ;
comp_integer: MENORIGUAL
            | MAYORIGUAL
            | MENOR
            | MAYOR
            | comp_bool
            ;
expr_bool: T                                            #true
         | F                                            #false
         | expr_sacar_elem                              #sacarElemBool
         | expr_bool comp_bool expr_bool                #compararBool
         | PA expr_bool op_bool expr_bool PC            #parentesisOpBool
         | expr_bool op_bool expr_bool                  #opBool
         | expr_seq comp_bool expr_seq                  #compararSeq
         | expr_integer comp_integer expr_integer       #compararInteger
         | NO expr_bool                                 #negacionBool
         | expr_func                                    #exprFuncBool
         | variable                                     #varBool
         ;

expr_seq: CA CC                         #vaciaSeq
        | CA (expr COMA)* expr CC       #seq
        | expr_func                     #exprFuncSeq
        | variable                      #varSeq
        ;

expr_avanza: LA AVANZA DOSPTOS expr_func LC;

expr_func: variable PA (expr) (COMA expr)* PC;

expr_sacar_elem: variable CA expr_integer CC;

//---INSTRUCCIONES---

declaracion_instrucciones: asignacion
                         | condicion
                         | iteracion
                         | ruptura
                         | devolucion
                         | mostrar
                         | asertos
                         | expr_func PyC
                         ;

asignacion: (variable COMA)* variable IGUAL (expr COMA)* (expr) PyC;

condicion: IF PA expr_bool PC THEN (declaracion_instrucciones)+ (blq_sino)? ENDIF;

blq_sino: ELSE (declaracion_instrucciones)+;

iteracion: WHILE PA expr_bool PC DO (expr_avanza)? (declaracion_instrucciones)+ ENDWHILE;

ruptura: BREAK PyC;

devolucion: RETURN (expr COMA)* expr PyC;

mostrar: MOSTRAR PA (expr COMA)* expr PC PyC;

asertos: LA ( expr | cuantificador ) LC;

cuantificador: cuantificadorUniversal
             | cuantificadorExistencial
             ;

cuantificadorUniversal: FORALL cuantificacion;

cuantificadorExistencial: EXISTS cuantificacion;

cuantificacion: PA variable DOSPTOS CA expr_integer COMA expr_integer CC COMA expr_bool PC;