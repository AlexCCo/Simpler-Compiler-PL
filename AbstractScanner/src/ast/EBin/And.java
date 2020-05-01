package ast.EBin;

import ast.E;
import ast.TipoE;

public class And extends EBin {
    public And(E opnd1, E opnd2) {
        super(opnd1,opnd2);  
    }     

    public TipoE tipo() {return TipoE.AND;}

    @Override
    public String toString() {
        return String.format("[EBin]logicalAND { %s, %s }", this.opnd1().toString(), this.opnd2().toString());
    }
}