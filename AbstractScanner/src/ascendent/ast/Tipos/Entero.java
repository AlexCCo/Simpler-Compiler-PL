package ast.Tipos;

import ast.TipoE;

public class Entero extends Tipo {
	public Entero(String v) {
		super(v);   
	}
	
	public TipoE tipo() {return TipoE.ENTERO;}    
}
