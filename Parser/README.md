# Parser

Every lexical scanner have its ***limitations*** due to the requirement of an FDA which only accepts a language 
described by a *[regular expression](https://en.wikipedia.org/wiki/Regular_expression)*. That's why, to continue
extracting more information about a program file we need to use what is known as 
*[Context-Free Grammars](https://en.wikipedia.org/wiki/Context-free_grammar)*. <br>

Our ***Parser*** will make use of our ***Scanner*** to create what is know in computation as a
*[Recursive Descent Parser](https://en.wikipedia.org/wiki/Recursive_descent_parser)*
but using a ***context-free grammar*** LL(1) which has some advantages like:
1. All LL(1) grammars are not ambiguous
2. They do not have any left recursion (we will see more of it ahead)

## Context-Free grammar LL(1)

We will continue using the language first introduced in our ***Scanner*** and in the form of: <br>
<variable declarations><br>
&&
<assignment operations><br>
Please, refer to our post about the *[Scanner](https://github.com/AlexCCo/Simpler-Compiler-PL/tree/master/Scanner)*
for more information about the language.<br>

Before anything else, we need to specify some ***priorities and associations*** of our operands:
- Level 0:
  - The operator + associates to the right, and the operator - doesn't associate (both are binaries operators)
- Level 1:
  - The logical operators ***and*** and ***or*** associates to the left, and they are binaries
- Level 2:
  - Every relational operator (<, <=, >, >=, != and ==) are binaries and associate to the left
- Level 3:
  - The operator * and / are binaries and not associate
- Level 4;
  - The unary operator - and logical not are prefix. The - doesn't associate, but the logical not do.
    
After all that introduction, we will specify our grammar.<br>
Our grammar **G** will be defined like the following:<br>

<b>G = {V, T, P, S}</b>

Where:
- V = {S, SD, VAR, INST, IS, E0, E1, opE1, E2, opE2, E3, opE3, E4, opE4, terminal} <br>
  is the set of non-terminal symbols
- T = {NE, NR, NV, EOI, EOD, EOF, TP, =, true, false, and, or, <, <=, >, >=, ==, !=, *,  /, not, -, +}<br>
  is the set of all terminal symbols
- S = Is the initial symbol
- P is the set of all production rules our grammar has.

### Production rules set

We will separate our productions in three sections:
1. Rules referring to the program itself
2. Rules referring to the declaration sections
3. Rules referring to the instruction sections
For more information about each section, see the specification written in the [Scanner]()

#### Rules referring to the program

In this section we only have the following rule. <br>
```S ---> SD && IS ```<br>
This rule is the formal version of how our programs should be written. It is remembered at the begining of the
context-free grammar LL(1)

#### Rules referring to the declaration sections

We will have rules implementing the behavior of a list of declarations. <br>
```
SD ---> SD ; VAR
SD ---> VAR
VAR ---> TP NV
```
TP means **type** and can be one of the following: int, real and bool<br>

#### Rules referring to the instruction section

We will have all rules implementing the list of instructions. <br>
```
IS ---> IS ; INST
IS ---> INST
INST ---> NV = E0
```
E0 will be the initial symbol in which we will specify what we consider an expression in this language.<br>
E0 corresponds to the level 0, E1 to the level 1 and so forth.<br>
```
E0 ---> E1 + E0
E0 ---> E1 - E1
E0 ---> E1

E1 ---> E1 opE1 E2
E1 ---> E2
opE1 ---> and
opE1 ---> or

E2 ---> E2 opE2 E3
E2 ---> E3
opE2 ---> <
opE2 ---> <=
opE2 ---> >
opE2 ---> >=
opE2 ---> !=
opE2 ---> ==

E3 ---> E4 opE3 E4
E3 ---> E4
opE3 ---> *
opE3 ---> /

E4 ---> opE4 E4
E4 ---> terminal
E4 ---> (E0)
opE4 ---> not
opE4 ---> -
terminal ---> NE
terminal ---> NV
terminal ---> NR
terminal ---> true
terminal ---> false
```
NE specifies all **integer numbers**, NR all **real number** and NV all **variable names**<br>

The above grammar have two important problems, some rules have [left recursion](https://en.wikipedia.org/wiki/Left_recursion)
and some need to be converted using the [left factoring](http://www.csd.uwo.ca/~moreno/CS447/Lectures/Syntax.html/node9.html)
technique. That is what we will be doing now.

### Transforming the Contex-Free Grammar

We will eliminate all the ***left recursion*** found in our grammar's rules.<br>
Those rules are:<br>
SD, IS, E1 and E2, and the transformation will be as follows:<br>
```
SD ---> VAR RSD
RSD ---> ; VAR RSD
RSD ---> k
VAR -> TP NV

IS ---> INST RIS
RIS ---> ; INST RIS
RIS ---> k
INST ---> NV = E0

E1 ---> E2 R1
R1 ---> opE1 E2 R1
R1 ---> k

E2 ---> E3 R2
R2 ---> opE2 E3 R2
R2 ---> k
```
Now we will use the ***left factoring*** in the following rules:<br>
E0 and E3.<br>
```
E0 ---> E1 R0
R0 ---> + E0
R0 ---> - E1
R0 ---> k

E3 ---> E4 R3
R3 ---> opE3 E4
R3 ---> k
```
We are using the letter k as a replacement of the **empty string**, in other works you will see the greek letter
epsilon, they mean the same as here.<br>

### Result

The resulting ***Context-Free Grammar*** will be the following:<br>
<div align=center> <b>G = {V', T, P', S}</b> </div>

Where:
- V' = V union {R0, R1, R2, R3}<br>
  is the set of non-terminal symbols
- T will stay the same as above and is the set of all terminal symbols
- S = Is the initial symbol
- P is the set of all production rules our grammar has but will be specifies as follows:<br>
```
S ---> SD && IS 

SD ---> VAR RSD
RSD ---> ; VAR RSD
RSD ---> k
VAR -> TP NV

IS ---> INST RIS
RIS ---> ; INST RIS
RIS ---> k
INST ---> NV = E0

E0 ---> E1 R0
R0 ---> + E0
R0 ---> - E1
R0 ---> k

E1 ---> E2 R1
R1 ---> opE1 E2 R1
R1 ---> k
opE1 ---> and
opE1 ---> or

E2 ---> E3 R2
R2 ---> opE2 E3 R2
R2 ---> k
opE2 ---> <
opE2 ---> <=
opE2 ---> >
opE2 ---> >=
opE2 ---> !=
opE2 ---> ==

E3 ---> E4 R3
R3 ---> opE3 E4
R3 ---> k
opE3 ---> *
opE3 ---> /

E4 ---> opE4 E4
E4 ---> terminal
E4 ---> (E0)
opE4 ---> not
opE4 ---> -
terminal ---> NE
terminal ---> NV
terminal ---> NR
terminal ---> true
terminal ---> false
```

## First and Follow set

To implement this top down parser we need to create the [First and Follow](http://www.cs.nuim.ie/~jpower/Courses/Previous/parsing/node48.html)
set
