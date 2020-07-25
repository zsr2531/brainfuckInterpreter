package memeLang.lexing;

import java.util.Objects;

public class Token {
    private final int position;
    private final TokenKind type;

    public Token(int position, TokenKind type) {
        this.position = position;
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public TokenKind getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Token token = (Token) o;
        return position == token.position &&
            type == token.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, type);
    }

    @Override
    public String toString() {
        return "Token{" +
            "position=" + position +
            ", type=" + type +
            '}';
    }
}