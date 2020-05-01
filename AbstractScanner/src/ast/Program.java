package ast;

import ast.Dec.Dec;
import ast.Inst.Inst;

public class Program {
    private Dec seccionDeclaraciones;
    private Inst seccionInstruccicones;

    public Program(Dec declaraciones, Inst instrucciones){
        this.seccionDeclaraciones = declaraciones;
        this.seccionInstruccicones = instrucciones;
    }

    @Override
    public String toString() {
        return String.format("programa { %s \t%s, %s \t%s %s}", System.lineSeparator(),
                                                            this.seccionDeclaraciones.toString(),
                                                            System.lineSeparator(),
                                                            this.seccionInstruccicones.toString(),
                                                            System.lineSeparator());
    }
}
