package memeLang.ast.visitor;

import memeLang.ast.*;

public interface AstNodeReturnVisitor<T> {
    T visit(Ast ast);

    T visit(AstIncrementCellStatement incrementCellStatement);

    T visit(AstDecrementCellStatement decrementCellStatement);

    T visit(AstShiftLeftStatement shiftLeftStatement);

    T visit(AstShiftRightStatement shiftRightStatement);

    T visit(AstPrintStatement printStatement);

    T visit(AstInputStatement inputStatement);

    T visit(AstLoopStatement loopStatement);
}
