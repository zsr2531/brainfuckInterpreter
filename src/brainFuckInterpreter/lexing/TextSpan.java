package brainFuckInterpreter.lexing;

import java.util.Objects;

public class TextSpan {
    private final int start;
    private final int end;

    public TextSpan(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getLength() {
        return getEnd() - getStart() + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TextSpan textSpan = (TextSpan) o;
        return start == textSpan.start && end == textSpan.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "TextSpan{" +
            "start=" + start +
            ", end=" + end +
            ", length=" + getLength() +
            '}';
    }
}
