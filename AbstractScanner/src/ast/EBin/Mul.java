package ast.EBin;

import ast.E;
import ast.TipoE;

public class Mul extends EBin {
   public Mul(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public TipoE tipo() {return TipoE.MUL;}


    @Override
    public String toString() {
        return String.format("MUL ( %s, %s )", this.opnd1().toString(), this.opnd2().toString());
    }
}
