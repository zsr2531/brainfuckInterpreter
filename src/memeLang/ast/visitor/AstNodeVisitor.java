package memeLang.ast.visitor;

import memeLang.ast.*;

public interface AstNodeVisitor<T> {
    void visit(Ast ast, T state);

    void visit(AstIncrementCellStatement incrementCellStatement, T state);

    void visit(AstDecrementCellStatement decrementCellStatement, T state);

    void visit(AstShiftLeftStatement shiftLeftStatement, T state);

    void visit(AstShiftRightStatement shiftRightStatement, T state);

    void visit(AstPrintStatement printStatement, T state);

    void visit(AstInputStatement inputStatement, T state);

    void visit(AstLoopStatement loopStatement, T state);
}
