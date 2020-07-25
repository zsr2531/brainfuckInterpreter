package memeLang.ast.visitor;

import memeLang.ast.*;

public interface AstNodeVisitor {
    void visit(Ast ast);

    void visit(AstIncrementCellStatement incrementCellStatement);

    void visit(AstDecrementCellStatement decrementCellStatement);

    void visit(AstShiftLeftStatement shiftLeftStatement);

    void visit(AstShiftRightStatement shiftRightStatement);

    void visit(AstPrintStatement printStatement);

    void visit(AstInputStatement inputStatement);

    void visit(AstLoopStatement loopStatement);
}
