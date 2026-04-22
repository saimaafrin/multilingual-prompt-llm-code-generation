import java.nio.charset.StandardCharsets;

public class UTF8SizeCalculator {

    /**
     * Computes the size of the utf8 string beginning at the specified {@code index} with the specified {@code length}.
     *
     * @param str   the input character sequence
     * @param index the starting index of the substring
     * @param len   the length of the substring
     * @return the size of the UTF-8 encoded substring in bytes
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        if (str == null || index < 0 || len < 0 || index + len > str.length()) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        String substring = str.subSequence(index, index + len).toString();
        byte[] utf8Bytes = substring.getBytes(StandardCharsets.UTF_8);
        return utf8Bytes.length;
    }

    public static void main(String[] args) {
        CharSequence str = "Hello, 世界";
        int index = 7;
        int len = 2;
        int size = computeUTF8Size(str, index, len);
        System.out.println("UTF-8 size: " + size); // Output: UTF-8 size: 6
    }
}