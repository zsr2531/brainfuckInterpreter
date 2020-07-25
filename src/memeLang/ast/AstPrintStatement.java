package memeLang.ast;

import memeLang.ast.visitor.AstNodeReturnVisitor;
import memeLang.ast.visitor.AstNodeVisitor;

public class AstPrintStatement extends AstStatement {
    @Override
    public AstNode[] getChildren() {
        return new AstNode[0];
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
