package brainFuckInterpreter.util;

import java.util.Objects;

public class Diagnostic {
    private final int position;
    private final String message;

    public Diagnostic(int position, String message) {
        this.position = position;
        this.message = message;
    }

    public int getPosition() {
        return position;
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
        return position == that.position &&
            message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, message);
    }

    @Override
    public String toString() {
        return "(" + position + "): " + message;
    }
}
