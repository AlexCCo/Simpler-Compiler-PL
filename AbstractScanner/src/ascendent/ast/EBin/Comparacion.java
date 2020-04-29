package ast.EBin;

import ast.E;
import ast.TipoE;

public class Comparacion extends EBin {
    public Comparacion(E opnd1, E opnd2) {
        super(opnd1,opnd2);  
    }     

    public TipoE tipo() {return TipoE.COMPARACION;}
}