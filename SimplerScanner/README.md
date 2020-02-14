# Scanner

This program is the responsible of reading character by character the input file and grouping then into ***lexical units*** which
are also called ***tokens*** and each token is a structure that follows this pattern: (lexeme,morpheme).

The lexeme is the lexical class that a token belongs and the morpheme is the value of the token.

Example:

|__Lexical class__|         __Posible values__             |
|-----------------|----------------------------------------|
| operator        | ```+```,```-```,```*```                |
| keyword         | ```while```,```if```,```return```      |
| literal         | ```true```,```10```,```"Hello World"```|
| comments        | ```//this is a comment```              |

The scanner returns a token which contains the lexical class and cero or more attributes like the value and the number of
the column and row where the token was accepted.

Each lexical class has to be predefined by the programming languague and the method to accept the token is through a ***finite
deterministic automata*** and because of that we have to use ***regular expressions*** to define each lexical class.

## Languague Definition

We will consider a programming languague with the following requisites:

- It will have a section for declaring variables and another section for writing instructions. Both section will be separated by ```&&```
- The section for declaring variable it is made up by one or more declaration separated by ```;```
  - Each declaration is in the form of ```*type name* *variable name*;```
  - The allowed type names are:
    - int
    - real
    - bool
  - The variable name has to have the following structure: 
    - It has to start with a letter and before that it can have a sequence of cero or more letters, digits or underscore ( **_** )
- The section for writing instructions it is made up by one or more instructions separated by ```;``` and each 
instruction must be an assignment.
  - Each assignment is in the form of ```*variable name* = *expresion*;```
  - Each expression can employ operands wiht:
    - Integer numbers with or without the sign following the [requirement]()
    - Real numbers with or without the sign following the [requirement]()
    - Other variables
    - True or false
  - The Integer numbers starts (optionally) with a sign before a sequence of one or more digits (the use of zeroes
  at the left is forbidden)
  - The Real numbers starts (optionally) with a sign before an Integer number and be followed (optionally) by a decimal part and or an exponential part
    - The decimal part starts with a dot ( ***.*** ) before a sequence of one or more digits (the use of zeroes at the right is forbidden)
    - The exponencial part starts with the letter **e** or **E** before an Integer number
    
