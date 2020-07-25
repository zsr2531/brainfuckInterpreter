package memeLang.bootstrapping;

import memeLang.ast.Ast;
import memeLang.lexing.TokenStream;
import memeLang.util.DiagnosticBag;

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
