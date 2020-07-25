package memeLang.commandLine;

import java.util.ArrayList;

public final class CommandLineSwitches {
    public static final ArrayList<CommandLineSwitch> ALL_SWITCHES = new ArrayList<>();

    public static CommandLineOption EVALUATE = new CommandLineOption("Evaluates an expression", "", new String[] {
        "-e", "--evaluate"
    });

    public static final CommandLineFlag HELP = new CommandLineFlag("Shows a help message", new String[] {
        "-h", "--help"
    });

    public static final CommandLineFlag VERSION = new CommandLineFlag("Shows the version", new String[] {
        "-v", "--version"
    });

    public static final CommandLineFlag DUMP_PARSE_TREE = new CommandLineFlag("Pretty prints the parse tree", new String[] {
        "--dump-parse-tree"
    });
}
