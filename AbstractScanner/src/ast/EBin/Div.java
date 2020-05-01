package ast.EBin;

import ast.E;
import ast.TipoE;

public class Div extends EBin {
   public Div(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public TipoE tipo() {return TipoE.DIV;}

    @Override
    public String toString() {
        return String.format("[EBin]div { %s, %s }", this.opnd1().toString(), this.opnd2().toString());
    }
}
