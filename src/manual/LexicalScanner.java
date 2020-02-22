package manual;

import java.io.IOException;
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
        REC_OPERATOR_EQUAL, //final (comparison) not drawn in the diagram (opX)
        REC_OPERATOR_ASSIGNMENT, //final (assignment)not drawn in the diagram (opX)
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
        REC_EOF,
        REC_VAR_NAME //v1 final
    }

    private State currentState;

    /**
     * The constructor for the <b>lexical</b> Scanner class
     *
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
     *
     * @return The LexicalUnit class representing the token or null in case of an error
     * @throws IOException
     */
    //TODO: We may have a problemn for strings like "real varReal;" or operators without spaces to it's left and right
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
                    if (signSymbol()) {
                        takeTransition(State.REC_SIGN);
                    } else if (justZero()) {
                        takeTransition(State.REC_INTEGER_VAL_0);
                    } else if (digitButZero()) {
                        takeTransition(State.REC_INTEGER);
                    } else if (ampersandSymbol()) {
                        takeTransition(State.REC_EOD_PART);
                    } else if (semicolonSymbol()) {
                        takeTransition(State.REC_EOI);
                    } else if (character()) {
                        //[a-zA-Z]
                        takeTransition(State.REC_VAR_NAME);
                    } else if (lessThan()) {
                        takeTransition(State.REC_OPERATOR_LESS);
                    } else if (greaterThan()) {
                        takeTransition(State.REC_OPERATOR_GREATER);
                    } else if (openParenthesisSymbol()) {
                        takeTransition(State.REC_OPEN_PARENTHESIS);
                    } else if (closeParenthesisSymbol()) {
                        takeTransition(State.REC_CLOSE_PARENTHESIS);
                    } else if (divSymbol()) {
                        takeTransition(State.REC_OPERATOR_DIV);
                    } else if (mulSymbol()) {
                        takeTransition(State.REC_OPERATOR_MUL);
                    } else if (exclamationMark()) {
                        takeTransition(State.REC_OPERATOR_NOT_EQUAL_PART);
                    } else if (equalSymbol()) {
                        takeTransition(State.REC_OPERATOR_ASSIGNMENT);
                    } else if (endOfFileSymbol()){
                        skipChar(State.REC_EOF);
                    } else if (ignorableSymbol() || newLineSymbol()) {
                        //SPACE, \t, \b, \n, \r, EOF
                        skipChar(State.BEGIN);
                    } else {
                        error("LEX ERROR");
                        return null;
                    }
                    break;
                case REC_SIGN:
                    if (justZero()) {
                        takeTransition(State.REC_INTEGER_VAL_0);
                    } else if (digitButZero()) {
                        takeTransition(State.REC_INTEGER);
                    } else {
                        if (lexeme.toString().equals("+"))
                            return tokenOperatorAdd();
                        else if (lexeme.toString().equals("-"))
                            return tokenOperatorMinus();
                    }
                    break;
                case REC_OPERATOR_LESS:
                    if (equalSymbol()) {
                        takeTransition(State.REC_OPERATOR_LESS_EQUAL);
                    } else {
                        return tokenOperatorLessThan();
                    }
                case REC_OPERATOR_LESS_EQUAL:
                    return tokenOperatorLessThanOrEquals();
                case REC_OPERATOR_GREATER:
                    if (equalSymbol()) {
                        takeTransition(State.REC_OPERATOR_GREATER_EQUAL);
                    } else {
                        return tokenOperatorGreaterThan();
                    }
                case REC_OPERATOR_GREATER_EQUAL:
                    return tokenOperatorGreaterThan();
                case REC_OPERATOR_ASSIGNMENT:
                    if (equalSymbol()) {
                        takeTransition(State.REC_OPERATOR_EQUAL);
                    } else {
                        return tokenOperatorAssignment();
                    }
                case REC_OPERATOR_EQUAL:
                    return tokenOperatorEquals();
                case REC_OPERATOR_NOT_EQUAL_PART:
                    if (equalSymbol()) {
                        takeTransition(State.REC_OPERATOR_NOT_EQUAL);
                    } else {
                        error("Expected an =");
                        return null;
                    }
                case REC_OPERATOR_NOT_EQUAL:
                    return tokenOperatorNotEquals();
                case REC_OPERATOR_DIV:
                    return tokenOperatorDiv();
                case REC_OPERATOR_MUL:
                    return tokenOperatorMul();
                case REC_CLOSE_PARENTHESIS:
                    return tokenCloseParenthesis();
                case REC_OPEN_PARENTHESIS:
                    return tokenOpenParenthesis();
                case REC_INTEGER_VAL_0:
                    if (dotSymbol()) {
                        takeTransition(State.REC_INIT_DECIMAL);
                    } else {
                        return tokenInteger();
                    }
                    break;
                case REC_INTEGER:
                    if (digit()) {
                        takeTransition(State.REC_INTEGER);
                    } else if (dotSymbol()) {
                        takeTransition(State.REC_INIT_DECIMAL);
                    } else if (exponential()) {
                        takeTransition(State.REC_EXPONENTIAL_PART);
                    } else {
                        return tokenInteger();
                    }
                    break;
                case REC_INIT_DECIMAL:
                    if (digit()) {
                        takeTransition(State.REC_DECIMAL_PART);
                    } else {
                        error("Expected a sequence of digits");
                        return null;
                    }
                    break;
                case REC_DECIMAL_PART:
                    if (digitButZero()) {
                        takeTransition(State.REC_DECIMAL_PART);
                    } else if (justZero()) {
                        takeTransition(State.REC_ERROR_DECIMAL);
                    } else if (exponential()) {
                        takeTransition(State.REC_EXPONENTIAL_PART);
                    } else {
                        return tokenReal();
                    }
                    break;
                case REC_ERROR_DECIMAL:
                    if (digitButZero()) {
                        takeTransition(State.REC_DECIMAL_PART);
                    } else if (justZero()) {
                        takeTransition(State.REC_ERROR_DECIMAL);
                    } else {
                        error("Expected a digit greater than zero");
                        return null;
                    }
                    break;
                case REC_EXPONENTIAL_PART:
                    if (justZero()) {
                        takeTransition(State.REC_EXPONENTIAL_VAL_0);
                    } else if (signSymbol()) {
                        takeTransition(State.REC_EXPONENTIAL_SIGN);
                    } else if (digitButZero()) {
                        takeTransition(State.REC_EXPONENTIAL);
                    } else {
                        error("Expected a sign or a digit");
                        return null;
                    }
                    break;
                case REC_EXPONENTIAL_SIGN:
                    if (justZero()) {
                        takeTransition(State.REC_EXPONENTIAL_VAL_0);
                    } else if (digitButZero()) {
                        takeTransition(State.REC_EXPONENTIAL);
                    } else {
                        error("Expected a digit >= 0");
                        return null;
                    }
                    break;
                case REC_EXPONENTIAL_VAL_0:
                    return tokenReal();
                case REC_EXPONENTIAL:
                    if (digit()) {
                        takeTransition(State.REC_EXPONENTIAL);
                    } else {
                        return tokenReal();
                    }
                    break;
                case REC_EOD_PART: // &  &
                    if (ampersandSymbol()) {
                        takeTransition(State.REC_EOD);
                    } else {
                        error("Expected an ampersand &");
                        return null;
                    }
                    break;
                case REC_EOI:
                case REC_EOD:
                    return tokenSpecialCharacters();
                case REC_VAR_NAME:
                    if (character() || digit() || underscore()) {
                        takeTransition(State.REC_VAR_NAME);
                    } else {
                        return tokenVarName();
                    }
                    break;
                case REC_EOF:
                    return tokenEOF();
                default:
                    error("??????????????????????????");
                    return null;
            }
        }
    }

    public int getRow() {
        return this.beginningRow;
    }

    public int getColumn() {
        return this.beginningColumn;
    }

    public String getLexeme() {
        return this.lexeme.toString();
    }

    /**
     * Change the transition state and takes the next character
     *
     * @param nextState The next state to transit
     * @return void
     * @throws IOException
     */
    //                 >=
    private void takeTransition(State nextState) throws IOException {
        lexeme.append((char) next);
        nextChar();
        currentState = nextState;
    }

    /**
     * Change the transition state and ignores the next character
     *
     * @param sig The next state to transit
     * @return void
     * @throws IOException
     */
    private void skipChar(State sig) throws IOException {
        nextChar();
        beginningRow = currentRow;
        beginningColumn = currentColumn;
        currentState = sig;
    }

    /**
     * Returns the next character inside the input and modify the column and row values
     *
     * @return void
     * @throws IOException
     */
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

    //No idea, i will deleted soon
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

    private boolean digit() {
        return digitButZero() || justZero();
    }

    private boolean digitButZero() {
        return next >= '1' && next <= '9';
    }

    private boolean justZero() {
        return next == '0';
    }

    private boolean addSymbol() {
        return next == '+';
    }

    private boolean ampersandSymbol() {
        return next == '&';
    }

    private boolean underscore() {
        return next == '_';
    }

    private boolean semicolonSymbol() {
        return next == ';';
    }

    private boolean minusSymbol() {
        return next == '-';
    }

    private boolean signSymbol() {
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

    private boolean exclamationMark() {
        return next == '!';
    }

    private boolean dotSymbol() {
        return next == '.';
    }

    private boolean lessThan() {
        return next == '<';
    }

    private boolean greaterThan() {
        return next == '>';
    }

    private boolean exponential() {
        return next == 'e' || next == 'E';
    }

    private boolean operatorX() {
        return divSymbol() || mulSymbol() || lessThan() || greaterThan();
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

    private LexicalUnit tokenSpecialCharacters() {
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
        switch (lexeme.toString()){
            case "real":
                return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.REAL_TYPE);
            case "int":
                return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.INT_TYPE);
            case "bool":
                return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.BOOL_TYPE);
            case "or":
                return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.LOGICAL_OR);
            case "and":
                return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.LOGICAL_AND);
            case "not":
                return new MonoValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.LOGICAL_NOT);
            default:
                return new MultiValuableLexicalUnit(beginningRow, beginningColumn, LexicalClass.VAR_NAME, lexeme.toString());
        }
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
        System.err.println("(" + currentRow + ',' + currentColumn + "):Unexpected character - ");
        System.exit(1);
    }

    private void error(String msg) {
        System.err.println("(" + currentRow + ',' + currentColumn + "): Unexpected character - " + msg);
        System.exit(1);
    }
}