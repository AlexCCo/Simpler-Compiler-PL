package ast;

import ast.E;
import ast.TipoE;

public class Id extends E {
  private String id;
  public Id(String id) {
   this.id = id;   
  }
  public String id() {return id;}
  public TipoE tipo() {return TipoE.ID;}

  @Override
  public String toString() {
    return String.format("[ETipo]nombreVariable { %s }", this.id);
  }
}
