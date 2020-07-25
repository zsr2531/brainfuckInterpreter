package brainFuckInterpreter.commandLine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CommandLineParser {
    private final String[] args;

    private static final Map<String, CommandLineSwitch> FLAGS = new HashMap<>();
    private static final Map<String, CommandLineSwitch> OPTIONS = new HashMap<>();

    public CommandLineParser(String[] args) {
        this.args = args;
    }

    static {
        for (var sw : CommandLineSwitches.ALL_SWITCHES) {
            var collection = sw instanceof CommandLineFlag ? FLAGS : OPTIONS;
            for (var identifier : sw.getIdentifiers()) {
                collection.put(identifier, sw);
            }
        }
    }

    public CommandLineParserResult parseCommandLineArguments() throws CommandLineParserException {
        var flags = new HashSet<CommandLineFlag>();
        var options = new HashMap<CommandLineOption, String>();
        String inputFile = null;
        for (int i = 0; i < args.length; i++) {
            var arg = args[i];
            if (arg.charAt(0) == '-') {
                if (OPTIONS.containsKey(arg)) {
                    if (++i >= args.length)
                        throw new CommandLineParserException("Expected value for option: '" + arg + "'");

                    options.put((CommandLineOption) OPTIONS.get(arg), args[i]);
                } else if (FLAGS.containsKey(arg)) flags.add((CommandLineFlag) FLAGS.get(arg));
                else throw new CommandLineParserException("Unknown flag or option: '" + arg + "'");
            } else if (inputFile == null) inputFile = arg;
            else throw new CommandLineParserException("Expected flag or option but got: '" + arg + "'");
        }

        return new CommandLineParserResult(flags, options, inputFile);
    }
}
