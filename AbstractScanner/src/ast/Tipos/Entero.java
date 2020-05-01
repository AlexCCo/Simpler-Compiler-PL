package ast.Tipos;

import ast.TipoE;

public class Entero extends Tipo {
	public Entero(String v) {
		super(v);   
	}
	
	public TipoE tipo() {return TipoE.ENTERO;}

	@Override
	public String toString() {
		return String.format("[ETipo]numeroEntero { %s }", this.val());
	}
}
