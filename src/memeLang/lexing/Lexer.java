package memeLang.lexing;

import memeLang.util.Diagnostic;
import memeLang.util.DiagnosticBag;

public class Lexer {
    private final DiagnosticBag diagnostics;
    private final String input;
    private int position;

    public Lexer(DiagnosticBag diagnostics, String input) {
        this.input = input;
        this.diagnostics = diagnostics;
    }

    public TokenStream lex() {
        return new TokenStream(this::supply);
    }

    private Token supply() {
        int start = position;
        if (getCurrent() == '\0')
            return new Token(new TextSpan(start, position), TokenKind.EndOfFile, null);

        if (Character.isWhitespace(getCurrent())) {
            while (Character.isWhitespace(getCurrent()))
                advance();
        }

        if (Character.isAlphabetic(getCurrent()) || getCurrent() == '_') {
            var builder = new StringBuilder();

            while (Character.isLetterOrDigit(getCurrent()) || getCurrent() == '_')
                builder.append(advance());

            return new Token(new TextSpan(start, position - 1), TokenKind.Identifier, builder.toString());
        }

        if (Character.isDigit(getCurrent())) {
            var builder = new StringBuilder();

            while (Character.isDigit(getCurrent()))
                builder.append(advance());

            return new Token(new TextSpan(start, position - 1), TokenKind.Number, Integer.parseInt(builder.toString()));
        }

        var span = new TextSpan(start, position);
        switch (getCurrent()) {
            case '+':
                return new Token(span, TokenKind.Plus, advance());
            case '-':
                return new Token(span, TokenKind.Minus, advance());
            case '*':
                return new Token(span, TokenKind.Star, advance());
            case '/':
                return new Token(span, TokenKind.Slash, advance());
            default:
                diagnostics.add(new Diagnostic(span, "Unexpected character: " + getCurrent()));
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
