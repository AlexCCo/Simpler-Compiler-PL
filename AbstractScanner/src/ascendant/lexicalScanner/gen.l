package lexicalScanner;

%%
%line
%class LexicalScanner
%type  LexicalUnit
%unicode

%{
    private TokenFactory tk;
    public String getLexeme() {return yytext();}
    public int getRow() {return yyline+1;}
    public int getColumn() {return 0;}
    public void error() {
        System.err.println("(" + getRow() + "):Unexpected character");
        System.exit(1);
    }
%}

%eofval{
    return tk.tokenEOF();
%eofval}

%init{
    tk = new TokenFactory(this);
%init}

digit = [0-9]
posDigit = [1-9]
char = ([a-z]|[A-Z])
intOr0 = ({posDigit}{digit}*|0)
float = \.({digit}*{posDigit}|0)
exp = (e|E){sign}?{intOr0}
sign = (\+|\-)

OPERATOR_ADD = \+
OPERATOR_MINUS = \-
OPERATOR_DIV = /
OPERATOR_MUL = \*
OPERATOR_LESS_THAN = <
OPERATOR_LESS_EQUAL_THAN = <\=
OPERATOR_GREATER_THAN = >
OPERATOR_GREATER_EQUAL_THAN = >\=
OPERATOR_ASSIGNMENT = \=
OPERATOR_EQUAL = \=\=
OPERATOR_NOT_EQUAL = !\=
LOGICAL_OR = or
LOGICAL_AND = and
LOGICAL_NOT = not
INTEGER_NUM = {sign}?{intOr0}
REAL_NUM = {INTEGER_NUM}({float}|{exp}|{float}{exp})
VAR_NAME = {char}({char}|{digit}|_)*
REAL_TYPE = real
INT_TYPE = int
BOOL_TYPE = bool
BOOLEAN = (true|false)
EOI = ;
EOD = &&
OPEN_PARENTHESIS = \(
CLOSE_PARENTHESIS = \)
IGNORABLE = [ \t\r\b\n]
%%
{OPERATOR_ADD}                      {return tk.tokenOperatorAdd();}
{OPERATOR_MINUS}                    {return tk.tokenOperatorMinus();}
{OPERATOR_DIV}                      {return tk.tokenOperatorDiv();}
{OPERATOR_MUL}                      {return tk.tokenOperatorMul();}
{OPERATOR_LESS_THAN}                {return tk.tokenOperatorLessThan();}
{OPERATOR_LESS_EQUAL_THAN}          {return tk.tokenOperatorLessThanOrEquals();}
{OPERATOR_GREATER_THAN}             {return tk.tokenOperatorGreaterThan();}
{OPERATOR_GREATER_EQUAL_THAN}       {return tk.tokenOperatorGreaterThanOrEquals();}
{OPERATOR_EQUAL}                    {return tk.tokenOperatorEquals();}
{OPERATOR_NOT_EQUAL}                {return tk.tokenOperatorNotEquals();}
{OPERATOR_ASSIGNMENT}               {return tk.tokenOperatorAssignment();}
{LOGICAL_OR}                        {return tk.tokenVarName();}
{LOGICAL_AND}                       {return tk.tokenVarName();}
{LOGICAL_NOT}                       {return tk.tokenVarName();}
{INTEGER_NUM}                       {return tk.tokenInteger();}
{REAL_NUM}                          {return tk.tokenReal();}
{VAR_NAME}                          {return tk.tokenVarName();}
{REAL_TYPE}                         {return tk.tokenVarName();}
{INT_TYPE}                          {return tk.tokenVarName();}
{BOOL_TYPE}                         {return tk.tokenVarName();}
{BOOLEAN}                           {return tk.tokenVarName();}
{EOI}                               {return tk.tokenSpecialCharacters();}
{EOD}                               {return tk.tokenSpecialCharacters();}
{OPEN_PARENTHESIS}                  {return tk.tokenOpenParenthesis();}
{CLOSE_PARENTHESIS}                 {return tk.tokenCloseParenthesis();}
{IGNORABLE}                         {}
[^]                                 {this.error();}