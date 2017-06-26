grammar MyLanguage;

expr :
    LEFT expr RIGHT                 # parenthesis
    | <assoc=right> expr POWER expr # power
    | NEG expr                      # negation
    | expr TIMES expr               # multiplication
    | expr NEG expr                 # subtraction
    | expr PLUS expr                # addition
    | NUMBER                        # number;

NUMBER : [0-9]+;
POWER : '^';
TIMES : '*';
PLUS : '+';
NEG : '-';
LEFT : '(';
RIGHT : ')';

// ignore whitespace
WS : [ \t\n\r] -> skip;
