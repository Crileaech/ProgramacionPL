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
NOMBREFUNC: (LETRA|DIGITO|'_')+;
EVAL: 'EVAL';
DEF: 'DEF';
NUMERO : 'NUM';
BOOL: 'LOG';
SEQUEN: 'SEQ(NUM)' | 'SEQ(LOG)';
VAR: LETRA(LETRA|DIGITO)*;
TIPO: 'SEQ' | NUMERO | BOOL;

NUM: (DIGITO)+;

DOSPTOS: ':';
PA : '(';
PC : ')';
CA: '[';
CC: ']';
LLAVEA: '{';
LLAVEC: '}';
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
EXIST: 'EXISTE';

AVANZA: 'avance';

COMENTARIO_BLOQUE : '/*' .*? '*/' -> skip ;
COMENTARIO_LINEA : '//' .*? FIN_LINEA -> skip ;