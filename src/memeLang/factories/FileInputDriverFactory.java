package memeLang.factories;

import memeLang.bootstrapping.FileInputDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class FileInputDriverFactory {
    public static FileInputDriver Create(String path) throws FileNotFoundException {
        var file = new File(path);
        var scanner = new Scanner(file);

        return new FileInputDriver(scanner);
    }
}
