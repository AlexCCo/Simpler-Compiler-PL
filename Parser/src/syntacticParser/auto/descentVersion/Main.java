package syntacticParser.auto.descentVersion;

import java.io.FileReader;

public class Main{
   public static void main(String[] args) throws Exception {
      SynacticParser asint = new SynacticParser(new FileReader("Parser/examples/ejemplo.alex"));
	  asint.enable_tracing();
	  asint.S();
   }
}