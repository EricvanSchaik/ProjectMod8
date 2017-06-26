grammar MyLanguage;

expr :  prfOp expr                  # prfExpr
        | expr Op expr              # opExpr
        | LEFT expr RIGHT           # parExpr
        | ID                        # varExpr
        | BOOL                      # boolExpr
        | NUMBER                    # numExpr
        ;

prfOp: MIN | NOT;

NUMBER : [0-9]+;
BOOL : 'true' | 'false';
CHAR : [a-zA-Z];
ID : CHAR (CHAR | NUMBER)*;

MIN : '-';
PLUS : '+';
NOT : '!';
TIMES : '*';
DIV : '/';
LT : '<';
LE : '<=';
GT : '>';
GE : '>=';
EQ : '==';
NE : '!=';
AND : '&&';
OR : '||';

// ignore whitespace
WS : [ \t\n\r] -> skip;