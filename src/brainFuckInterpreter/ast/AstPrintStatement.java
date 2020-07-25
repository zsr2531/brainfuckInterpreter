package brainFuckInterpreter.ast;

import brainFuckInterpreter.ast.visitor.AstNodeReturnVisitor;
import brainFuckInterpreter.ast.visitor.AstNodeVisitor;

public class AstPrintStatement extends AstStatement {
    @Override
    public AstNode[] getChildren() {
        return new AstNode[0];
    }

    @Override
    public <T> void accept(AstNodeVisitor<T> visitor, T state) {
        visitor.visit(this, state);
    }

    @Override
    public <T> T accept(AstNodeReturnVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
