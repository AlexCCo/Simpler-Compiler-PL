package ast.EBin;

import ast.E;
import ast.TipoE;

public class Or extends EBin {
    public Or(E opnd1, E opnd2) {
        super(opnd1,opnd2);  
    }     

    public TipoE tipo() {return TipoE.OR;}
}