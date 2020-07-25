package memeLang.parsing;

import memeLang.lexing.Token;

public class UnexpectedTokenException extends Exception {
    private final int position;

    public UnexpectedTokenException(Token token) {
        super("(" + token.getPosition() + "): Unexpected token <" + token.getType() + ">");
        this.position = token.getPosition();
    }

    public int getPosition() {
        return position;
    }
}
