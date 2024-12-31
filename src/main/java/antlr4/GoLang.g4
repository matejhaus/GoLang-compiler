grammar GoLang;

program: 'package' IDENTIFIER 'import' importList? declaration*;

importList: importSpec (',' importSpec)*;
importSpec: STRING;

declaration: varDeclar | ifBlock | forBlock | funcDeclar | typeDeclar | statement | sliceDeclar | matrixDeclar;

ifBlock: 'if' expression block ('else' elseIfBlock)?;

elseIfBlock: block | ifBlock;

block: '{' declaration* statement* returnStatement? '}';

statement: (assignment | funcCall) ';'?;

returnStatement: 'return' expression ';'?;

assignment: (IDENTIFIER | arrayAccess | matrixAccess) ASSIGN_OP expression;

forBlock: 'for' (forHeader | expression)? block;

forHeader
    : (varDeclar | simpleStmt)? ';' expression? ';' simpleStmt?
    ;

simpleStmt: (assignment | funcCall | incrementDecrement);

incrementDecrement: IDENTIFIER ('++' | '--');

funcDeclar: 'func' IDENTIFIER '(' paramList? ')' result? block;

paramList: param (',' param)*;

param: IDENTIFIER varType;

result: varType | '(' varType (',' varType)* ')';

typeDeclar: 'type' IDENTIFIER varType;

varDeclar: IDENTIFIER ':=' expression | 'var' IDENTIFIER (varType)? (ASSIGN_OP expression)? ';'?;

funcCall: ('fmt.')? IDENTIFIER '(' (expression (',' expression)*)? ')' | IDENTIFIER '(' (expression (',' expression)*)? ')';

sliceDeclar: 'var' IDENTIFIER '[' INTEGER ']' varType ASSIGN_OP sliceInit ';'?;
sliceInit: '[' INTEGER ']' varType '{' (expression (',' expression)*)? '}';

matrixDeclar: 'var' IDENTIFIER arrayDimensions? varType? ASSIGN_OP matrixInit ';'?;
arrayDimensions: '[' INTEGER ']' ('[' INTEGER ']')*;
matrixInit: arrayDimensions varType '{' (matrixRow',')* '}';
matrixRow: '{' expression (',' expression)* '}';

matrixAccess: IDENTIFIER '[' expression ']' '[' expression ']';

arrayAccess: IDENTIFIER '[' expression ']';

varType: 'int' | 'float64' | 'string' | 'bool' | arrayType;

arrayType: '[' INTEGER ']' ('[' INTEGER ']')* varType;
type: INTEGER | FLOAT | STRING | BOOL;

expression
    : type                                       #constantExpression
    | IDENTIFIER                                      #identifierExpression
    | funcCall                                        #funcCallExpression
    | '(' expression ')'                              #parenthesizedExpression
    | expression MULTIPLYING_OPERATOR expression      #multiplicativeExpression
    | expression ADDING_OPERATOR expression           #additiveExpression
    | expression COMPARE_OPERATOR expression          #comparisonExpression
    | expression BOOL_OPERATOR expression             #booleanExpression
    | arrayAccess                                     #arrayExpression
    | matrixAccess                                    #matrixExpression
    ;

MULTIPLYING_OPERATOR: '*' | '/' | '%';
COMPARE_OPERATOR: '==' | '!=' | '>' | '<' | '>=' | '<=';
BOOL_OPERATOR: '&&' | '||';
ADDING_OPERATOR: '+' | '-';
ASSIGN_OP: '=';

IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;
INTEGER: [0-9]+;
FLOAT: [0-9]+ '.' [0-9]+;
STRING: '"' ~'"'* '"';
BOOL: 'true' | 'false';

WHITESPACE: [ \t\r\n]+ -> skip;