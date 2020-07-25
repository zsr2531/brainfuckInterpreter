package memeLang.bootstrapping;

import memeLang.lexing.Lexer;
import memeLang.lexing.Token;

import java.util.Scanner;
import java.util.stream.Stream;

public class FileInputDriver extends Driver {
    private final Scanner scanner;

    public FileInputDriver(Scanner scanner) {
        super();
        this.scanner = scanner;
    }

    @Override
    public Stream<Token> tokenize() {
        return new Lexer(scanner.next()).lex();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
