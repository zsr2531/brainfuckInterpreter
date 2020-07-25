package memeLang.bootstrapping;

import memeLang.lexing.Lexer;
import memeLang.lexing.TokenStream;
import memeLang.util.DiagnosticBag;

public class RawInputDriver extends Driver {
    private final String input;

    public RawInputDriver(DiagnosticBag diagnostics, String input) {
        super(diagnostics);
        this.input = input;
    }

    @Override
    public TokenStream tokenize() {
        return new Lexer(input).lex();
    }
}
