package memeLang.commandLine;

import java.util.Arrays;
import java.util.Objects;

public abstract class CommandLineSwitch {
    private final String description;
    private final String[] identifiers;

    protected CommandLineSwitch(String description, String[] identifiers) {
        this.description = description;
        this.identifiers = identifiers;
        CommandLineSwitches.ALL_SWITCHES.add(this);
    }

    public String getDescription() {
        return description;
    }

    public String[] getIdentifiers() {
        return identifiers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        final var that = (CommandLineSwitch) o;
        return description.equals(that.description) && Arrays.equals(identifiers, that.identifiers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(description);
        result = 31 * result + Arrays.hashCode(identifiers);
        return result;
    }

    @Override
    public String toString() {
        return "CommandLineSwitch{" + "description='" + description + '\'' +
            ", identifiers=" + Arrays.toString(identifiers) + '}';
    }
}
