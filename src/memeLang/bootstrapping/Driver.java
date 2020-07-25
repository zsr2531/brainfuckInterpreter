package memeLang.bootstrapping;

import memeLang.lexing.TokenStream;
import memeLang.util.DiagnosticBag;

public abstract class Driver implements AutoCloseable {
    protected final DiagnosticBag diagnostics;

    protected Driver(DiagnosticBag diagnostics) {
        this.diagnostics = diagnostics;
    }

    public abstract TokenStream tokenize();

    @Override
    public void close() { }
}
