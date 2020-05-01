package ast.Dec;

import ast.TipoDec;

public abstract class Dec {
	private String id;
	private String valor;

	public Dec(String id, String valor) {
		this.id = id;
		this.valor = valor;
	}

	public String id() {return id;}
	public String valor() {return valor;}
	public Dec decs() {throw new UnsupportedOperationException("decs");}
	public abstract TipoDec tipo();

}
