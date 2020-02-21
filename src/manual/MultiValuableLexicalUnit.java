package manual;

public class MultiValuableLexicalUnit extends LexicalUnit {
    private String lexema;

    public MultiValuableLexicalUnit(int row, int column, LexicalClass clase, String lexema) {
        super(row, column, clase);
        this.lexema = lexema;
    }

    public String toString() {
        return "[clase:" + clase() + ", lexema:" + morpheme() + " (" + row() + ", " + column() + ")]";
    }

    @Override
    public String morpheme() {
        return null;
    }
}
