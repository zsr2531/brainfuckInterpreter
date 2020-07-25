package brainFuckInterpreter.commandLine;

import java.util.Map;
import java.util.Set;

public class CommandLineParserResult {
    private final Set<CommandLineFlag> flags;
    private final Map<CommandLineOption, String> options;
    private final String inputFile;

    public CommandLineParserResult(
        Set<CommandLineFlag> flags,
        Map<CommandLineOption, String> options,
        String inputFile
    ) {
        this.flags = flags;
        this.options = options;
        this.inputFile = inputFile;
    }

    public Set<CommandLineFlag> getFlags() {
        return flags;
    }

    public Map<CommandLineOption, String> getOptions() {
        return options;
    }

    public String getInputFile() {
        return inputFile;
    }

    public boolean hasFlag(CommandLineFlag flag) {
        return getFlags().contains(flag);
    }

    public String getOptionOrDefault(CommandLineOption option) {
        var options = getOptions();
        if (options.containsKey(option))
            return options.get(option);

        return option.getDefaultValue();
    }
}
