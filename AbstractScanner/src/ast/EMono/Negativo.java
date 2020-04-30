package ast.EMono;

import ast.TipoE;
import ast.E;

public class Negativo extends EMono {
    public Negativo(E exp) {
        super(exp);
    }

    public TipoE tipo() {return TipoE.NEGATIVO;}  
}