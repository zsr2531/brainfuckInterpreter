package memeLang.bootstrapping;

import memeLang.lexing.Lexer;
import memeLang.lexing.TokenStream;
import memeLang.util.DiagnosticBag;

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
    public void close() {
        scanner.close();
    }
}
