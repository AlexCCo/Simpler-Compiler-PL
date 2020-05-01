package ast.EBin;

import ast.E;
import ast.TipoE;

public class MayorIgual extends EBin {
    public MayorIgual(E opnd1, E opnd2) {
        super(opnd1,opnd2);  
    }     

    public TipoE tipo() {return TipoE.MAYORIG;}

    @Override
    public String toString() {
        return String.format("[EBin]>= { %s, %s }", this.opnd1().toString(), this.opnd2().toString());
    }
}