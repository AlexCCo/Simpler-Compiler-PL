package ast.Dec;

import ast.TipoDec;

public class DecSimple extends Dec {
	private String id;
	private String valor;

	public DecSimple(String id, String valor) {
		this.id = id;
		this.valor = valor;
	}

	public TipoDec tipo() {return TipoDec.DECSIMPLE;}

	@Override
	public String toString() {
		return String.format("DecSimple ( %s, %s )", this.id, this.valor);
	}
}
