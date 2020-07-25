package memeLang.ast;

import memeLang.ast.visitor.AstNodeReturnVisitor;
import memeLang.ast.visitor.AstNodeVisitor;

import java.util.ArrayList;

public class AstLoopStatement extends AstStatement {
    private final ArrayList<AstStatement> statements;

    public AstLoopStatement(ArrayList<AstStatement> statements) {
        this.statements = statements;
    }

    public ArrayList<AstStatement> getStatements() {
        return statements;
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
