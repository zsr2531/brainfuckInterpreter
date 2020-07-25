package brainFuckInterpreter.parsing;

import brainFuckInterpreter.lexing.Token;

public class UnexpectedTokenException extends Exception {
    private final int position;

    public UnexpectedTokenException(Token token) {
        super("Unexpected token <" + token.getType() + ">");
        this.position = token.getPosition();
    }

    public int getPosition() {
        return position;
    }
}
