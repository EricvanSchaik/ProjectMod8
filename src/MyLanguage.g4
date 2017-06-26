grammar MyLanguage;

decl : type ID (IS expr)?;

expr :  prfOp expr                  # prfExpr
        | expr Op expr              # opExpr
        | LEFT expr RIGHT           # parExpr
        | ID                        # varExpr
        | BOOL                      # boolExpr
        | NUMBER                    # numExpr
        ;
stat:   ID IS expr                       #assStat
        | IF expr THEN stat (ELSE stat)? #ifStat
        | WHILE expr DO stat             #whileStat
        | LPAR (stat SEMI)+ RPAR         #blockStat
        | READ LPAR STR COMMA ID RPAR    #inStat  // auxiliary, not Pascal
        | OUT LPAR STR COMMA expr RPAR   #outStat // auxiliary, not Pascal
        ;

type: BOOLEAN | INTEGER;

prfOp: MIN | NOT;

// Types
NUMBER : [0-9]+;
BOOL : TRUE | FALSE;
CHAR : [a-zA-Z];
ID : CHAR (CHAR | NUMBER)*;

// Keywords
BOOLEAN : 'boolean';
INTEGER : 'int';
TRUE : 'true';
FALSE : 'false';

// Operators
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

// Other
IS : '=';
LEFT : '(';
RIGHT : ')';
LPAR : '{';
RPAR : '}';
SEMI : ';';

// ignore whitespace
WS : [ \t\n\r] -> skip;