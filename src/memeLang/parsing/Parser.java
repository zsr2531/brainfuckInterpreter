package memeLang.parsing;

import memeLang.lexing.Token;

import java.util.stream.Stream;

public class Parser {
    private final Stream<Token> tokens;

    public Parser(Stream<Token> tokens) {
        this.tokens = tokens;
    }
}
