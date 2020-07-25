package memeLang.lexing;

import java.util.Objects;

public class Token {
    private final TextSpan span;
    private final TokenKind type;
    private final Object value;

    public Token(TextSpan span, TokenKind type, Object value) {
        this.span = span;
        this.type = type;
        this.value = value;
    }

    public TextSpan getSpan() {
        return span;
    }

    public TokenKind getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Token token = (Token) o;
        return span.equals(token.span) &&
            type == token.type &&
            Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(span, type, value);
    }

    @Override
    public String toString() {
        return "Token{" +
            "span=" + span.toString() +
            ", type=" + type +
            ", value=" + (value == null ? "<NULL>" : value) +
            '}';
    }
}