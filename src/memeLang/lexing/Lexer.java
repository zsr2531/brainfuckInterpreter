package memeLang.lexing;

import java.util.stream.Stream;

public class Lexer {
    private final String input;
    private int position;

    public Lexer(String input) {
        this.input = input;
    }

    public Stream<Token> lex() {
        return Stream.generate(this::supply);
    }

    private Token supply() {
        int start = position;
        char current = getCurrent();
        if (current == '\0')
            return new Token(new TextSpan(start, position), TokenKind.EndOfFile, null);

        if (Character.isWhitespace(current)) {
            var builder = new StringBuilder();

            while (Character.isWhitespace(getCurrent()))
                builder.append(advance());

            return new Token(new TextSpan(start, position - 1), TokenKind.Whitespace, builder.toString());
        }

        if (Character.isAlphabetic(current)) {
            var builder = new StringBuilder();

            while (Character.isAlphabetic(getCurrent()))
                builder.append(advance());

            return new Token(new TextSpan(start, position - 1), TokenKind.Identifier, builder.toString());
        }

        if (Character.isDigit(current)) {
            var builder = new StringBuilder();

            while (Character.isDigit(getCurrent()))
                builder.append(advance());

            return new Token(new TextSpan(start, position - 1), TokenKind.Number, Integer.parseInt(builder.toString()));
        }

        var span = new TextSpan(start, position);
        return switch (current) {
            case '+' -> new Token(span, TokenKind.Plus, advance());
            case '-' -> new Token(span, TokenKind.Minus, advance());
            case '*' -> new Token(span, TokenKind.Star, advance());
            case '/' -> new Token(span, TokenKind.Slash, advance());
            default -> new Token(span, TokenKind.Bad, advance());
        };
    }

    private char getCurrent() {
        if (position >= input.length())
            return '\0';

        return input.charAt(position);
    }

    private char advance() {
        var character = getCurrent();
        position++;

        return character;
    }
}
