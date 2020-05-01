package ast.EMono;

import ast.E;
import ast.TipoE;

public class Not extends EMono {
    public Not(E exp) {
        super(exp);
    }

    public TipoE tipo() {return TipoE.NOT;}

    @Override
    public String toString() {
        return String.format("[EUnario]logicalNOT { %s }", this.opnd1().toString());
    }
}