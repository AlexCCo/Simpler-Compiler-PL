package ast.Dec;

import ast.TipoDec;

public class DecSimple extends Dec {
	public DecSimple(String id, String valor) {
		super(id, valor);
	}

	public TipoDec tipo() {return TipoDec.DECSIMPLE;} 
}
