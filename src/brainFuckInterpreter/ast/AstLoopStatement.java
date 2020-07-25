package brainFuckInterpreter.ast;

import brainFuckInterpreter.ast.visitor.AstNodeReturnVisitor;
import brainFuckInterpreter.ast.visitor.AstNodeVisitor;

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
        var buffer = new AstNode[statements.size()];
        for (int i = 0; i < statements.size(); i++) {
            buffer[i] = statements.get(i);
        }

        return buffer;
    }

    @Override
    public <T> void accept(AstNodeVisitor<T> visitor, T state) {
        visitor.visit(this, state);
    }

    @Override
    public <T> T accept(AstNodeReturnVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "AstLoopStatement";
    }
}
