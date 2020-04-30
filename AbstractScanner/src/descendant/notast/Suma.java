package descendant.notast;

import ast.E;
import ast.EBin.EBin;
import ast.TipoE;

public class Suma extends EBin {
   public Suma(E opnd1, E opnd2) {
     super(opnd1,opnd2);  
   }     
   public TipoE tipo() {return TipoE.SUMA;}
}
