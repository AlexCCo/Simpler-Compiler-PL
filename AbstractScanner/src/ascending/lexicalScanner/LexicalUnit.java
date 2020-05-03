package ascending.lexicalScanner;

import java_cup.runtime.Symbol;

/**
 * Students:
 *          Tomás Golomb Durán
 *          Alejandro Cancelo Correia
 *
 * Basic structure of a token
 */

public abstract class LexicalUnit{
    private LexicalClass clase;
    private int row;
    private int column;

    public LexicalUnit(int row, int column, LexicalClass clase) {
        this.row = row;
        this.column = column;
        this.clase = clase;
    }

    public LexicalClass clase() {
        return clase;
    }

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }
}
