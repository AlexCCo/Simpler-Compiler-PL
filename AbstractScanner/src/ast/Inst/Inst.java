package ast.Inst;

import ast.E;
import ast.TipoInst;

public abstract class Inst {
	public abstract TipoInst tipo();
	public Inst inst() {throw new UnsupportedOperationException("inst");} 
	public String id() {throw new UnsupportedOperationException("id");}           
	public E exp() {throw new UnsupportedOperationException("exp");}  
}
