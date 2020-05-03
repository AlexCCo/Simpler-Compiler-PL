package ast.Inst;

import ast.E;
import ast.TipoInst;

public class InstSimple extends Inst {
	private String id;
	private E exp;

	public InstSimple(String id, E exp) {
		this.id = id;
		this.exp = exp;
	}

	public String id() {return id;}
	public E exp() {return exp;}
	public TipoInst tipo() {return TipoInst.INSTSIMPLE;}

	@Override
	public String toString() {
		return String.format("instruc { %s, %s }", this.id, this.exp.toString());
	}
}
