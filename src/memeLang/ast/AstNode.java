package memeLang.ast;

import memeLang.ast.visitor.AstNodeReturnVisitor;
import memeLang.ast.visitor.AstNodeVisitor;

public abstract class AstNode {
    public abstract AstNode[] getChildren();

    public abstract void Accept(AstNodeVisitor visitor);

    public abstract <T> T Accept(AstNodeReturnVisitor<T> visitor);
}
