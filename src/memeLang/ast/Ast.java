package memeLang.ast;

import memeLang.ast.visitor.AstNodeReturnVisitor;
import memeLang.ast.visitor.AstNodeVisitor;

import java.util.ArrayList;

public class Ast extends AstNode {
    private final ArrayList<AstStatement> statements = new ArrayList<>();

    public void add(AstStatement statement) {
        statements.add(statement);
    }

    @Override
    public AstNode[] getChildren() {
        return (AstNode[]) statements.toArray();
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
