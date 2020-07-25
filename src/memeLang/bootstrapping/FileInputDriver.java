package memeLang.bootstrapping;

import memeLang.lexing.Lexer;
import memeLang.lexing.Token;
import memeLang.util.DiagnosticBag;

import java.util.Scanner;
import java.util.stream.Stream;

public class FileInputDriver extends Driver {
    private final Scanner scanner;

    public FileInputDriver(DiagnosticBag diagnostics, Scanner scanner) {
        super(diagnostics);
        this.scanner = scanner;
    }

    @Override
    public Stream<Token> tokenize() {
        return new Lexer(diagnostics, scanner.next()).lex();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
