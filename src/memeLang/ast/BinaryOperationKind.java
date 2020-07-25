package memeLang.ast;

public enum BinaryOperationKind {
    Addition,
    Subtraction,
    Multiplication,
    Division;

    public int getBinaryOperatorPrecedence() {
        return switch (this) {
            case Addition -> 1;
            case Subtraction -> 2;
            case Multiplication -> 3;
            case Division -> 4;
        };
    }

    public static BinaryOperationKind fromChar(char character) {
        return switch (character) {
            case '+' -> Addition;
            case '-' -> Subtraction;
            case '*' -> Multiplication;
            case '/' -> Division;
            default -> null;
        };
    }
}
