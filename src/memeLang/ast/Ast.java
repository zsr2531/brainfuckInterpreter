package memeLang.ast;

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
}
