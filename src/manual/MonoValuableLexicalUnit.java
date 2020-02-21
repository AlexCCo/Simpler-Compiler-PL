package manual;

public class MonoValuableLexicalUnit extends LexicalUnit {
    public String lexema() {
        throw new UnsupportedOperationException();
    }

    public MonoValuableLexicalUnit(int row, int column, LexicalClass clase) {
        super(row, column, clase);
    }

    @Override
    public String morpheme() {
        return null;
    }

    public String toString() {
        return "[" + clase().name() + " | (" + row() + ", " + column() + ")]";
    }
}
