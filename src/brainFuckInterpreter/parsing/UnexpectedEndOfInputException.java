package brainFuckInterpreter.parsing;

public class UnexpectedEndOfInputException extends Exception {
    private final int position;

    public UnexpectedEndOfInputException(int position) {
        super("Unexpected end of input");
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
