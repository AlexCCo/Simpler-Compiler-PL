/* Evaluador.java */
/* Generated By:JavaCC: Do not edit this line. Evaluador.java */
package descending;

import ast.*;
import ast.Dec.*;
import ast.EBin.*;
import ast.EMono.*;
import ast.Inst.*;
import ast.Tipos.*;

public class Evaluador implements EvaluadorConstants {

  final public Program Sp() throws ParseException {Program ast;
    ast = S();
    jj_consume_token(0);
{if ("" != null) return ast;}
    throw new Error("Missing return statement in function");
  }

  final public Program S() throws ParseException {Dec SDa; Inst ISa;
    SDa = SD();
    jj_consume_token(EOD);
    ISa = IS();
{if ("" != null) return ASConstructor.prog_completo(SDa, ISa);}
    throw new Error("Missing return statement in function");
  }

  final public Dec SD() throws ParseException {Dec VARa; Dec RSDa;
    VARa = VAR();
    RSDa = RSD(VARa);
{if ("" != null) return  RSDa;}
    throw new Error("Missing return statement in function");
  }

  final public Dec RSD(Dec ah) throws ParseException {Dec VARa; Dec RSD1a;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case EOI:{
      jj_consume_token(EOI);
      VARa = VAR();
      RSD1a = RSD(ASConstructor.decs_compuesta(ah, VARa));
{if ("" != null) return RSD1a;}
      break;
      }
    default:
      jj_la1[0] = jj_gen;
{if ("" != null) return ah;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Dec VAR() throws ParseException {String tp; Token nv;
    tp = TP();
    nv = jj_consume_token(VAR_NAME);
{if ("" != null) return  ASConstructor.decl(tp, nv.image);}
    throw new Error("Missing return statement in function");
  }

  final public String TP() throws ParseException {Token tp;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case REAL_TYPE:{
      tp = jj_consume_token(REAL_TYPE);
{if ("" != null) return tp.image;}
      break;
      }
    case INT_TYPE:{
      tp = jj_consume_token(INT_TYPE);
{if ("" != null) return tp.image;}
      break;
      }
    case BOOL_TYPE:{
      tp = jj_consume_token(BOOL_TYPE);
{if ("" != null) return tp.image;}
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Inst IS() throws ParseException {Inst INSTa; Inst RISa;
    INSTa = INST();
    RISa = RIS(INSTa);
{if ("" != null) return RISa;}
    throw new Error("Missing return statement in function");
  }

  final public Inst RIS(Inst ah) throws ParseException {Inst RIS1a; Inst INSTa;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case EOI:{
      jj_consume_token(EOI);
      INSTa = INST();
      RIS1a = RIS(ASConstructor.inst_compuesta(ah,INSTa));
{if ("" != null) return RIS1a;}
      break;
      }
    default:
      jj_la1[2] = jj_gen;
{if ("" != null) return ah;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Inst INST() throws ParseException {Token nv; E E0a;
    nv = jj_consume_token(VAR_NAME);
    jj_consume_token(OPERATOR_ASSIGNMENT);
    E0a = E0();
{if ("" != null) return  ASConstructor.instruc(nv.image, E0a);}
    throw new Error("Missing return statement in function");
  }

  final public E E0() throws ParseException {E R0a;
    R0a = R0(E1());
{if ("" != null) return R0a;}
    throw new Error("Missing return statement in function");
  }

  final public E R0(E ah) throws ParseException {E E01a;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case OPERATOR_ADD:{
      jj_consume_token(OPERATOR_ADD);
      E01a = E0();
{if ("" != null) return ASConstructor.exp(TipoE.SUMA, ah, E01a);}
      break;
      }
    case OPERATOR_MINUS:{
      jj_consume_token(OPERATOR_MINUS);
      E01a = E1();
{if ("" != null) return ASConstructor.exp(TipoE.RESTA, ah, E01a);}
      break;
      }
    default:
      jj_la1[3] = jj_gen;
{if ("" != null) return ah;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E1() throws ParseException {E R1a;
    R1a = R1(E2());
{if ("" != null) return R1a;}
    throw new Error("Missing return statement in function");
  }

  final public E R1(E ah) throws ParseException {E R1a; E E2a; TipoE opE1a;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LOGICAL_OR:
    case LOGICAL_AND:{
      opE1a = opE1();
      E2a = E2();
      R1a = R1(ASConstructor.exp(opE1a, ah, E2a));
{if ("" != null) return R1a;}
      break;
      }
    default:
      jj_la1[4] = jj_gen;
{if ("" != null) return ah;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E2() throws ParseException {E E3a; E R2a;
    E3a = E3();
    R2a = R2(E3a);
{if ("" != null) return R2a;}
    throw new Error("Missing return statement in function");
  }

  final public E R2(E ah) throws ParseException {E E3a; E R2a; TipoE opE2a;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case OPERATOR_LESS_THAN:
    case OPERATOR_LESS_EQUAL_THAN:
    case OPERATOR_GREATER_THAN:
    case OPERATOR_GREATER_EQUAL_THAN:
    case OPERATOR_EQUAL:
    case OPERATOR_NOT_EQUAL:{
      opE2a = opE2();
      E3a = E3();
      R2a = R2(ASConstructor.exp(opE2a, ah, E3a));
{if ("" != null) return R2a;}
      break;
      }
    default:
      jj_la1[5] = jj_gen;
{if ("" != null) return ah;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E3() throws ParseException {E E4a; E R3a;
    E4a = E4();
    R3a = R3(E4a);
{if ("" != null) return R3a;}
    throw new Error("Missing return statement in function");
  }

  final public E R3(E ah) throws ParseException {TipoE opE3a; E E4a;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case OPERATOR_DIV:
    case OPERATOR_MUL:{
      opE3a = opE3();
      E4a = E4();
{if ("" != null) return ASConstructor.exp(opE3a, ah, E4a);}
      break;
      }
    default:
      jj_la1[6] = jj_gen;
{if ("" != null) return ah;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E4() throws ParseException {TipoE opE4a; E E5a;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case OPERATOR_MINUS:
    case LOGICAL_NOT:{
      opE4a = opE4();
      E5a = E5();
{if ("" != null) return ASConstructor.exp(opE4a, E5a);}
      break;
      }
    case INTEGER_NUM:
    case REAL_NUM:
    case BOOLEAN:
    case OPEN_PARENTHESIS:
    case VAR_NAME:{
      E5a = E5();
{if ("" != null) return E5a;}
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public E E5() throws ParseException {E E5a; E terminala;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case INTEGER_NUM:
    case REAL_NUM:
    case BOOLEAN:
    case VAR_NAME:{
      terminala = terminal();
{if ("" != null) return terminala;}
      break;
      }
    case OPEN_PARENTHESIS:{
      jj_consume_token(OPEN_PARENTHESIS);
      E5a = E0();
      jj_consume_token(CLOSE_PARENTHESIS);
{if ("" != null) return E5a;}
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public E terminal() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case BOOLEAN:{
      t = jj_consume_token(BOOLEAN);
{if ("" != null) return ASConstructor.booleano(t.image);}
      break;
      }
    case VAR_NAME:{
      t = jj_consume_token(VAR_NAME);
{if ("" != null) return ASConstructor.varName(t.image);}
      break;
      }
    case INTEGER_NUM:{
      t = jj_consume_token(INTEGER_NUM);
{if ("" != null) return ASConstructor.numEntero(t.image);}
      break;
      }
    case REAL_NUM:{
      t = jj_consume_token(REAL_NUM);
{if ("" != null) return ASConstructor.numReal(t.image);}
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public TipoE opE1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LOGICAL_AND:{
      jj_consume_token(LOGICAL_AND);
{if ("" != null) return TipoE.AND;}
      break;
      }
    case LOGICAL_OR:{
      jj_consume_token(LOGICAL_OR);
{if ("" != null) return TipoE.OR;}
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public TipoE opE2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case OPERATOR_LESS_THAN:{
      jj_consume_token(OPERATOR_LESS_THAN);
{if ("" != null) return TipoE.MENOR;}
      break;
      }
    case OPERATOR_LESS_EQUAL_THAN:{
      jj_consume_token(OPERATOR_LESS_EQUAL_THAN);
{if ("" != null) return TipoE.MENORIG;}
      break;
      }
    case OPERATOR_GREATER_THAN:{
      jj_consume_token(OPERATOR_GREATER_THAN);
{if ("" != null) return TipoE.MAYOR;}
      break;
      }
    case OPERATOR_GREATER_EQUAL_THAN:{
      jj_consume_token(OPERATOR_GREATER_EQUAL_THAN);
{if ("" != null) return TipoE.MAYORIG;}
      break;
      }
    case OPERATOR_EQUAL:{
      jj_consume_token(OPERATOR_EQUAL);
{if ("" != null) return TipoE.COMPARACION;}
      break;
      }
    case OPERATOR_NOT_EQUAL:{
      jj_consume_token(OPERATOR_NOT_EQUAL);
{if ("" != null) return TipoE.DISTINTO;}
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public TipoE opE3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case OPERATOR_MUL:{
      jj_consume_token(OPERATOR_MUL);
{if ("" != null) return TipoE.MUL;}
      break;
      }
    case OPERATOR_DIV:{
      jj_consume_token(OPERATOR_DIV);
{if ("" != null) return TipoE.DIV;}
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public TipoE opE4() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case OPERATOR_MINUS:{
      jj_consume_token(OPERATOR_MINUS);
{if ("" != null) return TipoE.RESTA;}
      break;
      }
    case LOGICAL_NOT:{
      jj_consume_token(LOGICAL_NOT);
{if ("" != null) return TipoE.NOT;}
      break;
      }
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public EvaluadorTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40000000,0x1c000000,0x40000000,0xc00,0x600000,0x1bc000,0x3000,0x23800800,0x23000000,0x23000000,0x600000,0x1bc000,0x3000,0x800800,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x5,0x5,0x4,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public Evaluador(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Evaluador(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new EvaluadorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Evaluador(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new EvaluadorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Evaluador(EvaluadorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(EvaluadorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[35];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 35; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

                        }
