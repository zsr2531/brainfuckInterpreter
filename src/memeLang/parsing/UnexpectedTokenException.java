package memeLang.parsing;

import memeLang.lexing.TextSpan;
import memeLang.lexing.Token;
import memeLang.lexing.TokenKind;

public class UnexpectedTokenException extends Exception {
    private final TextSpan span;

    public UnexpectedTokenException(TokenKind expected, Token token) {
        super("(" + token.getSpan() + "): Expected <" + expected + ">, but got <" + token.getType() + ">");
        this.span = token.getSpan();
    }

    public TextSpan getSpan() {
        return span;
    }
}
