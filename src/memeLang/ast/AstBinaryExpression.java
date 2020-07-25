package memeLang.ast;

import memeLang.ast.visitor.AstNodeReturnVisitor;
import memeLang.ast.visitor.AstNodeVisitor;

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

    @Override
    public void Accept(AstNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T Accept(AstNodeReturnVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
