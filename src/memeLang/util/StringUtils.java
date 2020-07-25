package memeLang.util;

public final class StringUtils {
    public static String padRight(String str, int size) {
        if (str.length() >= size)
            return str;

        var paddingLength = size - str.length();
        var padding = " ".repeat(paddingLength);

        return str + padding;
    }
}
