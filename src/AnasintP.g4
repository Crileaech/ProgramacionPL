programa: variables subprogramas instrucciones;
variables: VARIABLES (declaracion_variables)*;
declaracion_variables: (identificador DOSPUNTOS (tipos)+)* PyC;
identificador: var_numericas|secuencias;
var_numericas: IDENT COMA (MAX|MIN) DOSPUNTOS (NUM|LOG) PyC;
secuencias: IDENT DOSPUNTOS tipos_no_elementales;
tipos: tipos_elementales | tipos_no_elementales;
tipos_elementales: NUM | LOG;
tipos_no_elementales: SEQ(NUM) | SEQ(LOG) PyC;
subprogramas:SUBPROGRAMAS (declaracion_subprogramas)+;
declaracion_subprograma: funciones | procedimientos;
funciones: funcion | predicado;
funcion: FUNCION parametros declaracion_variables bloq_instrucciones FFUNCION;
parametros: params_entrada params_salida;
params_entrada: (mayor|menor|mayor_que|menor_que) PA SEQ IDENT PC;
params_salida: dev PA param_salida PC;
param_salida: PA (tipos_elementales IDENT COMA)+ PC;
bloq_instrucciones: INSTRUCCIONES (bloq_instruccion)+;
bloq_instruccion:(IDENT ASIGNACION DIGITOS)+ PyC bloq_while
                |(MIN|MAX) ASIGNACION IDENT CA IDENT CC  bloq_while
                ;
bloq_while: MIENTRAS PA expr_while PC HACER bloq_condicion FMIENTRAS DEV (MAX|MIN) COMA IDENT;
expr_while: IDENT (MENOR_QUE|MAYOR_QUE|MENOR|MAYOR) ULTIMA_POSICION PA IDENT PC;
bloq_condicion: SI PA expr_condicion PC ENTONCES bloq_instruccion* FSI (asignaciones)*;
expr_condicion:IDENT CA IDENT CC (MAYOR|MENOR|MAYOR_QUE|MENOR_QUE) (MAX|MIN);
asignaciones: IDENT ASIGNACION IDENT SUMA DIGITO PyC;

