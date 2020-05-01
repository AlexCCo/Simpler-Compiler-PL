package ast.EMono;

import ast.TipoE;
import ast.E;

public class Negativo extends EMono {
    public Negativo(E exp) {
        super(exp);
    }

    public TipoE tipo() {return TipoE.NEGATIVO;}

    @Override
    public String toString() {
        return String.format("[EUnario]negativo { %s }", this.opnd1().toString());
    }
}