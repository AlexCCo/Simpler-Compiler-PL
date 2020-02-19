package src.manual;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class LexicalScanner {
    private Reader input;
    private StringBuffer lexeme;
    private int next;
    private int beginningRow;
    private int beginningColumn;
    private int currentRow;
    private int currentColumn;
    private static String NEWLINE = System.lineSeparator();


    /**
     * The num defining each transition for our Finite Deterministic Automata
     */
    //each comment following the enum value, specifies which state is in the diagram
    private enum State {
        BEGIN,
        REC_SIGN, //opPlus/Minus
        REC_OPERATOR_ADD, //final opAdd/Minus
        REC_OPERATOR_MINUS, //final opAdd/Minus
        REC_OPERATOR_LESS, //final not drawn in the diagram (opX)
        REC_OPERATOR_GREATER, //final not drawn in the diagram (opX)
        REC_OPERATOR_LESS_EQUAL, //final not drawn in the diagram (opX)
        REC_OPERATOR_GREATER_EQUAL, //final not drawn in the diagram (opX)
        REC_OPERATOR_EQUAL, //final not drawn in the diagram (opX)
        REC_OPERATOR_NOT_EQUAL_PART,// not drawn in the diagram (opX)
        REC_OPERATOR_NOT_EQUAL, //final not drawn in the diagram (opX)
        REC_OPERATOR_DIV, //final not drawn in the diagram (opX)
        REC_OPERATOR_MUL, //final not drawn in the diagram (opX)
        REC_OPEN_PARENTHESIS,
        REC_CLOSE_PARENTHESIS,
        REC_INTEGER_VAL_0, //e3 final
        REC_INTEGER, //e1 final
        REC_INIT_DECIMAL, //r1
        REC_DECIMAL_PART, //r2 final
        REC_ERROR_DECIMAL, //r3
        REC_EXPONENTIAL_PART, //r4
        REC_EXPONENTIAL_SIGN, //r6
        REC_EXPONENTIAL_VAL_0, //r7 final
        REC_EXPONENTIAL, //r5 final
        REC_EOD_PART, //eod1
        REC_EOD, //edo final
        REC_EOI, //eoi final
        REC_VAR_NAME //v1 final
    }

    private State currentState;

    /**
     * The constructor for the <b>lexical</b> Scanner class
     * @param input The needed source from which it will read the program to parse
     * @throws IOException
     */
    public LexicalScanner(Reader input) throws IOException {
        this.input = input;
        lexeme = new StringBuffer();
        next = input.read();
        currentRow = 1;
        currentColumn = 1;
    }

    /**
     * It parses the program looking for the next Token to return
     * @return The LexicalUnit class representing the token
     * @throws IOException
     */
    public LexicalUnit sigToken() throws IOException {
        currentState = State.BEGIN;
        beginningRow = currentRow;
        beginningColumn = currentColumn;
        lexeme.delete(0, lexeme.length());
        while (true) {
            //Defining the transitions of each state
            switch (currentState) {
                case BEGIN:
                    // + or -
                    if (signSymbol()){takeTransition(State.REC_SIGN);}
                    else if(justZero()){takeTransition(State.REC_INTEGER_VAL_0);}
                    else if(digitButZero()){takeTransition(State.REC_INTEGER);}
                    else if(ampersandSymbol()){takeTransition(State.REC_EOD_PART);}
                    else if (semicolonSymbol()){takeTransition(State.REC_EOI);}
                    //[a-zA-Z]
                    else if(character()){takeTransition(State.REC_VAR_NAME);}
                    else if(lessThan()){takeTransition(State.REC_OPERATOR_LESS);}
                    else if(greaterThan()){takeTransition(State.REC_OPERATOR_GREATER);}
                    else if(openParenthesisSymbol()){takeTransition(State.REC_OPEN_PARENTHESIS);}
                    else if(closeParenthesisSymbol()){takeTransition(State.REC_CLOSE_PARENTHESIS);}
                    else if(divSymbol()){takeTransition(State.REC_OPERATOR_DIV);}
                    else if(mulSymbol()){takeTransition(State.REC_OPERATOR_MUL);}
                    else if(exclamationMark()){takeTransition(State.REC_OPERATOR_NOT_EQUAL);}
                    else if(ignorableSymbol()){skipChar(State.BEGIN);}
                    //TODO: what happens when we encounter a newline symbol?
                    break;
                case REC_SIGN:
                    if(ignorableSymbol() && lexeme.equals("+")){skipChar(State.REC_OPERATOR_ADD);}
                    else if(ignorableSymbol() && lexeme.equals("-")){skipChar(State.REC_OPERATOR_MINUS);}
                    else if(justZero()){takeTransition(State.REC_INTEGER_VAL_0);}
                    else if(digitButZero()){takeTransition(State.REC_INTEGER);}
                    //TODO:error
                    else{  }
                    break;
                case REC_OPERATOR_LESS:
                    if(equalSymbol()){takeTransition(State.REC_OPERATOR_LESS_EQUAL);}
                    else if(ignorableSymbol() || endOfFileSymbol()){return tokenOperatorLessThan();}
                    //TODO: error
                    break;
                case REC_OPERATOR_LESS_EQUAL:
                    if(ignorableSymbol() || endOfFileSymbol()){return tokenOperatorLessThanOrEquals();}
                    //TODO: error
                    break;
                case REC_OPERATOR_GREATER:
                    if(equalSymbol()){takeTransition(State.REC_OPERATOR_GREATER_EQUAL);}
                    else if(ignorableSymbol() || endOfFileSymbol()){return tokenOperatorGreaterThan();}
                    //TODO: error
                    break;
                case REC_OPERATOR_GREATER_EQUAL:
                    if(ignorableSymbol() || endOfFileSymbol()){return tokenOperatorGreaterThanOrEquals();}
                    //TODO: error
                    break;
                case REC_OPERATOR_EQUAL:
                    if(ignorableSymbol() || endOfFileSymbol()){return tokenOperatorEquals();}
                    //TODO: error
                    break;
                case REC_OPERATOR_NOT_EQUAL_PART:
                    if(equalSymbol()){takeTransition(State.REC_OPERATOR_GREATER_EQUAL);}
                    //TODO: error
                    break;
                case REC_OPERATOR_NOT_EQUAL:
                    if(ignorableSymbol() || endOfFileSymbol()){return tokenOperatorNotEquals();}
                    //TODO: error
                    break;
                case REC_INTEGER_VAL_0:
                    if(dotSymbol()){takeTransition(State.REC_INIT_DECIMAL);}
                    else if(ignorableSymbol() || endOfFileSymbol()){return tokenInteger();}
                    //TODO:error
                    break;
                case REC_INTEGER:
                    if(digit()){takeTransition(State.REC_INTEGER);}
                    else if(dotSymbol()){takeTransition(State.REC_INIT_DECIMAL);}
                    else if(exponential()){takeTransition(State.REC_EXPONENTIAL_PART);}
                    else if(ignorableSymbol() || endOfFileSymbol()){return tokenInteger();}
                    //TODO:error
                    break;
                case REC_INIT_DECIMAL:
                    if(digit()){takeTransition(State.REC_DECIMAL_PART);}
                    //TODO:error
                    break;
                case REC_DECIMAL_PART:
                    if(digitButZero()){takeTransition(State.REC_DECIMAL_PART);}
                    else if(justZero()){takeTransition(State.REC_ERROR_DECIMAL);}
                    else if(exponential()){takeTransition(State.REC_EXPONENTIAL_PART);}
                    else if(ignorableSymbol() || endOfFileSymbol()){return tokenReal();}
                    //TODO: error
                    break;
                case REC_ERROR_DECIMAL:
                    if(digitButZero()){takeTransition(State.REC_DECIMAL_PART);}
                    //TODO: error
                    break;
                case REC_EXPONENTIAL_PART:
                    if(justZero()){takeTransition(State.REC_EXPONENTIAL_VAL_0);}
                    else if(signSymbol()){takeTransition(State.REC_EXPONENTIAL_SIGN);}
                    else if(digitButZero()){takeTransition(State.REC_EXPONENTIAL);}
                    //TODO: error
                    break;
                case REC_EXPONENTIAL_SIGN:
                    if(justZero()){takeTransition(State.REC_EXPONENTIAL_VAL_0);}
                    else if(digitButZero()){takeTransition(State.REC_EXPONENTIAL);}
                    //TODO: error
                    break;
                case REC_EXPONENTIAL_VAL_0:
                    if(ignorableSymbol() || endOfFileSymbol()){return tokenReal();}
                    //TODO: error
                    break;
                case REC_EXPONENTIAL:
                    if(digit()){takeTransition(State.REC_EXPONENTIAL);}
                    else if(ignorableSymbol() || endOfFileSymbol()){return tokenReal();}
                    //TODO: error
                    break;
                case REC_EOD_PART:
                    //TODO: error
                case REC_EOD:
                    if(ignorableSymbol() || endOfFileSymbol()){return tokenEspecialCharacters();}
                    //TODO: error
                    break;
                case REC_EOI:
                    if(ignorableSymbol() || endOfFileSymbol()){return tokenEspecialCharacters();}
                    //TODO: error
                    break;
                case REC_VAR_NAME:
                    if(character() || digit() || underscore()){takeTransition(State.REC_VAR_NAME);}
                    else if(ignorableSymbol() || endOfFileSymbol()){return tokenVarName();}
                    //TODO: error
                    break;
                default:
                    //TODO: error
                    break;
            }
        }
    }

    private void takeTransition(State nextState) throws IOException {
        lexeme.append((char) next);
        nextChar();
        currentState = nextState;
    }

    private void skipChar(State sig) throws IOException {
        nextChar();
        beginningRow = currentRow;
        beginningColumn = currentColumn;
        currentState = sig;
    }

    private void nextChar() throws IOException {
        next = input.read();
        if (next == NEWLINE.charAt(0)) saltaFinDeLinea();
        if (next == '\n') {
            currentRow++;
            currentColumn = 0;
        } else {
            currentColumn++;
        }
    }

    private void saltaFinDeLinea() throws IOException {
        for (int i = 1; i < NEWLINE.length(); i++) {
            next = input.read();
            if (next != NEWLINE.charAt(i)) error();
        }
        next = '\n';
    }

    /* ****************************** */
    /*      REGULAR DEFINITIONS       */
    /* ****************************** */

    private boolean character() {
        return next >= 'a' && next <= 'z' ||
                next >= 'A' && next <= 'z';
    }

    private boolean digit(){
        return digitButZero() || justZero();
    }

    private boolean digitButZero() {
        return next >= '1' && next <= '9';
    }

    private boolean justZero(){
        return next == '0';
    }

    private boolean addSymbol() {
        return next == '+';
    }

    private boolean ampersandSymbol(){
        return next == '&';
    }

    private boolean underscore(){
        return next == '_';
    }

    private boolean semicolonSymbol(){
        return next == ';';
    }

    private boolean minusSymbol() {
        return next == '-';
    }

    private boolean signSymbol(){
        return addSymbol() || minusSymbol();
    }

    private boolean mulSymbol() {
        return next == '*';
    }

    private boolean divSymbol() {
        return next == '/';
    }

    private boolean openParenthesisSymbol() {
        return next == '(';
    }

    private boolean closeParenthesisSymbol() {
        return next == ')';
    }

    private boolean equalSymbol() {
        return next == '=';
    }

    private boolean exclamationMark(){
        return next == '!';
    }

    private boolean dotSymbol() {
        return next == '.';
    }

    private boolean lessThan(){
        return next == '<';
    }

    private boolean greaterThan(){
        return next == '>';
    }

    private boolean exponential(){
        return next == 'e' || next == 'E';
    }

    private boolean operatorX(){
        return  divSymbol() || mulSymbol() || lessThan() || greaterThan() ;
    }

    private boolean ignorableSymbol() {
        return next == ' ' || next == '\t' || next == '\n';
    }

    private boolean newLineSymbol() {
        return next == '\r' || next == '\b' || next == '\n';
    }

    private boolean endOfFileSymbol() {
        return next == -1;
    }

    private LexicalUnit tokenEspecialCharacters() {
        switch (lexeme.toString()) {
            case ";":
                return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.EOI);
            case "&&":
                return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.EOD);
            default:
                this.error();
                return null;
        }
    }

    private LexicalUnit tokenOperatorAdd() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_ADD);
    }

    private LexicalUnit tokenOperatorMinus() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_MINUS);
    }

    private LexicalUnit tokenOperatorMul() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_MUL);
    }

    private LexicalUnit tokenOperatorDiv() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_DIV);
    }

    private LexicalUnit tokenOperatorLessThan() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_LESS_THAN);
    }

    private LexicalUnit tokenOperatorLessThanOrEquals() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_LESS_EQUAL_THAN);
    }

    private LexicalUnit tokenOperatorGreaterThan() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_GREATER_THAN);
    }

    private LexicalUnit tokenOperatorGreaterThanOrEquals() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_GREATER_EQUAL_THAN);
    }

    private LexicalUnit tokenOperatorEquals() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_EQUAL);
    }

    private LexicalUnit tokenOperatorNotEquals() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_NOT_EQUAL);
    }

    private LexicalUnit tokenOperatorAssignment() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPERATOR_ASSIGNMENT);
    }

    private LexicalUnit tokenVarName() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.VAR_NAME);
    }

    private LexicalUnit tokenIgnorable() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.IGNORABLE);
    }

    private LexicalUnit tokenInteger() {
        return new MultiValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.INTEGER_NUM, lexeme.toString());
    }

    private LexicalUnit tokenReal() {
        return new MultiValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.REAL_NUM, lexeme.toString());
    }

    private LexicalUnit tokenOpenParenthesis() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.OPEN_PARENTHESIS);
    }

    private LexicalUnit tokenCloseParenthesis() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.CLOSE_PARENTHESIS);
    }

    private LexicalUnit tokenEOF() {
        return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.EOF);
    }

    private void error() {
        System.err.println("(" + currentRow + ',' + currentColumn + "):Unexpected character");
        System.exit(1);
    }
}