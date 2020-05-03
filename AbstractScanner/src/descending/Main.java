package descending;

import java.io.FileReader;

public class Main{
   public static void main(String[] args) throws Exception {
      Evaluador eval;
      eval = new Evaluador(new FileReader("AbstractScanner/src/descending/examples/ejemplo.alex"));
      System.out.println(eval.Sp());
   }
}
