package ast.Tipos;

import ast.E;

public abstract class Tipo extends E {
	private String v;

	public Tipo(String v) {
		this.v = v;   
	}

	public String val() {return v;}
}
