package ast.Tipos;

import ast.TipoE;

public class Real extends Tipo {
	public Real(String v) {
		super(v);  
	}

	public TipoE tipo() {return TipoE.REAL;}    
}
