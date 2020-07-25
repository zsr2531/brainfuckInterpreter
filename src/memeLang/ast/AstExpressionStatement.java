package memeLang.ast;

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
}
