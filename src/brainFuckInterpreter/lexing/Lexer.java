package brainFuckInterpreter.lexing;

public class Lexer {
    private static final char[] VALID = new char[] {
        '<', '>', '+', '-', '[', ']', '.', ','
    };

    private final String input;
    private int position;

    public Lexer(String input) {
        this.input = input;
    }

    public TokenStream lex() {
        return new TokenStream(this::supply);
    }

    private Token supply() {
        if (getCurrent() == '\0')
            return new Token(position, TokenKind.EndOfFile);

        while (isIgnored(getCurrent()))
            position++;

        return switch (advance()) {
            case '<' -> new Token(position, TokenKind.LeftShift);
            case '>' -> new Token(position, TokenKind.RightShift);
            case '+' -> new Token(position, TokenKind.Plus);
            case '-' -> new Token(position, TokenKind.Minus);
            case '[' -> new Token(position, TokenKind.LeftBracket);
            case ']' -> new Token(position, TokenKind.RightBracket);
            case '.' -> new Token(position, TokenKind.Dot);
            case ',' -> new Token(position, TokenKind.Comma);
            default -> null;
        };
    }

    private char getCurrent() {
        if (position >= input.length())
            return '\0';

        return input.charAt(position);
    }

    private char advance() {
        var temp = getCurrent();
        position++;

        return temp;
    }

    private boolean isIgnored(char character) {
        for (char c : VALID) {
            if (c == character)
                return false;
        }

        return true;
    }
}
