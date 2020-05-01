package ast.EBin;

import ast.E;
import ast.TipoE;

public class Suma extends EBin {
   public Suma(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }
   
   public TipoE tipo() {return TipoE.SUMA;}

    @Override
    public String toString() {
        return String.format("[EBin]suma { %s, %s }", this.opnd1().toString(), this.opnd2().toString());
    }
}
