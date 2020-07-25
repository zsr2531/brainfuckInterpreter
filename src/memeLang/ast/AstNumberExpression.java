package memeLang.ast;

public class AstNumberExpression extends AstExpression {
    private final int value;

    public AstNumberExpression(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public AstNode[] getChildren() {
        return new AstNode[0];
    }
}
