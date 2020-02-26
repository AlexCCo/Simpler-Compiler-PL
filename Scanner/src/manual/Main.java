package manual;

/**
 * Alumnos:
 *          Tomás Golomb Durán
 *          Alejandro Cancelo Correia
 *
 * Main que ejecuta un ejemplo hasta que
 * se termine el fichero
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Reader input = new InputStreamReader(new FileInputStream(args[0]));
        Reader input = new InputStreamReader(new FileInputStream("examples/ejemplo.alex"));
        LexicalScanner al = new LexicalScanner(input);
        LexicalUnit unidad;
        do {
            unidad = al.sigToken();
            System.out.println(unidad);
        } while (unidad.clase() != LexicalClass.EOF);

    }
} 
