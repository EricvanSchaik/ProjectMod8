grammar MyLanguage;

program: CLASS ID SEMI body;

body : (stat SEMI)+;

stat :   type ID IS expr                                                    # declStat
        | ID IS expr                                                        # assStat
        | IF LEFT expr RIGHT stat (ELSE stat)?                              # ifStat
        | WHILE LEFT expr RIGHT stat                                        # whileStat
        | FOR ID IN RANGE LEFT NUMBER SEMI NUMBER SEMI NUMBER RIGHT stat    # forStat
        | LPAR (stat SEMI)+ RPAR                                            # blockStat
        | READ LEFT ID RIGHT                                                # readStat
        | PRINT LEFT expr RIGHT                                             # printStat
        ;

expr :  prfOp expr                                                          # prfExpr
        | expr multOp expr                                                  # multExpr
        | expr plusOp expr                                                  # plusExpr
        | expr compOp expr                                                  # compExpr
        | expr boolOp expr                                                  # boolExpr
        | LEFT expr RIGHT                                                   # parExpr
        | ID                                                                # varExpr
        | BOOL                                                              # boolExpr
        | NUMBER                                                            # numExpr
        ;

type: BOOLEAN | INTEGER;

BOOL : TRUE | FALSE;

// Keywords
BOOLEAN : 'boolean';
INTEGER : 'int';
TRUE : 'true';
FALSE : 'false';
CLASS : 'class';
IF : 'if';
ELSE : 'else';
FOR : 'for';
IN: 'in';
RANGE: 'range';
WHILE : 'while';
READ : 'read';
PRINT : 'print';

// Types
NUMBER : [0-9]+;
ID : CHAR (CHAR | NUMBER)*;
CHAR : [a-zA-Z];

// Operators
prfOp: MIN | NOT;
multOp: TIMES | DIV;
plusOp: PLUS | MIN;
boolOp: AND | OR;
compOp: LE | LT | GE | GT | EQ | NE;

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