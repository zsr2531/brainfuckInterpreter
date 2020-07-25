package brainFuckInterpreter.factories;

import brainFuckInterpreter.bootstrapping.Driver;
import brainFuckInterpreter.bootstrapping.RawInputDriver;
import brainFuckInterpreter.commandLine.CommandLineParserResult;
import brainFuckInterpreter.commandLine.CommandLineSwitches;
import brainFuckInterpreter.util.DiagnosticBag;

import java.io.FileNotFoundException;

public final class DriverFactory {
    public static Driver Create(DiagnosticBag diagnostics, CommandLineParserResult parserResult) {
        if (parserResult.getInputFile() != null) {
            try {
                return FileInputDriverFactory.Create(diagnostics, parserResult.getInputFile());
            } catch (FileNotFoundException e) {
                System.err.println("Can't find the file: '" + parserResult.getInputFile() + "'");
            }
        }

        return new RawInputDriver(diagnostics, parserResult.getOptionOrDefault(CommandLineSwitches.EVALUATE));
    }
}
