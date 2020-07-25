package brainFuckInterpreter.bootstrapping;

import brainFuckInterpreter.ast.Ast;
import brainFuckInterpreter.lexing.TokenStream;
import brainFuckInterpreter.util.DiagnosticBag;

public abstract class Driver implements AutoCloseable {
    protected final DiagnosticBag diagnostics;

    protected Driver(DiagnosticBag diagnostics) {
        this.diagnostics = diagnostics;
    }

    public abstract TokenStream tokenize();

    public abstract Ast parse(TokenStream tokens);

    @Override
    public void close() { }
}
