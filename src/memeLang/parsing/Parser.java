package memeLang.parsing;

import memeLang.lexing.Token;
import memeLang.util.DiagnosticBag;

import java.util.stream.Stream;

public class Parser {
    private final DiagnosticBag diagnostics;
    private final Stream<Token> tokens;

    public Parser(DiagnosticBag diagnostics, Stream<Token> tokens) {
        this.diagnostics = diagnostics;
        this.tokens = tokens;
    }
}
