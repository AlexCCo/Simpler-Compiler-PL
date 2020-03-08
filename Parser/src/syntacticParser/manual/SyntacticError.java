package syntacticParser.manual;


public class SyntacticError extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public SyntacticError(int row, int column, String expected) {
        super("Expected " + expected + " in row: " + row + " column: " + column);
    }

    public SyntacticError(int row, int column, String expected, String extra){
        super("Expected " + expected + " in row: " + row + " column: " + column + "\n" +
                extra);
    }
}
