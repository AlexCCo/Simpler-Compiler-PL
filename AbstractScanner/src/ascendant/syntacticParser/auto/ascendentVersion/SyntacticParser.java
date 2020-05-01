
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140220
// Fri May 01 02:40:16 CEST 2020
//----------------------------------------------------

package ascendant.syntacticParser.auto.ascendentVersion;

import java_cup.runtime.*;
import ascendant.lexicalScanner.*;
import ast.*;
import ast.Dec.*;
import ast.Inst.*;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b beta 20140220 generated parser.
  * @version Fri May 01 02:40:16 CEST 2020
  */
public class SyntacticParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public SyntacticParser() {super();}

  /** Constructor which sets the default scanner. */
  public SyntacticParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SyntacticParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\044\000\002\002\005\000\002\002\004\000\002\003" +
    "\005\000\002\003\003\000\002\004\004\000\002\004\004" +
    "\000\002\004\004\000\002\005\005\000\002\005\003\000" +
    "\002\006\005\000\002\007\005\000\002\007\005\000\002" +
    "\007\003\000\002\010\005\000\002\010\003\000\002\014" +
    "\003\000\002\014\003\000\002\011\005\000\002\011\003" +
    "\000\002\015\003\000\002\015\003\000\002\015\003\000" +
    "\002\015\003\000\002\015\003\000\002\015\003\000\002" +
    "\012\005\000\002\012\003\000\002\016\003\000\002\016" +
    "\003\000\002\013\004\000\002\017\003\000\002\013\003" +
    "\000\002\013\003\000\002\013\003\000\002\013\003\000" +
    "\002\013\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\010\032\005\033\010\034\007\001\002\000" +
    "\006\022\ufffe\023\ufffe\001\002\000\004\026\071\001\002" +
    "\000\004\002\070\001\002\000\004\026\067\001\002\000" +
    "\004\026\066\001\002\000\006\022\013\023\012\001\002" +
    "\000\004\026\017\001\002\000\010\032\005\033\010\034" +
    "\007\001\002\000\006\022\uffff\023\uffff\001\002\000\006" +
    "\002\ufff9\022\ufff9\001\002\000\006\002\001\022\064\001" +
    "\002\000\004\016\020\001\002\000\016\021\033\024\034" +
    "\026\024\027\025\030\022\031\023\001\002\000\016\021" +
    "\033\024\034\026\024\027\025\030\022\031\023\001\002" +
    "\000\040\002\uffdf\004\uffdf\005\uffdf\006\uffdf\007\uffdf\010" +
    "\uffdf\011\uffdf\012\uffdf\013\uffdf\014\uffdf\015\uffdf\017\uffdf" +
    "\020\uffdf\022\uffdf\025\uffdf\001\002\000\040\002\uffe1\004" +
    "\uffe1\005\uffe1\006\uffe1\007\uffe1\010\uffe1\011\uffe1\012\uffe1" +
    "\013\uffe1\014\uffe1\015\uffe1\017\uffe1\020\uffe1\022\uffe1\025" +
    "\uffe1\001\002\000\040\002\uffe2\004\uffe2\005\uffe2\006\uffe2" +
    "\007\uffe2\010\uffe2\011\uffe2\012\uffe2\013\uffe2\014\uffe2\015" +
    "\uffe2\017\uffe2\020\uffe2\022\uffe2\025\uffe2\001\002\000\040" +
    "\002\uffe0\004\uffe0\005\uffe0\006\uffe0\007\uffe0\010\uffe0\011" +
    "\uffe0\012\uffe0\013\uffe0\014\uffe0\015\uffe0\017\uffe0\020\uffe0" +
    "\022\uffe0\025\uffe0\001\002\000\040\002\uffe7\004\uffe7\005" +
    "\uffe7\006\060\007\057\010\uffe7\011\uffe7\012\uffe7\013\uffe7" +
    "\014\uffe7\015\uffe7\017\uffe7\020\uffe7\022\uffe7\025\uffe7\001" +
    "\002\000\034\002\uffef\004\uffef\005\uffef\010\uffef\011\uffef" +
    "\012\uffef\013\uffef\014\uffef\015\uffef\017\uffef\020\uffef\022" +
    "\uffef\025\uffef\001\002\000\034\002\ufff3\004\ufff3\005\ufff3" +
    "\010\053\011\047\012\054\013\052\014\050\015\051\017" +
    "\ufff3\020\ufff3\022\ufff3\025\ufff3\001\002\000\020\002\ufff5" +
    "\004\043\005\041\017\040\020\042\022\ufff5\025\ufff5\001" +
    "\002\000\006\002\ufff8\022\ufff8\001\002\000\016\021\uffe3" +
    "\024\uffe3\026\uffe3\027\uffe3\030\uffe3\031\uffe3\001\002\000" +
    "\016\021\033\024\034\026\024\027\025\030\022\031\023" +
    "\001\002\000\004\025\036\001\002\000\040\002\uffde\004" +
    "\uffde\005\uffde\006\uffde\007\uffde\010\uffde\011\uffde\012\uffde" +
    "\013\uffde\014\uffde\015\uffde\017\uffde\020\uffde\022\uffde\025" +
    "\uffde\001\002\000\016\021\033\024\034\026\024\027\025" +
    "\030\022\031\023\001\002\000\016\021\ufff1\024\ufff1\026" +
    "\ufff1\027\ufff1\030\ufff1\031\ufff1\001\002\000\016\021\033" +
    "\024\034\026\024\027\025\030\022\031\023\001\002\000" +
    "\016\021\ufff2\024\ufff2\026\ufff2\027\ufff2\030\ufff2\031\ufff2" +
    "\001\002\000\016\021\033\024\034\026\024\027\025\030" +
    "\022\031\023\001\002\000\010\002\ufff7\022\ufff7\025\ufff7" +
    "\001\002\000\014\002\ufff6\017\040\020\042\022\ufff6\025" +
    "\ufff6\001\002\000\034\002\ufff4\004\ufff4\005\ufff4\010\053" +
    "\011\047\012\054\013\052\014\050\015\051\017\ufff4\020" +
    "\ufff4\022\ufff4\025\ufff4\001\002\000\016\021\uffed\024\uffed" +
    "\026\uffed\027\uffed\030\uffed\031\uffed\001\002\000\016\021" +
    "\uffea\024\uffea\026\uffea\027\uffea\030\uffea\031\uffea\001\002" +
    "\000\016\021\uffe9\024\uffe9\026\uffe9\027\uffe9\030\uffe9\031" +
    "\uffe9\001\002\000\016\021\uffeb\024\uffeb\026\uffeb\027\uffeb" +
    "\030\uffeb\031\uffeb\001\002\000\016\021\uffee\024\uffee\026" +
    "\uffee\027\uffee\030\uffee\031\uffee\001\002\000\016\021\uffec" +
    "\024\uffec\026\uffec\027\uffec\030\uffec\031\uffec\001\002\000" +
    "\016\021\033\024\034\026\024\027\025\030\022\031\023" +
    "\001\002\000\034\002\ufff0\004\ufff0\005\ufff0\010\ufff0\011" +
    "\ufff0\012\ufff0\013\ufff0\014\ufff0\015\ufff0\017\ufff0\020\ufff0" +
    "\022\ufff0\025\ufff0\001\002\000\016\021\uffe5\024\uffe5\026" +
    "\uffe5\027\uffe5\030\uffe5\031\uffe5\001\002\000\016\021\uffe6" +
    "\024\uffe6\026\uffe6\027\uffe6\030\uffe6\031\uffe6\001\002\000" +
    "\016\021\033\024\034\026\024\027\025\030\022\031\023" +
    "\001\002\000\034\002\uffe8\004\uffe8\005\uffe8\010\uffe8\011" +
    "\uffe8\012\uffe8\013\uffe8\014\uffe8\015\uffe8\017\uffe8\020\uffe8" +
    "\022\uffe8\025\uffe8\001\002\000\040\002\uffe4\004\uffe4\005" +
    "\uffe4\006\uffe4\007\uffe4\010\uffe4\011\uffe4\012\uffe4\013\uffe4" +
    "\014\uffe4\015\uffe4\017\uffe4\020\uffe4\022\uffe4\025\uffe4\001" +
    "\002\000\004\026\017\001\002\000\006\002\ufffa\022\ufffa" +
    "\001\002\000\006\022\ufffd\023\ufffd\001\002\000\006\022" +
    "\ufffc\023\ufffc\001\002\000\004\002\000\001\002\000\006" +
    "\022\ufffb\023\ufffb\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\010\002\005\003\010\004\003\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\005" +
    "\015\006\014\001\001\000\004\004\013\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\016\007\031\010\030\011\027\012\026\013\025" +
    "\017\020\001\001\000\006\013\062\017\020\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\016\060\001\001\000\002\001\001\000" +
    "\004\015\054\001\001\000\004\014\036\001\001\000\002" +
    "\001\001\000\002\001\001\000\016\007\034\010\030\011" +
    "\027\012\026\013\025\017\020\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\011\045\012\026\013\025\017" +
    "\020\001\001\000\002\001\001\000\014\010\044\011\027" +
    "\012\026\013\025\017\020\001\001\000\002\001\001\000" +
    "\016\007\043\010\030\011\027\012\026\013\025\017\020" +
    "\001\001\000\002\001\001\000\004\014\036\001\001\000" +
    "\004\015\054\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\012\055\013\025\017\020\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\013\061\017\020\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\006\064\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SyntacticParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SyntacticParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SyntacticParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {

   LexicalScannerCUP alex = (LexicalScannerCUP)getScanner();

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return getScanner().next_token(); 
    }


   public void syntax_error(Symbol unidadLexica){
     System.out.println("ERROR fila "+((LexicalUnitCUP)unidadLexica).row()+": Elemento inexperado "+unidadLexica.value);
     System.exit(1);
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$SyntacticParser$actions {


    private ASConstructor semantic = new ASConstructor();

  private final SyntacticParser parser;

  /** Constructor */
  CUP$SyntacticParser$actions(SyntacticParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$SyntacticParser$do_action_part00000000(
    int                        CUP$SyntacticParser$act_num,
    java_cup.runtime.lr_parser CUP$SyntacticParser$parser,
    java.util.Stack            CUP$SyntacticParser$stack,
    int                        CUP$SyntacticParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SyntacticParser$result;

      /* select the action based on the action number */
      switch (CUP$SyntacticParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // S ::= SD EOD IS 
            {
              Program RESULT =null;
		Dec aDeSD = (Dec)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-2)).value;
		Inst aDeIS = (Inst)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.prog_completo(aDeSD, aDeIS); System.out.println(RESULT.toString());
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("S",0, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= S EOF 
            {
              Object RESULT =null;
		Program start_val = (Program)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-1)).value;
		RESULT = start_val;
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$SyntacticParser$parser.done_parsing();
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // SD ::= SD EOI VAR 
            {
              Dec RESULT =null;
		Dec aDeSD = (Dec)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-2)).value;
		Dec aDeVAR = (Dec)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.decs_compuesta(aDeSD, aDeVAR); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("SD",1, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // SD ::= VAR 
            {
              Dec RESULT =null;
		Dec aDeVAR = (Dec)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = aDeVAR; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("SD",1, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // VAR ::= INT_TYPE VAR_NAME 
            {
              Dec RESULT =null;
		String aDeTYPE = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-1)).value;
		String aDeVAR_NAME = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.decl(aDeTYPE, aDeVAR_NAME); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("VAR",2, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // VAR ::= BOOL_TYPE VAR_NAME 
            {
              Dec RESULT =null;
		String aDeTYPE = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-1)).value;
		String aDeVAR_NAME = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.decl(aDeTYPE, aDeVAR_NAME); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("VAR",2, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // VAR ::= REAL_TYPE VAR_NAME 
            {
              Dec RESULT =null;
		String aDeTYPE = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-1)).value;
		String aDeVAR_NAME = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.decl(aDeTYPE, aDeVAR_NAME); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("VAR",2, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // IS ::= IS EOI INST 
            {
              Inst RESULT =null;
		Inst aDeIS = (Inst)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-2)).value;
		Inst aDeINST = (Inst)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.inst_compuesta(aDeIS, aDeINST); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("IS",3, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // IS ::= INST 
            {
              Inst RESULT =null;
		Inst aDeINST = (Inst)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = aDeINST; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("IS",3, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // INST ::= VAR_NAME OPERATOR_ASSIGNMENT E0 
            {
              Inst RESULT =null;
		String aDeVarName = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-2)).value;
		E aDeE0 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.instruc(aDeVarName, aDeE0); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("INST",4, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // E0 ::= E1 OPERATOR_ADD E0 
            {
              E RESULT =null;
		E aDeE1Uno = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-2)).value;
		E aDeE0 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		RESULT = semantic.suma(aDeE1Uno, aDeE0); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E0",5, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // E0 ::= E1 OPERATOR_MINUS E1 
            {
              E RESULT =null;
		E aDeE1Uno = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-2)).value;
		E aDeE1Dos = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		RESULT = semantic.resta(aDeE1Uno, aDeE1Dos); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E0",5, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // E0 ::= E1 
            {
              E RESULT =null;
		E aDeE1 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		RESULT = aDeE1; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E0",5, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // E1 ::= E1 opE1 E2 
            {
              E RESULT =null;
		E aDeE1 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-2)).value;
		TipoE opTipo = (TipoE)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-1)).value;
		E aDeE2 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.exp(opTipo, aDeE1, aDeE2); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E1",6, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // E1 ::= E2 
            {
              E RESULT =null;
		E aDeE2 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		RESULT = aDeE2; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E1",6, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // opE1 ::= LOGICAL_AND 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.AND; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE1",10, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // opE1 ::= LOGICAL_OR 
            {
              TipoE RESULT =null;
		Object aDeOpTipo = (Object)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = TipoE.OR; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE1",10, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // E2 ::= E2 opE2 E3 
            {
              E RESULT =null;
		E aDeE2 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-2)).value;
		TipoE opTipo = (TipoE)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-1)).value;
		E aDeE3 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.exp(opTipo, aDeE2, aDeE3); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E2",7, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // E2 ::= E3 
            {
              E RESULT =null;
		E aDeE3 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = aDeE3; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E2",7, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // opE2 ::= OPERATOR_LESS_THAN 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.MENOR; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE2",11, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // opE2 ::= OPERATOR_LESS_EQUAL_THAN 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.MENORIG; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE2",11, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // opE2 ::= OPERATOR_GREATER_THAN 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.MAYOR; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE2",11, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // opE2 ::= OPERATOR_GREATER_EQUAL_THAN 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.MAYORIG; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE2",11, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // opE2 ::= OPERATOR_EQUAL 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.COMPARACION; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE2",11, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // opE2 ::= OPERATOR_NOT_EQUAL 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.DISTINTO; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE2",11, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // E3 ::= E4 opE3 E4 
            {
              E RESULT =null;
		E aDeE4Uno = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-2)).value;
		TipoE opTipo = (TipoE)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-1)).value;
		E aDeE4Dos = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.exp(opTipo, aDeE4Uno, aDeE4Dos); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E3",8, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // E3 ::= E4 
            {
              E RESULT =null;
		E aDeE4 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = aDeE4; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E3",8, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // opE3 ::= OPERATOR_DIV 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.DIV; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE3",12, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // opE3 ::= OPERATOR_MUL 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.MUL; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE3",12, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // E4 ::= opE4 E4 
            {
              E RESULT =null;
		TipoE opTipo = (TipoE)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-1)).value;
		E aDeE4 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.exp(opTipo, aDeE4); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // opE4 ::= LOGICAL_NOT 
            {
              TipoE RESULT =null;
		 RESULT = TipoE.NOT; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("opE4",13, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // E4 ::= VAR_NAME 
            {
              E RESULT =null;
		String aDeVar = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.varName(aDeVar); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // E4 ::= BOOLEAN 
            {
              E RESULT =null;
		String aDeBoo = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.booleano(aDeBoo); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // E4 ::= INTEGER_NUM 
            {
              E RESULT =null;
		String aDeNE = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		RESULT = semantic.numEntero(aDeNE); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // E4 ::= REAL_NUM 
            {
              E RESULT =null;
		String aDeNR = (String)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.peek()).value;
		 RESULT = semantic.numReal(aDeNR); 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$SyntacticParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // E4 ::= OPEN_PARENTHESIS E0 CLOSE_PARENTHESIS 
            {
              E RESULT =null;
		E aDeE0 = (E)((java_cup.runtime.Symbol) CUP$SyntacticParser$stack.elementAt(CUP$SyntacticParser$top-1)).value;
		 RESULT =  aDeE0; 
              CUP$SyntacticParser$result = parser.getSymbolFactory().newSymbol("E4",9, RESULT);
            }
          return CUP$SyntacticParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$SyntacticParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$SyntacticParser$do_action(
    int                        CUP$SyntacticParser$act_num,
    java_cup.runtime.lr_parser CUP$SyntacticParser$parser,
    java.util.Stack            CUP$SyntacticParser$stack,
    int                        CUP$SyntacticParser$top)
    throws java.lang.Exception
    {
              return CUP$SyntacticParser$do_action_part00000000(
                               CUP$SyntacticParser$act_num,
                               CUP$SyntacticParser$parser,
                               CUP$SyntacticParser$stack,
                               CUP$SyntacticParser$top);
    }
}

