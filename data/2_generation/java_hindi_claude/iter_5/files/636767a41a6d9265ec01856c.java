import java.nio.charset.StandardCharsets;

public class UTF8Utils {
    /**
     * Computes the size of the utf8 string beginning at the specified {@code index} with the specified {@code length}.
     *
     * @param str The input string to compute UTF-8 size for
     * @param index The starting index in the string
     * @param length The length of characters to process
     * @return The size in bytes of the UTF-8 encoded substring
     */
    public static int computeUTF8Size(String str, int index, int length) {
        if (str == null) {
            return 0;
        }
        
        if (index < 0 || length < 0 || index + length > str.length()) {
            throw new IllegalArgumentException("Invalid index or length parameters");
        }

        String substring = str.substring(index, index + length);
        byte[] utf8Bytes = substring.getBytes(StandardCharsets.UTF_8);
        return utf8Bytes.length;
    }
}