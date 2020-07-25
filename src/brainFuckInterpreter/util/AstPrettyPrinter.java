package brainFuckInterpreter.util;

import brainFuckInterpreter.ast.Ast;
import brainFuckInterpreter.ast.AstNode;

public class AstPrettyPrinter {
    private final Ast ast;

    public AstPrettyPrinter(Ast ast) {
        this.ast = ast;
    }

    public void prettyPrint() {
        prettyPrint(ast, "", true);
    }

    // https://github.com/terrajobst/minsk/blob/c6812a81e81611c13ed3a1b1a8b5e802507c95ac/mc/Program.cs
    private void prettyPrint(AstNode node, String indent, boolean isLast) {
        var marker = isLast ? "└──" : "├──";
        System.out.print(indent);
        System.out.print(marker);
        System.out.println(node);

        indent += isLast ? "    " : "│   ";

        var children = node.getChildren();
        var lastChild = children[children.length - 1];

        for (var child : children)
            prettyPrint(child, indent, child == lastChild);
    }
}
