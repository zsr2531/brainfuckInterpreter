package memeLang.ast;

public class AstBinaryExpression extends AstExpression {
    private final AstExpression left;
    private final AstExpression right;
    private final BinaryOperationKind operation;

    public AstBinaryExpression(AstExpression left, AstExpression right, BinaryOperationKind operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public AstExpression getLeft() {
        return left;
    }

    public AstExpression getRight() {
        return right;
    }

    public BinaryOperationKind getOperation() {
        return operation;
    }

    @Override
    public AstNode[] getChildren() {
        return new AstNode[] {
            left,
            right
        };
    }
}
