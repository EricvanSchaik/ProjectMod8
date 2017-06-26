grammar MyLanguage;

decl : type ID (IS expr)?;

stat:   ID IS expr                              #assStat
        | IF LEFT expr RIGHT stat (ELSE stat)?  #ifStat
        | WHILE expr DO stat                    #whileStat
        | LPAR (stat SEMI)+ RPAR                #blockStat
        | READ LEFT ID RIGHT                    #readStat
        | PRINT LEFT expr RIGHT                 #printStat
        ;

expr :  prfOp expr                  # prfExpr
        | expr Op expr              # opExpr
        | LEFT expr RIGHT           # parExpr
        | ID                        # varExpr
        | BOOL                      # boolExpr
        | NUMBER                    # numExpr
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