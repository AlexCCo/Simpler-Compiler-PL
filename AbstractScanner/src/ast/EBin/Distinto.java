package ast.EBin;

import ast.E;
import ast.TipoE;

public class Distinto extends EBin {
    public Distinto(E opnd1, E opnd2) {
        super(opnd1,opnd2);  
    }     

    public TipoE tipo() {return TipoE.DISTINTO;}
}