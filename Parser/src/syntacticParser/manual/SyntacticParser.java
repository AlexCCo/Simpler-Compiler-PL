package syntacticParser.manual;

import lexicalScanner.LexicalClass;
import lexicalScanner.LexicalUnit;

public abstract class SyntacticParser {
   private LexicalUnit token;

   public SyntacticParser(){
      //scanner = new LexicalScanner(input);
      nextToken();
   }

    /**
     * This method will initiate the Parser's derivation tree using the
     * LL(1) grammar
     * */
   public void init() throws SyntacticError {
      S();
      match(LexicalClass.EOF);
   }

   private void match (LexicalClass expectedClass) throws SyntacticError {
      if (token.clase() == expectedClass)
          nextToken();
      else {
          throw new SyntacticError(token.row(), token.column(), LexicalClass.valueOf(expectedClass)
           + " but found " + token.clase());
      }
   }

   public abstract LexicalUnit getNextToken();

   private void nextToken(){
      token = getNextToken();
   }

   private void S() throws SyntacticError {
      switch (token.clase()) {
         case INT_TYPE:
         case BOOL_TYPE:
         case REAL_TYPE:
            SD();
            match(LexicalClass.EOD); // &&
            IS();
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Expected a variable type");
      }
   }

   /**
    * This starts the <b>declaration</b> section where each instruction must be
    * in the form of: <br>
    * &lt;type&gt &lt;variableName&gt &lt; ; &gt <br>
    * See the README file for more information
    * */
   private void SD() throws SyntacticError {
      switch (token.clase()) {
         case INT_TYPE:
         case BOOL_TYPE:
         case REAL_TYPE:
            VAR();
            RSD();
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Expected a variable type but found " + token.clase().toString() );
      }
   }

   /**
    * This is the production to determine if we have something in the form of: <br>
    * &lt;type&gt &lt;variableName&gt &lt; ; &gt <br>
    * See the README file for more information
    * */
   private void VAR() throws SyntacticError {
      TP();
      NV();
   }

   /**
    * With this method we could implement the list of declarations with a LL(1) grammar. <br>
    * See the README file for more information
    * */
   private void RSD() throws SyntacticError {
      switch (token.clase()){
         case EOI: // ;
            match(LexicalClass.EOI);
            VAR();
            RSD();
            break;
         case EOD:
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Expected a ; or && but found " + token.clase().toString());
      }
   }

   /**
    * This starts the <b>instruction</b> section where each instruction is an assignment of the form: <br>
    * &lt;variable name&gt; &lt; = &gt; &lt;expression&gt; <br>
    * See the README file for more information
    * */
   private void IS() throws SyntacticError {
      switch (token.clase()) {
         case VAR_NAME:
            INST();
            RIS();
            break;
         default:
            throw  new SyntacticError(token.row(), token.column(), "Expected a variable name but found" + token.clase().toString());
      }
   }

   /**
    * This production will make sure we have an assignment
    */
   private void INST() throws SyntacticError {
      switch (token.clase()) {
         case VAR_NAME:
            NV();
            OpAssig();
            E0();
         default:
            throw  new SyntacticError(token.row(), token.column(), "Expected a variable name but found" + token.clase().toString());
      }
   }

