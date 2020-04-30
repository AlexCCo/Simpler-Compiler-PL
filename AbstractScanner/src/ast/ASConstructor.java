package ast;


import ast.EBin.*;
import ast.EMono.Negativo;
import ast.EMono.Not;
import ast.Inst.Inst;
import ast.Inst.InstComp;
import ast.Inst.InstSimple;
import ast.Tipos.Bool;
import ast.Tipos.Entero;
import ast.Tipos.Real;

public class ASConstructor {
    //constructores semanticos
    public E logicalAND(E opnd1, E opnd2){return new And(opnd1, opnd2); }
    public E logicalOR(E opnd1, E opnd2){return new Or(opnd1, opnd2);}

    public E comp(E opnd1, E opnd2){return new Comparacion(opnd1, opnd2);}
    public E distin(E opnd1, E opnd2){return new Distinto(opnd1, opnd2);}
    public E mayor(E opnd1, E opnd2){return new Mayor(opnd1, opnd2);}
    public E mayorigual(E opnd1, E opnd2){return new MayorIgual(opnd1, opnd2);}
    public E menor(E opnd1, E opnd2){return new Menor(opnd1, opnd2);}
    public E menorigual(E opnd1, E opnd2){return new MenorIgual(opnd1, opnd2);}

    public E div(E opnd1, E opnd2){return new Div(opnd1, opnd2);}
    public E mul(E opnd1, E opnd2){return new Mul(opnd1, opnd2);}
    public E resta(E opnd1, E opnd2){return new Resta(opnd1, opnd2);}
    public E suma(E opnd1, E opnd2){return new Suma(opnd1, opnd2);}

    public E negacion(E opnd1){return new Negativo(opnd1);}
    public E logicalNOT(E opnd1){return new Not(opnd1);}


    public E varName(String arg1){return new Id(arg1);}
    public E numEntero(String arg1){return new Entero(arg1);}
    public E numReal(String arg1){return new Real(arg1);}
    public E booleano(String arg1){return new Bool(arg1);}


    public Inst instruc(String arg1, E arg2){return new InstSimple(arg1, arg2); }
    public InstComp inst_compuesta(Inst arg1, )
    //funciones semanticas
    public E exp(TipoE ope, E arg1, E arg2){
        switch(ope){
            case DIV: return new Div(arg1, arg2);
            case MUL: return new Mul(arg1, arg2);
            case RESTA: return new Resta(arg1, arg2);
            case SUMA: return new Suma(arg1, arg2);

            case COMPARACION: return new Comparacion(arg1, arg2);
            case DISTINTO: return new Distinto(arg1, arg2);
            case MAYOR: return new Mayor(arg1, arg2);
            case MAYORIG: return new MayorIgual(arg1, arg2);
            case MENOR: return new Menor(arg1, arg2);
            case MENORIG: return new MenorIgual(arg1, arg2);

            case AND: return new And(arg1, arg2);
            case OR: return new Or(arg1, arg2);
            default: return null;
        }
    }

    public E exp(TipoE ope, E arg1){
        switch(ope){
            case NOT: return new Not(arg1);
            case RESTA: return new Negativo(arg1);
            default: return null;
        }
    }
}
