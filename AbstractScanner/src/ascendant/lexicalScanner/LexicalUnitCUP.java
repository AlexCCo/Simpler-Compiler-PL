package ascendant.lexicalScanner;

import java_cup.runtime.Symbol;

public class LexicalUnitCUP extends Symbol {
    private int row;

    public LexicalUnitCUP(int row, int classType, String lexeme) {
        super(classType,lexeme);
        this.row = row;
    }
    public int clase () {return sym;}
    public String lexema() {return (String)value;}
    public int row() {return row;}
}