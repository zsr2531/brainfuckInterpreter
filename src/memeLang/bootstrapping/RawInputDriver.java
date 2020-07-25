package memeLang.bootstrapping;

import memeLang.ast.Ast;
import memeLang.lexing.Lexer;
import memeLang.lexing.TokenStream;
import memeLang.parsing.Parser;
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

    @Override
    public Ast parse(TokenStream tokens) {
        return new Parser(diagnostics, tokens).parse();
    }
}
