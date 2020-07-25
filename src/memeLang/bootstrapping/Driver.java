package memeLang.bootstrapping;

import memeLang.lexing.Token;

import java.util.stream.Stream;

public abstract class Driver implements AutoCloseable {
    public abstract Stream<Token> tokenize();

    @Override
    public void close() { }
}
