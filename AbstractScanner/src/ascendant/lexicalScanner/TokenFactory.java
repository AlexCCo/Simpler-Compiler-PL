package ascendant.lexicalScanner;

/**
 * Students:
 *          Tomás Golomb Durán
 *          Alejandro Cancelo Correia
 */

public class TokenFactory {
    private LexicalScanner lexicalScanner;

    public TokenFactory(LexicalScanner lexicalScanner) {
        this.lexicalScanner = lexicalScanner;
    }

    public LexicalUnit tokenSpecialCharacters() {
        switch (lexicalScanner.getLexeme()) {
            case ";":
                return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.EOI);
            case "&&":
                return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.EOD);
            default:
                lexicalScanner.error();
                return null;
        }
    }

    public LexicalUnit tokenOperatorAdd() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_ADD);
    }

    public LexicalUnit tokenOperatorMinus() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_MINUS);
    }

    public LexicalUnit tokenOperatorMul() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_MUL);
    }

    public LexicalUnit tokenOperatorDiv() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_DIV);
    }

    public LexicalUnit tokenOperatorLessThan() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_LESS_THAN);
    }

    public LexicalUnit tokenOperatorLessThanOrEquals() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_LESS_EQUAL_THAN);
    }

    public LexicalUnit tokenOperatorGreaterThan() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_GREATER_THAN);
    }

    public LexicalUnit tokenOperatorGreaterThanOrEquals() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_GREATER_EQUAL_THAN);
    }

    public LexicalUnit tokenOperatorEquals() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_EQUAL);
    }

    public LexicalUnit tokenOperatorNotEquals() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_NOT_EQUAL);
    }

    public LexicalUnit tokenOperatorAssignment() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPERATOR_ASSIGNMENT);
    }

    public LexicalUnit tokenVarName() {
        switch (lexicalScanner.getLexeme()){
            case "real":
                return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.REAL_TYPE);
            case "int":
                return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.INT_TYPE);
            case "bool":
                return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.BOOL_TYPE);
            case "or":
                return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.LOGICAL_OR);
            case "and":
                return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.LOGICAL_AND);
            case "not":
                return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.LOGICAL_NOT);
            case "true":
            case "false":
                return new MultiValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.BOOLEAN, lexicalScanner.getLexeme());
            default:
                return new MultiValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.VAR_NAME, lexicalScanner.getLexeme());
        }
    }

    public LexicalUnit tokenInteger() {
        return new MultiValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.INTEGER_NUM, lexicalScanner.getLexeme());
    }

    public LexicalUnit tokenReal() {
        return new MultiValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.REAL_NUM, lexicalScanner.getLexeme());
    }

    public LexicalUnit tokenOpenParenthesis() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.OPEN_PARENTHESIS);
    }

    public LexicalUnit tokenCloseParenthesis() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.CLOSE_PARENTHESIS);
    }

    public LexicalUnit tokenEOF() {
        return new MonoValuableLexicalUnit(lexicalScanner.getRow(), lexicalScanner.getColumn(), LexicalClass.EOF);
    }
}
