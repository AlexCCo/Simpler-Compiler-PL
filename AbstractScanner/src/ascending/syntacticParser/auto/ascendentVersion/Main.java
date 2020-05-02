package ascendant.syntacticParser.auto.ascendentVersion;

import ascendant.lexicalScanner.LexicalScannerCUP;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(new FileInputStream("AbstractScanner/src/ascendant/examples/ejemplo.alex"));
        LexicalScannerCUP alex = new LexicalScannerCUP(input);
        SyntacticParser asint = new SyntacticParser(alex);
        asint.parse();
    }
}
