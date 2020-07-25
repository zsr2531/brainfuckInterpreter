package memeLang;

import memeLang.commandLine.CommandLineParser;
import memeLang.commandLine.CommandLineParserException;
import memeLang.commandLine.CommandLineSwitches;
import memeLang.factories.DriverFactory;
import memeLang.lexing.TokenKind;
import memeLang.util.DiagnosticBag;
import memeLang.util.StringUtils;

public final class Main {
    public static void main(String[] args) {
        try {
            var parser = new CommandLineParser(args);
            var result = parser.parseCommandLineArguments();
            if (result.hasFlag(CommandLineSwitches.HELP)) {
                printHelp();
                return;
            }

            if (result.hasFlag(CommandLineSwitches.VERSION)){
                System.out.println("MemeLang compiler v1.0.0");
                return;
            }

            var diagnostics = new DiagnosticBag();
            var driver = DriverFactory.Create(diagnostics, result);
            var tokens = driver.tokenize();
            var ast = driver.parse(tokens);
            System.out.println(ast.getChildren().length);
        } catch (CommandLineParserException e) {
            System.err.println("An error occurred while parsing command line arguments: " + e.getMessage());
            System.err.println("For a list of valid command line arguments use '-h' or '--help'");
        }
    }

    private static void printHelp() {
        var builder = new StringBuilder("Command line arguments:\n\n");

        for (var sw : CommandLineSwitches.ALL_SWITCHES) {
            var identifiers = String.join(", ", sw.getIdentifiers());
            builder.append(StringUtils.padRight("  " + identifiers, 25));
            builder.append(sw.getDescription()).append("\n");
        }

        System.out.println(builder.toString());
    }
}
