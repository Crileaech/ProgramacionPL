parser grammar Anasint;
options{ tokenVocab=Analex; }

programa: PROGRAMA variables subprogramas instrucciones EOF;

variables: VARIABLES (decl_var)*;

subprogramas: SUBPROGRAMAS (funcion|procedimiento)*;

instrucciones: INSTRUCCIONES (inst)*;

decl_var: (VAR COMA)* VAR DOSPTOS tipo PyC
        ;

tipo: NUMERO | BOOL | SEQUEN;

inst: asignacion PyC
    | condicion
    | iteracion
    | BREAK PyC
    | RETURN expr PyC
    | aserto
    | expr_func PyC
    ;

asignacion: (VAR COMA)* VAR IGUAL ((VAR|expr) COMA)* (VAR|expr); // x = 8 ; x,y = 8,9 funcion();

condicion: IF PA expr_bool PC THEN (inst)+ ENDIF
         | IF PA expr_bool PC THEN (inst)+ ELSE (inst)+ ENDIF
         ;

iteracion: WHILE PA expr_bool PC DO (avance)? (inst)+ ENDWHILE;

aserto: LLAVEA expr_bool LLAVEC
      | LLAVEA (FORALL|EXIST) PA VAR DOSPTOS CA expr_entero COMA expr_entero CC COMA expr_bool PC LLAVEC //{ PARATODO(p:[0,ultima_posicion(s)],s[p]<=max && s[p]>=min) }
      ;

avance: LLAVEA AVANZA DOSPTOS expr_func LLAVEC;

funcion: FUNCION VAR PA (most_var)? PC RETURN PA most_var PC variables instrucciones FFUNCION;

procedimiento: PROCEDIMIENTO VAR PA (most_var)? PC variables instrucciones FPROCEDIMIENTO;

most_var: tipo VAR
        | tipo VAR COMA most_var
        ;

expr: expr_entero
    | expr_bool
    | expr_seq
    ; //proce

expr_entero: NUM
           | expr_entero (SUMA|RESTA|POR) expr_entero
           | VAR CA expr_entero CC //VAR en este caso sería una variable que almacena una secuencia de enteros
           | expr_func //en caso de que llamar a esa función devuelva un entero
           | VAR
           ;

expr_bool: T
         | F
         | VAR (IGUALL|DISTINTO) VAR // == !=
         | expr_entero (MENORIGUAL|MAYORIGUAL|MENOR|MAYOR) expr_entero
         | expr_bool (AND|OR) expr_bool
         | NO expr_bool
         | VAR CA expr_entero CC //VAR en este caso sería una variable que almacena una secuencia de boolean
         | expr_func //en caso de que llamar a esa función devuelva un boolean
         | VAR
         ;

expr_seq: CA CC // []
        | CA (expr_entero COMA)* expr_entero CC
        | CA (expr_bool COMA)* expr_bool CC
        | expr_func //en caso de que llamar a esa función devuelva una secuencia
        | VAR;

expr_func: VAR PA (VAR|expr) (COMA VAR|expr)* PC; //VAR|expr si en cada expr hay VAR?. Para que VAR no sea reconocido como una expr_entera de entrada.
                                                  // solo en casos específicos no hace falta especificar esto, como en comparaciones <, > etc donde sí o
                                                  // sí dada nuestra implementación es necesario que dichas variables sean expr_enteras