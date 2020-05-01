package ascendant.lexicalScanner;

import ascendant.syntacticParser.auto.ascendentVersion.LexicalClass;
/**
 * Students:
 *          Tomás Golomb Durán
 *          Alejandro Cancelo Correia
 */

public class TokenFactoryCUP {
    private LexicalScannerCUP lexicalScanner;

    public TokenFactoryCUP(LexicalScannerCUP lexicalScanner) {
        this.lexicalScanner = lexicalScanner;
    }

    public LexicalUnitCUP tokenSpecialCharacters() {
        switch (lexicalScanner.getLexeme()) {
            case ";":
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.EOI, LexicalClass.valueOf(LexicalClass.EOI));
            case "&&":
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.EOD, LexicalClass.valueOf(LexicalClass.EOD));
            default:
                lexicalScanner.error();
                return null;
        }
    }

    public LexicalUnitCUP tokenOperatorAdd() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_ADD, LexicalClass.valueOf(LexicalClass.OPERATOR_ADD));
    }

    public LexicalUnitCUP tokenOperatorMinus() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_MINUS, LexicalClass.valueOf(LexicalClass.OPERATOR_MINUS));
    }

    public LexicalUnitCUP tokenOperatorMul() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_MUL, LexicalClass.valueOf(LexicalClass.OPERATOR_MUL));
    }

    public LexicalUnitCUP tokenOperatorDiv() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_DIV, LexicalClass.valueOf(LexicalClass.OPERATOR_DIV));
    }

    public LexicalUnitCUP tokenOperatorLessThan() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_LESS_THAN, LexicalClass.valueOf(LexicalClass.OPERATOR_LESS_THAN));
    }

    public LexicalUnitCUP tokenOperatorLessThanOrEquals() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_LESS_EQUAL_THAN, LexicalClass.valueOf(LexicalClass.OPERATOR_LESS_EQUAL_THAN));
    }

    public LexicalUnitCUP tokenOperatorGreaterThan() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_GREATER_THAN, LexicalClass.valueOf(LexicalClass.OPERATOR_GREATER_THAN));
    }

    public LexicalUnitCUP tokenOperatorGreaterThanOrEquals() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_GREATER_EQUAL_THAN, LexicalClass.valueOf(LexicalClass.OPERATOR_GREATER_EQUAL_THAN));
    }

    public LexicalUnitCUP tokenOperatorEquals() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_EQUAL, LexicalClass.valueOf(LexicalClass.OPERATOR_EQUAL));
    }

    public LexicalUnitCUP tokenOperatorNotEquals() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_NOT_EQUAL, LexicalClass.valueOf(LexicalClass.OPERATOR_NOT_EQUAL));
    }

    public LexicalUnitCUP tokenOperatorAssignment() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPERATOR_ASSIGNMENT, LexicalClass.valueOf(LexicalClass.OPERATOR_ASSIGNMENT));
    }

    public LexicalUnitCUP tokenVarName() {
        switch (lexicalScanner.getLexeme()){
            case "real":
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.REAL_TYPE, LexicalClass.valueOf(LexicalClass.REAL_TYPE));
            case "int":
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.INT_TYPE, LexicalClass.valueOf(LexicalClass.INT_TYPE));
            case "bool":
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.BOOL_TYPE, LexicalClass.valueOf(LexicalClass.BOOL_TYPE));
            case "or":
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.LOGICAL_OR, LexicalClass.valueOf(LexicalClass.LOGICAL_OR));
            case "and":
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.LOGICAL_AND, LexicalClass.valueOf(LexicalClass.LOGICAL_AND));
            case "not":
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.LOGICAL_NOT, LexicalClass.valueOf(LexicalClass.LOGICAL_NOT));
            case "true":
            case "false":
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.BOOLEAN,  lexicalScanner.getLexeme());
            default:
                return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.VAR_NAME, lexicalScanner.getLexeme());
        }
    }

    public LexicalUnitCUP tokenInteger() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.INTEGER_NUM,  lexicalScanner.getLexeme());
    }

    public LexicalUnitCUP tokenReal() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.REAL_NUM,  lexicalScanner.getLexeme());
    }

    public LexicalUnitCUP tokenOpenParenthesis() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.OPEN_PARENTHESIS, LexicalClass.valueOf(LexicalClass.OPEN_PARENTHESIS));
    }

    public LexicalUnitCUP tokenCloseParenthesis() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.CLOSE_PARENTHESIS, LexicalClass.valueOf(LexicalClass.CLOSE_PARENTHESIS));
    }

    public LexicalUnitCUP tokenEOF() {
        return new LexicalUnitCUP(lexicalScanner.getRow(), LexicalClass.EOF, LexicalClass.valueOf(LexicalClass.EOF));
    }
}
