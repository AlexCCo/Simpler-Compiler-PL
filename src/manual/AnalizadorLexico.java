package manual;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class AnalizadorLexico {
    private Reader input;
    private StringBuffer lex;
    private int sigCar;
    private int filaInicio;
    private int columnaInicio;
    private int filaActual;
    private int columnaActual;
    private static String NL = System.lineSeparator();

    private static enum Estado {
        INICIO, REC_POR, REC_DIV, REC_PAP, REC_PCIERR, REC_COMA, REC_IGUAL,
        REC_MAS, REC_MENOS, REC_ID, REC_ENT, REC_0, REC_IDEC, REC_DEC, REC_COM, REC_EOF
    }

    private Estado estado;

    public AnalizadorLexico(Reader input) throws IOException {
        this.input = input;
        lex = new StringBuffer();
        sigCar = input.read();
        filaActual = 1;
        columnaActual = 1;
    }

    public UnidadLexica sigToken() throws IOException {
        estado = Estado.INICIO;
        filaInicio = filaActual;
        columnaInicio = columnaActual;
        lex.delete(0, lex.length());
        while (true) {
            switch (estado) {
                case INICIO:
                    if (hayLetra()) transita(Estado.REC_ID);
                    else if (hayDigitoPos()) transita(Estado.REC_ENT);
                    else if (hayCero()) transita(Estado.REC_0);
                    else if (haySuma()) transita(Estado.REC_MAS);
                    else if (hayResta()) transita(Estado.REC_MENOS);
                    else if (hayMul()) transita(Estado.REC_POR);
                    else if (hayDiv()) transita(Estado.REC_DIV);
                    else if (hayPAp()) transita(Estado.REC_PAP);
                    else if (hayPCierre()) transita(Estado.REC_PCIERR);
                    else if (hayIgual()) transita(Estado.REC_IGUAL);
                    else if (hayComa()) transita(Estado.REC_COMA);
                    else if (hayAlmohadilla()) transitaIgnorando(Estado.REC_COM);
                    else if (haySep()) transitaIgnorando(Estado.INICIO);
                    else if (hayEOF()) transita(Estado.REC_EOF);
                    else error();
                    break;
                case REC_ID:
                    if (hayLetra() || hayDigito()) transita(Estado.REC_ID);
                    else return unidadId();
                    break;
                case REC_ENT:
                    if (hayDigito()) transita(Estado.REC_ENT);
                    else if (hayPunto()) transita(Estado.REC_IDEC);
                    else return unidadEnt();
                    break;
                case REC_0:
                    if (hayPunto()) transita(Estado.REC_IDEC);
                    else return unidadEnt();
                    break;
                case REC_MAS:
                    if (hayDigitoPos()) transita(Estado.REC_ENT);
                    else if (hayCero()) transita(Estado.REC_0);
                    else return unidadMas();
                    break;
                case REC_MENOS:
                    if (hayDigitoPos()) transita(Estado.REC_ENT);
                    else if (hayCero()) transita(Estado.REC_0);
                    else return unidadMenos();
                    break;
                case REC_POR:
                    return unidadPor();
                case REC_DIV:
                    return unidadDiv();
                case REC_PAP:
                    return unidadPAp();
                case REC_PCIERR:
                    return unidadPCierre();
                case REC_IGUAL:
                    return unidadIgual();
                case REC_COMA:
                    return unidadComa();
                case REC_COM:
                    if (hayNL()) transitaIgnorando(Estado.INICIO);
                    else if (hayEOF()) transita(Estado.REC_EOF);
                    else transitaIgnorando(Estado.REC_COM);
                    break;
                case REC_EOF:
                    return unidadEof();
                case REC_IDEC:
                    if (hayDigitoPos()) transita(Estado.REC_DEC);
                    else if (hayCero()) transita(Estado.REC_IDEC);
                    else error();
                    break;
                case REC_DEC:
                    if (hayDigitoPos()) transita(Estado.REC_DEC);
                    else if (hayCero()) transita(Estado.REC_IDEC);
                    else return unidadReal();
                    break;
            }
        }
    }

    private void transita(Estado sig) throws IOException {
        lex.append((char) sigCar);
        sigCar();
        estado = sig;
    }

    private void transitaIgnorando(Estado sig) throws IOException {
        sigCar();
        filaInicio = filaActual;
        columnaInicio = columnaActual;
        estado = sig;
    }

    private void sigCar() throws IOException {
        sigCar = input.read();
        if (sigCar == NL.charAt(0)) saltaFinDeLinea();
        if (sigCar == '\n') {
            filaActual++;
            columnaActual = 0;
        } else {
            columnaActual++;
        }
    }

    private void saltaFinDeLinea() throws IOException {
        for (int i = 1; i < NL.length(); i++) {
            sigCar = input.read();
            if (sigCar != NL.charAt(i)) error();
        }
        sigCar = '\n';
    }

    private boolean hayLetra() {
        return sigCar >= 'a' && sigCar <= 'z' ||
                sigCar >= 'A' && sigCar <= 'z';
    }

    private boolean hayDigitoPos() {
        return sigCar >= '1' && sigCar <= '9';
    }

    private boolean hayCero() {
        return sigCar == '0';
    }

    private boolean hayDigito() {
        return hayDigitoPos() || hayCero();
    }

    private boolean haySuma() {
        return sigCar == '+';
    }

    private boolean hayResta() {
        return sigCar == '-';
    }

    private boolean hayMul() {
        return sigCar == '*';
    }

    private boolean hayDiv() {
        return sigCar == '/';
    }

    private boolean hayPAp() {
        return sigCar == '(';
    }

    private boolean hayPCierre() {
        return sigCar == ')';
    }

    private boolean hayIgual() {
        return sigCar == '=';
    }

    private boolean hayComa() {
        return sigCar == ',';
    }

    private boolean hayPunto() {
        return sigCar == '.';
    }

    private boolean hayAlmohadilla() {
        return sigCar == '#';
    }

    private boolean haySep() {
        return sigCar == ' ' || sigCar == '\t' || sigCar == '\n';
    }

    private boolean hayNL() {
        return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';
    }

    private boolean hayEOF() {
        return sigCar == -1;
    }

    private UnidadLexica unidadId() {
        switch (lex.toString()) {
            case ";":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.EOI);
            case "&&":
                return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.EOD);
            default:
                return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.?, lex.toString());
        }
    }

    private UnidadLexica unidadOperatorAdd() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPADD);
    }

    private UnidadLexica unidadOperatorSub() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPSUB);
    }

    private UnidadLexica unidadOperatorMul() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPMUL);
    }

    private UnidadLexica unidadOperatorDiv() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPDIV);
    }

    private UnidadLexica unidadOperatorLowerThan() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPLT);
    }

    private UnidadLexica unidadOperatorLowerThanOrEquals() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPLTE);
    }

    private UnidadLexica unidadOperatorGreaterThan() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPGT);
    }

    private UnidadLexica unidadOperatorGreaterThanOrEquals() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPGTE);
    }

    private UnidadLexica unidadOperatorEquals() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPE);
    }

    private UnidadLexica unidadOperatorNotEquals() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPNE);
    }

    private UnidadLexica unidadOperatorAssignment() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.OPASS);
    }

    private UnidadLexica unidadType() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.TYPE);
    }

    private UnidadLexica unidadVar() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.VAR);
    }

    private UnidadLexica unidadIgnorable() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.IGN);
    }

    private UnidadLexica unidadInt() {
        return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.INT, lex.toString());
    }

    private UnidadLexica unidadDouble() {
        return new UnidadLexicaMultivaluada(filaInicio, columnaInicio, ClaseLexica.DOUBLE, lex.toString());
    }

    private UnidadLexica unidadPAp() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.PAP);
    }

    private UnidadLexica unidadPCierre() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.PCIERRE);
    }

    private UnidadLexica unidadEof() {
        return new UnidadLexicaUnivaluada(filaInicio, columnaInicio, ClaseLexica.EOF);
    }

    private void error() {
        System.err.println("(" + filaActual + ',' + columnaActual + "):Caracter inexperado");
        System.exit(1);
    }
}