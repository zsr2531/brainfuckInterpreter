package memeLang.bootstrapping;

import memeLang.lexing.Token;
import memeLang.util.DiagnosticBag;

import java.util.stream.Stream;

public abstract class Driver implements AutoCloseable {
    protected final DiagnosticBag diagnostics;

    protected Driver(DiagnosticBag diagnostics) {
        this.diagnostics = diagnostics;
    }

    public abstract Stream<Token> tokenize();

    @Override
    public void close() { }
}
