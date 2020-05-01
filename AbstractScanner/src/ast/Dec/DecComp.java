package ast.Dec;

import ast.TipoDec;

public class DecComp extends Dec {
	private Dec decs;

	public DecComp(Dec decs, String id, String valor) {
		super(id, valor);
		this.decs = decs;
	}

	public DecComp(Dec decs, Dec newDec) {
		super(newDec.id(), newDec.valor());
		this.decs = decs;
	}

	public Dec decs() {return decs;}
	public TipoDec tipo() {return TipoDec.DECCOMPUESTA;}

	@Override
	public String toString() {
		return String.format("dec_compuesta { {%s, %s}, %s }", this.id(), this.valor(), this.decs.toString());
	}
}
