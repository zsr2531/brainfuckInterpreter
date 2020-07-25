package brainFuckInterpreter.factories;

import brainFuckInterpreter.bootstrapping.FileInputDriver;
import brainFuckInterpreter.util.DiagnosticBag;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class FileInputDriverFactory {
    public static FileInputDriver Create(DiagnosticBag diagnostics, String path) throws FileNotFoundException {
        var file = new File(path);
        var scanner = new Scanner(file);

        return new FileInputDriver(diagnostics, scanner);
    }
}
