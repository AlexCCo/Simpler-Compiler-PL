package syntacticParser.manual;

import lexicalScanner.LexicalScanner;
import lexicalScanner.LexicalUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Reader input = new InputStreamReader(new FileInputStream("examples/ej5.alex"));

        final LexicalScanner al = new LexicalScanner(input);
        SyntacticParser parser = new SyntacticParser() {
                         
            @Override
            public LexicalUnit getNextToken() {
                LexicalUnit nextToken = null;
                try {
                    nextToken = al.yylex();
                    System.out.println("next Token: " + nextToken);
                } catch (Exception e) {
                    System.exit(-1);
                }

                return nextToken;
            }
        };

        try {
            parser.init();
            System.out.println("ta weno");
        } catch (SyntacticError e) {
            //e.printStackTrace();
            System.out.println("ERROR SYNTACTIC: " + e.getMessage());
        }
    }
}
