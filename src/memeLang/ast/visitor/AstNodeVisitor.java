package memeLang.ast.visitor;

import memeLang.ast.Ast;
import memeLang.ast.AstBinaryExpression;
import memeLang.ast.AstExpressionStatement;
import memeLang.ast.AstNumberExpression;

public interface AstNodeVisitor {
    void visit(Ast ast);

    void visit(AstExpressionStatement expressionStatement);

    void visit(AstBinaryExpression binaryExpression);

    void visit(AstNumberExpression numberExpression);
}
