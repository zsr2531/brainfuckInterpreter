package memeLang.parsing;

import memeLang.lexing.Token;
import memeLang.lexing.TokenKind;

public class UnexpectedTokenException extends Exception {
    private final int position;

    public UnexpectedTokenException(TokenKind expected, Token token) {
        super("(" + token.getPosition() + "): Expected <" + expected + ">, but got <" + token.getType() + ">");
        this.position = token.getPosition();
    }

    public int getPosition() {
        return position;
    }
}
