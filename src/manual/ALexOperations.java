package src.manual;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexicaMultivaluada(alex.fila(),LexicalClass.IDEN,
                                         alex.lexema()); 
  } 
  public UnidadLexica unidadEvalua() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.EVALUA);
  } 
  public UnidadLexica unidadDonde() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.DONDE);
  } 
  public UnidadLexica unidadEnt() {
     return new UnidadLexicaMultivaluada(alex.fila(),LexicalClass.ENT,alex.lexema());
  } 
  public UnidadLexica unidadReal() {
     return new UnidadLexicaMultivaluada(alex.fila(),LexicalClass.REAL,alex.lexema());
  } 
  public UnidadLexica unidadSuma() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.MAS);
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.MENOS);
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.POR);
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.DIV);
  } 
  public UnidadLexica unidadPAp() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.PAP);
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.PCIERRE);
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.IGUAL);
  } 
  public UnidadLexica unidadComa() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.COMA);
  } 
  public UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(alex.fila(),LexicalClass.EOF);
  }
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }
}
