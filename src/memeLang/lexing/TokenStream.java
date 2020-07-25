package memeLang.lexing;

public class TokenStream {
    private final TokenSupplier supplier;

    public TokenStream(TokenSupplier supplier) {
        this.supplier = supplier;
    }

    public Token advance() {
        return supplier.supply();
    }
}
