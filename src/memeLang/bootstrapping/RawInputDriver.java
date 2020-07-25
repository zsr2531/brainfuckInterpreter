package memeLang.bootstrapping;

import memeLang.lexing.Lexer;
import memeLang.lexing.Token;

import java.util.stream.Stream;

public class RawInputDriver extends Driver {
    private final String input;

    public RawInputDriver(String input) {
        super();
        this.input = input;
    }

    @Override
    public Stream<Token> tokenize() {
        return new Lexer(input).lex();
    }
}
