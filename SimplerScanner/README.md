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
