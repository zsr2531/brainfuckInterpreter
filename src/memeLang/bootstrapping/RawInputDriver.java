package memeLang.bootstrapping;

import memeLang.lexing.Lexer;
import memeLang.lexing.Token;
import memeLang.util.DiagnosticBag;

import java.util.stream.Stream;

public class RawInputDriver extends Driver {
    private final String input;

    public RawInputDriver(DiagnosticBag diagnostics, String input) {
        super(diagnostics);
        this.input = input;
    }

    @Override
    public Stream<Token> tokenize() {
        return new Lexer(diagnostics, input).lex();
    }
}
