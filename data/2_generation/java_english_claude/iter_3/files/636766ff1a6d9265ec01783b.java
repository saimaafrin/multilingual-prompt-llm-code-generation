import java.util.Objects;

public class StringUtils {

    /**
     * Gets a substring from the specified String avoiding exceptions.
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return null;
        }

        int strLen = str.length();

        if (start < 0) {
            start = 0;
        }
        if (end > strLen) {
            end = strLen;
        }

        if (start > end) {
            return "";
        }

        if (start > strLen) {
            return "";
        }

        return str.substring(start, end);
    }
}