package brainFuckInterpreter.commandLine;

public class CommandLineOption extends CommandLineSwitch {
    private final String defaultValue;

    public CommandLineOption(String description, String defaultValue, String[] identifiers) {
        super(description, identifiers);
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
