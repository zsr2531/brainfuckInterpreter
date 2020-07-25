package memeLang.lexing;

import memeLang.util.Diagnostic;
import memeLang.util.DiagnosticBag;

import java.util.stream.Stream;

public class Lexer {
    private final DiagnosticBag diagnostics;
    private final String input;
    private int position;

    public Lexer(DiagnosticBag diagnostics, String input) {
        this.input = input;
        this.diagnostics = diagnostics;
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

        if (Character.isAlphabetic(current) || current == '_') {
            var builder = new StringBuilder();

            while (Character.isLetterOrDigit(getCurrent()))
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
        switch (current) {
            case '+':
                return new Token(span, TokenKind.Plus, advance());
            case '-':
                return new Token(span, TokenKind.Minus, advance());
            case '*':
                return new Token(span, TokenKind.Star, advance());
            case '/':
                return new Token(span, TokenKind.Slash, advance());
            default:
                diagnostics.add(new Diagnostic(span, "Unexpected character: " + current));
                return new Token(span, TokenKind.Bad, advance());
        }
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
