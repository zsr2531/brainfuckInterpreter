package brainFuckInterpreter.bootstrapping;

import brainFuckInterpreter.ast.Ast;
import brainFuckInterpreter.lexing.Lexer;
import brainFuckInterpreter.lexing.TokenStream;
import brainFuckInterpreter.parsing.Parser;
import brainFuckInterpreter.util.DiagnosticBag;

import java.util.Scanner;

public class FileInputDriver extends Driver {
    private final Scanner scanner;

    public FileInputDriver(DiagnosticBag diagnostics, Scanner scanner) {
        super(diagnostics);
        this.scanner = scanner;
    }

    @Override
    public TokenStream tokenize() {
        return new Lexer(scanner.next()).lex();
    }

    @Override
    public Ast parse(TokenStream tokens) {
        return new Parser(diagnostics, tokens).parse();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
