package memeLang.parsing;

import memeLang.ast.Ast;
import memeLang.lexing.TokenStream;
import memeLang.util.DiagnosticBag;

public class Parser {
    private final DiagnosticBag diagnostics;
    private final TokenStream tokens;

    public Parser(DiagnosticBag diagnostics, TokenStream tokens) {
        this.diagnostics = diagnostics;
        this.tokens = tokens;
    }

    public Ast parse() {
        return new Ast();
    }
}
