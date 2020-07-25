package brainFuckInterpreter.bootstrapping;

import brainFuckInterpreter.ast.Ast;
import brainFuckInterpreter.lexing.Lexer;
import brainFuckInterpreter.lexing.TokenStream;
import brainFuckInterpreter.parsing.Parser;
import brainFuckInterpreter.util.DiagnosticBag;

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
