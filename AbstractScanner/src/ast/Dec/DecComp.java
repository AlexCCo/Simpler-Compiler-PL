package ast.Dec;

import ast.TipoDec;

public class DecComp extends Dec {
	private Dec dec1;
	private Dec dec2;

	public DecComp(Dec dec1, Dec dec2) {
		this.dec1 = dec1;
		this.dec2 = dec2;
	}

	public Dec decs() {return this;}
	public TipoDec tipo() {return TipoDec.DECCOMPUESTA;}

	@Override
	public String toString() {
		return String.format("DecComp( %s, %s )", this.dec1, this.dec2.toString());
	}
}
