package ast.Dec;

import ast.TipoDec;

public class DecSimple extends Dec {
	public DecSimple(String id, String valor) {
		super(id, valor);
	}

	public TipoDec tipo() {return TipoDec.DECSIMPLE;}

	@Override
	public String toString() {
		return String.format("decl { %s, %s }", this.id(), this.valor());
	}
}
