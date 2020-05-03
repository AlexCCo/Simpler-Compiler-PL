package ascending.lexicalScanner;

import java.io.*;

/**
 * This class was made just for testing purposes
 * */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Reader input = new InputStreamReader(new FileInputStream(args[0]));
        Reader input = new InputStreamReader(new FileInputStream("Parser/examples/ej5.alex"));
        LexicalScanner al = new LexicalScanner(input);
        LexicalUnit unidad;
        do {
            unidad = al.yylex();
            System.out.println(unidad);
        } while (unidad.clase() != LexicalClass.EOF);

    }
} 
