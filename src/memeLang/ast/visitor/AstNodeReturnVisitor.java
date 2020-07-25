package memeLang.ast.visitor;

import memeLang.ast.Ast;
import memeLang.ast.AstBinaryExpression;
import memeLang.ast.AstExpressionStatement;
import memeLang.ast.AstNumberExpression;

public interface AstNodeReturnVisitor<T> {
    T visit(Ast ast);

    T visit(AstExpressionStatement expressionStatement);

    T visit(AstBinaryExpression binaryExpression);

    T visit(AstNumberExpression numberExpression);
}
