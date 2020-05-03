package ast;


import ast.Dec.Dec;
import ast.Dec.DecComp;
import ast.Dec.DecSimple;
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
    public static E logicalAND(E opnd1, E opnd2){return new And(opnd1, opnd2); }
    public static E logicalOR(E opnd1, E opnd2){return new Or(opnd1, opnd2);}

    public static E comp(E opnd1, E opnd2){return new Comparacion(opnd1, opnd2);}
    public static E distin(E opnd1, E opnd2){return new Distinto(opnd1, opnd2);}
    public static E mayor(E opnd1, E opnd2){return new Mayor(opnd1, opnd2);}
    public static E mayorigual(E opnd1, E opnd2){return new MayorIgual(opnd1, opnd2);}
    public static E menor(E opnd1, E opnd2){return new Menor(opnd1, opnd2);}
    public static E menorigual(E opnd1, E opnd2){return new MenorIgual(opnd1, opnd2);}

    public static E div(E opnd1, E opnd2){return new Div(opnd1, opnd2);}
    public static E mul(E opnd1, E opnd2){return new Mul(opnd1, opnd2);}
    public static E resta(E opnd1, E opnd2){return new Resta(opnd1, opnd2);}
    public static E suma(E opnd1, E opnd2){return new Suma(opnd1, opnd2);}

    public static E negacion(E opnd1){return new Negativo(opnd1);}
    public static E logicalNOT(E opnd1){return new Not(opnd1);}


    public static E varName(String arg1){return new Id(arg1);}
    public static E numEntero(String arg1){return new Entero(arg1);}
    public static E numReal(String arg1){return new Real(arg1);}
    public static E booleano(String arg1){return new Bool(arg1);}


    public static Inst instruc(String arg1, E arg2){return new InstSimple(arg1, arg2); }
    public static InstComp inst_compuesta(Inst lInst, Inst newInst){return new InstComp(lInst, newInst);}

    public static Dec decl(String type, String varName){return new DecSimple(type, varName);}
    public static DecComp decs_compuesta(Dec lDec, Dec newDec){return new DecComp(lDec, newDec);}

    public static Program prog_completo(Dec lDec, Inst lInst){return new Program(lDec, lInst);}

    //funciones semanticas
    public static E exp(TipoE ope, E arg1, E arg2){
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

    public static E exp(TipoE ope, E arg1){
        switch(ope){
            case NOT: return new Not(arg1);
            case RESTA: return new Negativo(arg1);
            default: return null;
        }
    }
}
