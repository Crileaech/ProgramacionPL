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

expr: expr_integer
    | expr_bool
    | expr_seq
    | expr_func
    ;

expr_integer: expr_sacar_elem                                                 #sacarElemInteger
            | RESTA expr_integer                                              #menosNum
            | PA expr_integer PC                                              #parentesisInteger
            | PA expr_integer (POR) expr_integer PC                           #parentesisOpInteger
            | PA expr_integer (SUMA|RESTA) expr_integer PC                    #parentesisOpInteger
            | expr_integer (POR) expr_integer                                 #opInteger
            | expr_integer (SUMA|RESTA) expr_integer                          #opInteger
            | expr_func                                                       #exprFuncInt
            | NUM                                                             #num
            | variable                                                        #varInt
            ;

expr_bool: T                                                    #true
         | F                                                    #false
         | expr_sacar_elem                                      #sacarElemBool
         | expr_bool (IGUALL|DISTINTO) expr_bool                #compararBool
         | NO expr_bool                                         #negacionBool
         | PA expr_bool (AND|OR) expr_bool PC                   #parentesisOpBool
         | expr_bool (AND|OR) expr_bool                         #opBool
         | expr_seq (IGUALL|DISTINTO) expr_seq                  #compararSeq
         | expr_integer (MENORIGUAL|MAYORIGUAL|MENOR|MAYOR|IGUALL|DISTINTO) expr_integer #compararInteger
         | expr_func                                            #exprFuncBool
         | variable                                             #varBool
         ;

expr_seq: CA CC                             #vaciaSeq // []
        | CA (expr COMA)* expr CC           #seq
        | expr_func                         #exprFuncSeq
        | variable                          #varSeq
        ;

expr_sacar_elem: (variable|expr_func) CA expr_integer CC ;

expr_avanza: LA AVANZA DOSPTOS expr_func LC;

expr_func: variable PA (exprs)? PC;

exprs: expr
     | expr COMA exprs
     ;
//---INSTRUCCIONES---

declaracion_instrucciones: asignacion   #asig
                         | condicion    #cond
                         | iteracion    #it
                         | BREAK PyC    #break
                         | devolucion   #dev
                         | mostrar      #show
                         | asertos      #aserto
                         | expr_func PyC #exprfun
                         ;

devolucion: RETURN (expr COMA)* expr PyC;

asignacion: ((variable|expr_sacar_elem) COMA)* (variable|expr_sacar_elem) IGUAL (expr COMA)* (expr) PyC;

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

cuantificacion: PA variable DOSPTOS CA expr_integer COMA expr_integer CC COMA expr_bool PC;
