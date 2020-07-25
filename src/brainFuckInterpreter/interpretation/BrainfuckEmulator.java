package brainFuckInterpreter.interpretation;

import brainFuckInterpreter.ast.*;
import brainFuckInterpreter.ast.visitor.AstNodeVisitor;

public class BrainfuckEmulator implements AstNodeVisitor<ProgramState> {
    @Override
    public void visit(Ast ast, ProgramState state) {
        for (var child : ast.getStatements())
            child.accept(this, state);
    }

    @Override
    public void visit(AstIncrementCellStatement incrementCellStatement, ProgramState state) {
        state.incrementCellAtCellPointer();
    }

    @Override
    public void visit(AstDecrementCellStatement decrementCellStatement, ProgramState state) {
        state.decrementCellAtCellPointer();
    }

    @Override
    public void visit(AstShiftLeftStatement shiftLeftStatement, ProgramState state) {
        state.decrementCellPointer();
    }

    @Override
    public void visit(AstShiftRightStatement shiftRightStatement, ProgramState state) {
        state.incrementCellPointer();
    }

    @Override
    public void visit(AstPrintStatement printStatement, ProgramState state) {
        state.printCurrentCell();
    }

    @Override
    public void visit(AstInputStatement inputStatement, ProgramState state) {
        state.readIntoCell();
    }

    @Override
    public void visit(AstLoopStatement loopStatement, ProgramState state) {
        while (state.valueAtCellPointer() != 0) {
            for (var child : loopStatement.getStatements())
                child.accept(this, state);
        }
    }
}
