/* SynacticParserTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. SynacticParserTokenManager.java */
package syntacticParser.auto;

/** Token Manager. */
@SuppressWarnings("unused")public class SynacticParserTokenManager implements SynacticParserConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0xc0000L) != 0L)
            return 36;
         if ((active0 & 0x800000L) != 0L)
            return 27;
         if ((active0 & 0x4000L) != 0L)
         {
            jjmatchedKind = 20;
            return 34;
         }
         return -1;
      case 1:
         if ((active0 & 0x4000L) != 0L)
         {
            jjmatchedKind = 20;
            jjmatchedPos = 1;
            return 34;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 38:
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 40:
         return jjStopAtPos(0, 24);
      case 41:
         return jjStopAtPos(0, 25);
      case 43:
         return jjStartNfaWithStates_0(0, 18, 36);
      case 45:
         return jjStartNfaWithStates_0(0, 19, 36);
      case 59:
         return jjStopAtPos(0, 22);
      case 61:
         return jjStartNfaWithStates_0(0, 23, 27);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(1, 21);
         break;
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 116:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(2, 14, 34);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 59;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 36:
                  if ((0x3fe000000000000L & l) != 0L)
                     { jjCheckNAddStates(0, 2); }
                  else if (curChar == 48)
                     { jjCheckNAddTwoStates(41, 46); }
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 10)
                        kind = 10;
                     { jjCheckNAdd(37); }
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 10)
                        kind = 10;
                  }
                  break;
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 10)
                        kind = 10;
                     { jjCheckNAddStates(3, 6); }
                  }
                  else if ((0x100002700L & l) != 0L)
                  {
                     if (kind > 8)
                        kind = 8;
                  }
                  else if ((0x280000000000L & l) != 0L)
                     { jjAddStates(7, 10); }
                  else if ((0x840000000000L & l) != 0L)
                  {
                     if (kind > 17)
                        kind = 17;
                  }
                  else if ((0x5000000000000000L & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 10)
                        kind = 10;
                     { jjCheckNAddTwoStates(41, 46); }
                  }
                  else if (curChar == 33)
                     { jjCheckNAdd(27); }
                  else if (curChar == 61)
                     { jjCheckNAdd(27); }
                  else if (curChar == 35)
                  {
                     if (kind > 9)
                        kind = 9;
                     { jjCheckNAdd(2); }
                  }
                  if (curChar == 62)
                     { jjCheckNAdd(27); }
                  else if (curChar == 60)
                     { jjCheckNAdd(27); }
                  break;
               case 1:
                  if (curChar != 35)
                     break;
                  if (kind > 9)
                     kind = 9;
                  { jjCheckNAdd(2); }
                  break;
               case 2:
                  if ((0xfffffffffffffbffL & l) == 0L)
                     break;
                  if (kind > 9)
                     kind = 9;
                  { jjCheckNAdd(2); }
                  break;
               case 26:
                  if ((0x5000000000000000L & l) != 0L && kind > 16)
                     kind = 16;
                  break;
               case 27:
                  if (curChar == 61 && kind > 16)
                     kind = 16;
                  break;
               case 28:
                  if (curChar == 60)
                     { jjCheckNAdd(27); }
                  break;
               case 29:
                  if (curChar == 62)
                     { jjCheckNAdd(27); }
                  break;
               case 30:
                  if (curChar == 61)
                     { jjCheckNAdd(27); }
                  break;
               case 31:
                  if (curChar == 33)
                     { jjCheckNAdd(27); }
                  break;
               case 32:
                  if ((0x840000000000L & l) != 0L && kind > 17)
                     kind = 17;
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  jjstateSet[jjnewStateCnt++] = 34;
                  break;
               case 35:
                  if ((0x280000000000L & l) != 0L)
                     { jjAddStates(7, 10); }
                  break;
               case 37:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  { jjCheckNAdd(37); }
                  break;
               case 38:
                  if (curChar == 48 && kind > 10)
                     kind = 10;
                  break;
               case 39:
                  if ((0x3fe000000000000L & l) != 0L)
                     { jjCheckNAddStates(0, 2); }
                  break;
               case 40:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddStates(0, 2); }
                  break;
               case 42:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(43, 45); }
                  break;
               case 43:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  { jjCheckNAdd(44); }
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  { jjCheckNAdd(44); }
                  break;
               case 45:
                  if (curChar == 48 && kind > 11)
                     kind = 11;
                  break;
               case 46:
                  if (curChar == 46)
                     { jjCheckNAddStates(11, 16); }
                  break;
               case 47:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(47, 48); }
                  break;
               case 48:
                  if ((0x3fe000000000000L & l) != 0L && kind > 11)
                     kind = 11;
                  break;
               case 49:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(49, 50); }
                  break;
               case 50:
                  if ((0x3fe000000000000L & l) != 0L)
                     { jjCheckNAdd(51); }
                  break;
               case 52:
                  if ((0x280000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(53, 45); }
                  break;
               case 53:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  { jjCheckNAdd(54); }
                  break;
               case 54:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  { jjCheckNAdd(54); }
                  break;
               case 55:
                  if (curChar == 48)
                     { jjCheckNAdd(51); }
                  break;
               case 56:
                  if (curChar == 48)
                     { jjCheckNAddTwoStates(41, 46); }
                  break;
               case 57:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  { jjCheckNAddStates(3, 6); }
                  break;
               case 58:
                  if (curChar != 48)
                     break;
                  if (kind > 10)
                     kind = 10;
                  { jjCheckNAddTwoStates(41, 46); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 20)
                        kind = 20;
                     { jjCheckNAdd(34); }
                  }
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 24;
                  else if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 22;
                  else if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 19;
                  else if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 15;
                  else if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 11;
                  else if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 8;
                  else if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 2:
                  if (kind > 9)
                     kind = 9;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 3:
                  if (curChar == 116 && kind > 12)
                     kind = 12;
                  break;
               case 4:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 5:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 6:
                  if (curChar == 108 && kind > 12)
                     kind = 12;
                  break;
               case 7:
                  if (curChar == 97)
                     { jjCheckNAdd(6); }
                  break;
               case 8:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 9:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 10:
                  if (curChar == 111)
                     { jjCheckNAdd(6); }
                  break;
               case 11:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 12:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 13:
                  if (curChar == 101 && kind > 13)
                     kind = 13;
                  break;
               case 14:
                  if (curChar == 117)
                     { jjCheckNAdd(13); }
                  break;
               case 15:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 16:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 17:
                  if (curChar == 115)
                     { jjCheckNAdd(13); }
                  break;
               case 18:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 19:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 20:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 21:
                  if (curChar == 100 && kind > 15)
                     kind = 15;
                  break;
               case 22:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 23:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if (curChar == 114 && kind > 15)
                     kind = 15;
                  break;
               case 25:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 33:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  { jjCheckNAdd(34); }
                  break;
               case 34:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 20)
                     kind = 20;
                  { jjCheckNAdd(34); }
                  break;
               case 41:
                  if ((0x2000000020L & l) != 0L)
                     { jjCheckNAddStates(17, 19); }
                  break;
               case 51:
                  if ((0x2000000020L & l) != 0L)
                     { jjCheckNAddStates(20, 22); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 9)
                     kind = 9;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 59 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   40, 41, 46, 37, 40, 41, 46, 36, 38, 39, 56, 47, 48, 45, 49, 50, 
   55, 42, 43, 45, 52, 53, 45, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, "\156\157\164", null, null, null, "\53", "\55", null, "\46\46", "\73", "\75", 
"\50", "\51", };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public SynacticParserTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public SynacticParserTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 59; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3fffc01L, 
};
static final long[] jjtoSkip = {
   0x300L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[59];
    private final int[] jjstateSet = new int[2 * 59];

    
    protected char curChar;
}
