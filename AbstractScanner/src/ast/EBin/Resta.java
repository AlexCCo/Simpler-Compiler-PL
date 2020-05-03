package ast.EBin;

import ast.E;
import ast.TipoE;

public class Resta extends EBin {
   public Resta(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public TipoE tipo() {return TipoE.RESTA;}

    @Override
    public String toString() {
        return String.format("SUB ( %s, %s )", this.opnd1().toString(), this.opnd2().toString());
    }
}
