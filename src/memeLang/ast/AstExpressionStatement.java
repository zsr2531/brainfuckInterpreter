package memeLang.ast;

import memeLang.ast.visitor.AstNodeReturnVisitor;
import memeLang.ast.visitor.AstNodeVisitor;

public class AstExpressionStatement extends AstStatement {
    private final AstExpression expression;

    public AstExpressionStatement(AstExpression expression) {
        this.expression = expression;
    }

    public AstExpression getExpression() {
        return expression;
    }

    @Override
    public AstNode[] getChildren() {
        return new AstNode[] {
            expression
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
