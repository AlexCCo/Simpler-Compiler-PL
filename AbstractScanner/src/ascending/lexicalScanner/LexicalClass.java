package ascendant.lexicalScanner;

/**
 * Students:
 *          Tomás Golomb Durán
 *          Alejandro Cancelo Correia
 */

public enum LexicalClass {
    OPERATOR_ADD,
    OPERATOR_MINUS,
    OPERATOR_DIV,
    OPERATOR_MUL,
    OPERATOR_LESS_THAN,
    OPERATOR_LESS_EQUAL_THAN,
    OPERATOR_GREATER_THAN,
    OPERATOR_GREATER_EQUAL_THAN,
    OPERATOR_EQUAL,
    OPERATOR_NOT_EQUAL,
    OPERATOR_ASSIGNMENT,
    LOGICAL_OR,
    LOGICAL_AND,
    LOGICAL_NOT,
    INTEGER_NUM,
    REAL_NUM,
    VAR_NAME,
    REAL_TYPE,
    INT_TYPE,
    BOOL_TYPE,
    BOOLEAN,
    EOI,
    EOD,
    OPEN_PARENTHESIS,
    CLOSE_PARENTHESIS,
    EOF;

    public static String valueOf(LexicalClass enumValue) {
        String returnValue = null;
        switch (enumValue) {
            case OPERATOR_ADD:
                returnValue = "+";
                break;
            case OPERATOR_MINUS:
                returnValue = "-";
                break;
            case OPERATOR_DIV:
                returnValue = "/";
                break;
            case OPERATOR_MUL:
                returnValue = "*";
                break;
            case OPERATOR_LESS_THAN:
                returnValue = "<";
                break;
            case OPERATOR_LESS_EQUAL_THAN:
                returnValue = "<=";
                break;
            case OPERATOR_GREATER_THAN:
                returnValue = ">";
                break;
            case OPERATOR_GREATER_EQUAL_THAN:
                returnValue = ">=";
                break;
            case OPERATOR_EQUAL:
                returnValue = "==";
                break;
            case OPERATOR_NOT_EQUAL:
                returnValue = "!=";
                break;
            case OPERATOR_ASSIGNMENT:
                returnValue = "==";
                break;
            case LOGICAL_OR:
                returnValue = "or";
                break;
            case LOGICAL_AND:
                returnValue = "and";
                break;
            case LOGICAL_NOT:
                returnValue = "not";
                break;
            case INTEGER_NUM:
                returnValue = "int number";
                break;
            case REAL_NUM:
                returnValue = "real number";
                break;
            case VAR_NAME:
                returnValue = "variable name";
                break;
            case REAL_TYPE:
                returnValue = "real type";
                break;
            case INT_TYPE:
                returnValue = "int type";
                break;
            case BOOL_TYPE:
                returnValue = "bool type";
                break;
            case BOOLEAN:
                returnValue = "bool value";
                break;
            case EOI:
                returnValue = ";";
                break;
            case EOD:
                returnValue = "&&";
                break;
            case OPEN_PARENTHESIS:
                returnValue = "(";
                break;
            case CLOSE_PARENTHESIS:
                returnValue = ")";
                break;
            case EOF:
                returnValue = "EOF";
                break;
        }
        return returnValue;
    }
}
