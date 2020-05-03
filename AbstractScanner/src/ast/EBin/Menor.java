package ast.EBin;

import ast.E;
import ast.TipoE;

public class Menor extends EBin {
    public Menor(E opnd1, E opnd2) {
        super(opnd1,opnd2);  
    }     

    public TipoE tipo() {return TipoE.MENOR;}

    @Override
    public String toString() {
        return String.format("< ( %s, %s )", this.opnd1().toString(), this.opnd2().toString());
    }
}