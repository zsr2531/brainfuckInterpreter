package memeLang.factories;

import memeLang.bootstrapping.Driver;
import memeLang.bootstrapping.RawInputDriver;
import memeLang.commandLine.CommandLineParserResult;
import memeLang.commandLine.CommandLineSwitches;

import java.io.FileNotFoundException;

public final class DriverFactory {
    public static Driver Create(CommandLineParserResult parserResult) {
        if (parserResult.getInputFile() != null) {
            try {
                return FileInputDriverFactory.Create(parserResult.getInputFile());
            } catch (FileNotFoundException e) {
                System.err.println("Can't find the file: '" + parserResult.getInputFile() + "'");
            }
        }

        return new RawInputDriver(parserResult.getOptionOrDefault(CommandLineSwitches.EVALUATE));
    }
}
