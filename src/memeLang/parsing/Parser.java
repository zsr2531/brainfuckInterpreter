package memeLang.parsing;

import memeLang.ast.*;
import memeLang.lexing.Token;
import memeLang.lexing.TokenKind;
import memeLang.lexing.TokenStream;
import memeLang.util.Diagnostic;
import memeLang.util.DiagnosticBag;

import java.util.ArrayList;

public class Parser {
    private final DiagnosticBag diagnostics;
    private final TokenStream tokens;

    public Parser(DiagnosticBag diagnostics, TokenStream tokens) {
        this.diagnostics = diagnostics;
        this.tokens = tokens;
    }

    public Ast parse() {
        var root = new Ast();

        while (true) {
            AstStatement statement;

            try {
                statement = statement();
            } catch (UnexpectedTokenException e) {
                diagnostics.add(new Diagnostic(e.getPosition(), e.getMessage()));
                continue;
            } catch (UnexpectedEndOfInputException e) {
                diagnostics.add(new Diagnostic(e.getPosition(), e.getMessage()));
                break;
            }

            if (statement == null)
                break;

            root.add(statement);
        }

        return root;
    }

    private AstStatement statement() throws UnexpectedTokenException, UnexpectedEndOfInputException {
        var token = tokens.advance();
        return tokenToAst(token);
    }

    private AstStatement loopStatement() throws UnexpectedEndOfInputException, UnexpectedTokenException {
        var statements = new ArrayList<AstStatement>();
        while (tokens.lookahead().getType() != TokenKind.RightBracket) {
            var current = tokens.advance();
            if (current.getType() == TokenKind.EndOfFile)
                throw new UnexpectedEndOfInputException(current.getPosition());

            statements.add(tokenToAst(current));
        }

        tokens.advance();
        return new AstLoopStatement(statements);
    }

    private AstStatement tokenToAst(Token token) throws UnexpectedEndOfInputException, UnexpectedTokenException {
        return switch (token.getType()) {
            case LeftShift -> new AstShiftLeftStatement();
            case RightShift -> new AstShiftRightStatement();
            case Plus -> new AstIncrementCellStatement();
            case Minus -> new AstDecrementCellStatement();
            case Dot -> new AstPrintStatement();
            case Comma -> new AstInputStatement();
            case LeftBracket -> loopStatement();
            case RightBracket -> throw new UnexpectedTokenException(token);
            default -> null;
        };
    }
}
