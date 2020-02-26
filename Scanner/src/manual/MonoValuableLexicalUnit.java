package manual;

/**
 * Alumnos:
 *          Tomás Golomb Durán
 *          Alejandro Cancelo Correia
 *
 * Token monovaluable
 */

public class MonoValuableLexicalUnit extends LexicalUnit {

    public MonoValuableLexicalUnit(int row, int column, LexicalClass clase) {
        super(row, column, clase);
    }

    @Override
    public String toString() {
        return "[" + clase().name() + " | (" + row() + ", " + column() + ")]";
    }
}
