package auto;

/**
 * Alumnos:
 *          Tomás Golomb Durán
 *          Alejandro Cancelo Correia
 *
 * Token multivaluable
 */

public class MultiValuableLexicalUnit extends LexicalUnit {
    private String lexema;

    public MultiValuableLexicalUnit(int row, int column, LexicalClass clase, String lexema) {
        super(row, column, clase);
        this.lexema = lexema;
    }

    @Override
    public String toString() {
        return "[" + clase() + " | " + lexema + " | (" + row() + ", " + column() + ")]";
    }
}
