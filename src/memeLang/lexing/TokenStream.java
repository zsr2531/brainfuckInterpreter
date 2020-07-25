package memeLang.lexing;

public class TokenStream {
    private final TokenSupplier supplier;
    private Token lookahead;

    public TokenStream(TokenSupplier supplier) {
        this.supplier = supplier;
    }

    public Token advance() {
        if (lookahead != null) {
            var temp = lookahead;
            lookahead = null;

            return temp;
        }

        return supplier.supply();
    }

    public Token lookahead() {
        return lookahead = supplier.supply();
    }
}
