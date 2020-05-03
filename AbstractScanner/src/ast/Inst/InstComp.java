package ast.Inst;

import ast.E;
import ast.TipoInst;

public class InstComp extends Inst {
	private Inst inst1;
	private Inst inst2;

	public InstComp(Inst inst1, Inst inst2){
		this.inst1 = inst1;
		this.inst2 = inst2;
	}

	public Inst decs() {return this;}
	public TipoInst tipo() {return TipoInst.INSTCOMP;}

	@Override
	public String toString() {
		return String.format("InstComp ( %s, %s )", this.inst1.toString(), this.inst2.toString());
	}
}
