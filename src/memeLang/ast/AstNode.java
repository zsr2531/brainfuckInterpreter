package memeLang.ast;

import memeLang.ast.visitor.AstNodeReturnVisitor;
import memeLang.ast.visitor.AstNodeVisitor;

public abstract class AstNode {
    public abstract AstNode[] getChildren();

    public abstract <T> void accept(AstNodeVisitor<T> visitor, T state);

    public abstract <T> T accept(AstNodeReturnVisitor<T> visitor);
}
