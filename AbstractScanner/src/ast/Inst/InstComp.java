package ast.Inst;

import ast.E;
import ast.TipoInst;

public class InstComp extends Inst {
	private String id;
	private E exp;
	private Inst decs;

	public InstComp(Inst decs, String id, E exp) {
		this.decs = decs;  
		this.id = id;
		this.exp = exp;
	}

	public InstComp(Inst decs, Inst newInst){
		this.decs = decs;
		this.id = newInst.id();
		this.exp = newInst.exp();
	}

	public Inst decs() {return decs;}
	public String id() {return id;}
	public E exp() {return exp;}
	public TipoInst tipo() {return TipoInst.INSTCOMP;}

	@Override
	public String toString() {
		return String.format("inst_compuesta { %s, instruc {%s, %s} }", this.decs.toString(), this.id, this.exp);
	}
}
