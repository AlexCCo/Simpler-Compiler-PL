package ast.Tipos;

import ast.TipoE;

public class Bool extends Tipo {
	public Bool(String v) {
		super(v);   
	}
	
	public TipoE tipo() {return TipoE.BOOL;}

	@Override
	public String toString() {
		return String.format("BOOL { %s }", this.val());
	}
}
