# brainfuckInterpreter
A simple brainfuck interpreter (and compiler) written in Java.

# What is the goal of this project?
The goal was to write a very simple parser. It parser the input into an **A**bstract **S**yntax **T**ree. This tree can be used for interpretation (this project comes with one) or you could even implement a code generator for it.

# Usage
- To run brainfuck code from a file: `java -jar brainfuckInterpreter.jar code.bf`
- To run brainfuck code from a command line argument: `java -jar brainfuckInterpreter.jar -e "-[------->+<]>-.-[->+++++<]>++.+++++++..+++.[--->+<]>-----.---[->+++<]>.-[--->+<]>---.+++.------.--------."`
