package syntacticParser.auto.ascendentVersion;

import lexicalScanner.LexicalScannerCUP;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws Exception {
        Reader input = new InputStreamReader(new FileInputStream("Parser/examples/ej1.alex"));
        LexicalScannerCUP alex = new LexicalScannerCUP(input);
        SyntacticParser asint = new SyntacticParser(alex);
        asint.parse();
    }
}
