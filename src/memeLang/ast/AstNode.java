package memeLang.ast;

import memeLang.ast.visitor.AstNodeReturnVisitor;
import memeLang.ast.visitor.AstNodeVisitor;

public abstract class AstNode {
    public abstract AstNode[] getChildren();

    public abstract <T> void Accept(AstNodeVisitor<T> visitor, T state);

    public abstract <T> T Accept(AstNodeReturnVisitor<T> visitor);
}
