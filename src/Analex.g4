lexer grammar Analex;

BLANCO: ' ' ->skip;
TABULADOR: '\t'->skip;
FIN_LINEA: '\r'?'\n' ->skip;
fragment DIGITO: [0-9];
fragment LETRA: [a-zA-Z];

VARIABLES: 'VARIABLES';
PROGRAMA: 'PROGRAMA';
SUBPROGRAMAS: 'SUBPROGRAMAS';
INSTRUCCIONES: 'INSTRUCCIONES';
FUNCION: 'FUNCION';
FFUNCION: 'FFUNCION';
RETURN: 'dev';
PROCEDIMIENTO: 'PROCEDIMIENTO';
FPROCEDIMIENTO: 'FPROCEDIMIENTO';
EVAL: 'EVAL';
DEF: 'DEF';

NUMERO : 'NUM';
BOOL: 'LOG';
SEQ_NUM: 'SEQ(NUM)';
SEQ_BOOL: 'SEQ(BOOL)';
SEQ: 'SEQ';
T: 'T' | 'cierto';
F: 'F' | 'falso';
BREAK: 'ruptura';
IF: 'si';
THEN: 'entonces';
ENDIF: 'fsi';
ELSE: 'sino';
WHILE: 'mientras';
DO: 'hacer';
ENDWHILE: 'fmientras';
FORALL: 'PARATODO';
EXISTS: 'EXISTE';
AVANZA: 'avance';
MOSTRAR: 'mostrar';

NUM: (DIGITO)+;
VAR: LETRA(LETRA|DIGITO|'_')*;

DOSPTOS: ':';
PA : '(';
PC : ')';
CA: '[';
CC: ']';
LA: '{';
LC: '}';
PyC : ';';
COMA : ',';
SUMA : '+';
RESTA : '-';
POR : '*';
IGUAL: '=';
IGUALL: '==';
DISTINTO: '!=';
MENORIGUAL: '<=';
MAYORIGUAL: '>=';
MENOR: '<';
MAYOR: '>';
NO: '!';
AND: '&&';
OR: '||';

COMENTARIO_BLOQUE : '/*' .*? '*/' -> skip ; //skip para que no se lo pase al sintáctico pues no tiene sentido.
COMENTARIO_LINEA : '//' .*? FIN_LINEA -> skip ;