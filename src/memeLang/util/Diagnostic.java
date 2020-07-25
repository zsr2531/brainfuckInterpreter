package memeLang.util;

import memeLang.lexing.TextSpan;

import java.util.Objects;

public class Diagnostic {
    private final TextSpan span;
    private final String message;

    public Diagnostic(TextSpan span, String message) {
        this.span = span;
        this.message = message;
    }

    public TextSpan getSpan() {
        return span;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Diagnostic that = (Diagnostic) o;
        return span.equals(that.span) &&
            message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(span, message);
    }

    @Override
    public String toString() {
        return "(" + span.getStart() + "," + span.getEnd() + "): " + message;
    }
}