   /**
    * With this method we could implement the list of assignments with a LL(1) grammar. <br>
    * See the README file for more information
    * */
   private void RIS() throws SyntacticError {
      switch (token.clase()){
         case EOI:
            match(LexicalClass.EOI);
            INST();
            RIS();
         case EOF:
            //this will implement the empty string from our grammar
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), ";",
                    "All assignments must end with a semicolon except the last one");
      }
   }

   /**
    * It implements the first level priority in an expression. <br>
    * See the README file for more information about the first level priority.
    * */
   private void E0() throws SyntacticError {
      switch (token.clase()) {
         case OPERATOR_MINUS:
         case INTEGER_NUM:
         case REAL_NUM:
         case VAR_NAME:
         case LOGICAL_NOT:
         case OPEN_PARENTHESIS:
            E1();
            R0();
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Unexpected token found " + token.clase().toString());
      }
   }
   private void R0() throws SyntacticError {
      switch (token.clase()){
         case OPERATOR_ADD:
            match(LexicalClass.OPERATOR_ADD);
            // the + operator associates to the right
            E0();
            break;
         case OPERATOR_MINUS:
            match(LexicalClass.OPERATOR_MINUS);
            E1();
            break;
         case CLOSE_PARENTHESIS:
         case EOI:
         case EOF:
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Expected a + or - operator but found " + token.clase().toString());
      }
   }

   /**
    * It implements the second level priority in an expression. <br>
    * See the README file for more information about the second level priority.
    * */
   private void E1() throws SyntacticError {
      switch (token.clase()) {
         case OPERATOR_MINUS:
         case INTEGER_NUM:
         case REAL_NUM:
         case VAR_NAME:
         case LOGICAL_NOT:
         case OPEN_PARENTHESIS:
            E2();
            R1();
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Unexpected token found " + token.clase().toString());
      }
   }
   private void R1() throws SyntacticError {
      switch (token.clase()){
         case LOGICAL_AND:
            match(LexicalClass.LOGICAL_AND);
            E2();
            R1();
            break;
         case LOGICAL_OR:
            match(LexicalClass.LOGICAL_OR);
            E2();
            R1();
            break;
         case OPERATOR_ADD:
         case OPERATOR_MINUS:
         case CLOSE_PARENTHESIS:
         case EOI:
         case EOF:
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Expected a logical and or a logical or but found " + token.clase().toString());
      }
   }

   /**
    * It implements the third level priority in an expression. <br>
    * See the README file for more information about the third level priority.
    * */
   private void E2() throws SyntacticError {
      switch (token.clase()) {
         case OPERATOR_MINUS:
         case INTEGER_NUM:
         case REAL_NUM:
         case VAR_NAME:
         case LOGICAL_NOT:
         case OPEN_PARENTHESIS:
            E3();
            R2();
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Unexpected token found " + token.clase().toString());
      }
   }
   private void R2() throws SyntacticError {
      switch (token.clase()){
         case OPERATOR_LESS_THAN:
            match(LexicalClass.OPERATOR_LESS_THAN);
            E3();
            R2();
            break;
         case OPERATOR_LESS_EQUAL_THAN:
            match(LexicalClass.OPERATOR_LESS_EQUAL_THAN);
            E3();
            R2();
            break;
         case OPERATOR_GREATER_THAN:
            match(LexicalClass.OPERATOR_GREATER_THAN);
            E3();
            R2();
            break;
         case OPERATOR_GREATER_EQUAL_THAN:
            match(LexicalClass.OPERATOR_GREATER_EQUAL_THAN);
            E3();
            R2();
            break;
         case OPERATOR_EQUAL:
            match(LexicalClass.OPERATOR_EQUAL);
            E3();
            R2();
            break;
         case OPERATOR_NOT_EQUAL:
            match(LexicalClass.OPERATOR_NOT_EQUAL);
            E3();
            R2();
            break;
         case OPERATOR_ADD:
         case OPERATOR_MINUS:
         case LOGICAL_AND:
         case LOGICAL_OR:
         case CLOSE_PARENTHESIS:
         case EOI:
         case EOF:
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Expected <, <=, >, >=, == or != but found " + token.clase().toString());
      }
   }

   /**
    * It implements the fourth level priority in an expression. <br>
    * See the README file for more information about the fourth level priority.
    * */
   private void E3() throws SyntacticError {
      switch (token.clase()) {
         case OPERATOR_MINUS:
         case INTEGER_NUM:
         case REAL_NUM:
         case VAR_NAME:
         case LOGICAL_NOT:
         case OPEN_PARENTHESIS:
            E4();
            R3();
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Unexpected token found " + token.clase().toString());
      }
   }
   private void R3() throws SyntacticError {
      switch (token.clase()){
         case OPERATOR_MUL:
            match(LexicalClass.OPERATOR_MUL);
            E4();
         case OPERATOR_DIV:
            match(LexicalClass.OPERATOR_DIV);
            E4();
            break;
         case OPERATOR_ADD:
         case OPERATOR_MINUS:
         case LOGICAL_AND:
         case LOGICAL_OR:
         case CLOSE_PARENTHESIS:
         case OPERATOR_LESS_THAN:
         case OPERATOR_LESS_EQUAL_THAN:
         case OPERATOR_GREATER_THAN:
         case OPERATOR_GREATER_EQUAL_THAN:
         case OPERATOR_NOT_EQUAL:
         case OPERATOR_EQUAL:
         case EOI:
         case EOF:
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Expected * or / but found " + token.clase().toString());
      }
   }

   /**
    * It implements the fifth level priority in an expression. <br>
    * See the README file for more information about the fifth level priority.
    * */
   private void E4() throws SyntacticError {
      switch (token.clase()){
         case OPERATOR_MINUS:
            match(LexicalClass.OPERATOR_MINUS);
            E4();
            break;
         case LOGICAL_NOT:
            match(LexicalClass.LOGICAL_NOT);
            E4();
            break;
         case OPEN_PARENTHESIS:
            match(LexicalClass.OPEN_PARENTHESIS);
            E0();
            match(LexicalClass.CLOSE_PARENTHESIS);
            break;
         case VAR_NAME:
            match(LexicalClass.VAR_NAME);
            break;
         case REAL_NUM:
            match(LexicalClass.REAL_NUM);
            break;
         case INTEGER_NUM:
            match(LexicalClass.INTEGER_NUM);
            break;
         case BOOLEAN:
            match(LexicalClass.BOOLEAN);
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), " -expression, not expression, variable name, a real number," +
                    " an integer number or a boolean value (true | false)");
      }
   }

   private void TP() throws SyntacticError {
      switch (token.clase()){
         case BOOL_TYPE:
            match(LexicalClass.BOOL_TYPE);
            break;
         case REAL_TYPE:
            match(LexicalClass.REAL_NUM);
            break;
         case INT_TYPE:
            match(LexicalClass.INT_TYPE);
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "type", "A type must be in one of the followings" +
                    "( bool, real, int");
      }
   }

   private void NV() throws SyntacticError{
      switch (token.clase()){
         case VAR_NAME:
            match(LexicalClass.VAR_NAME);
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Expected a variable name but found" + token.clase().toString(),
                    "Variable names start with a letter and continue with a sequence of letters, digits and underscore.");
      }
   }

   private void OpAssig() throws SyntacticError{
      switch (token.clase()){
         case OPERATOR_ASSIGNMENT:
            match(LexicalClass.OPERATOR_ASSIGNMENT);
            break;
         default:
            throw new SyntacticError(token.row(), token.column(), "Expected = but found " + token.clase().toString());
      }
   }
}
