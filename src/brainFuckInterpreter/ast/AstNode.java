package brainFuckInterpreter.ast;

import brainFuckInterpreter.ast.visitor.AstNodeReturnVisitor;
import brainFuckInterpreter.ast.visitor.AstNodeVisitor;

public abstract class AstNode {
    public abstract AstNode[] getChildren();

    public abstract <T> void accept(AstNodeVisitor<T> visitor, T state);

    public abstract <T> T accept(AstNodeReturnVisitor<T> visitor);
}
