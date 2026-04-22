import java.nio.charset.StandardCharsets;

public class UTF8SizeCalculator {

    /** 
     * Computes the size of the utf8 string beginning at the specified  {@code index} with the specified {@code length}.
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (index < 0 || len < 0 || index + len > str.length()) {
            throw new IndexOutOfBoundsException("Index or length is out of bounds");
        }

        String substring = str.subSequence(index, index + len).toString();
        byte[] utf8Bytes = substring.getBytes(StandardCharsets.UTF_8);
        return utf8Bytes.length;
    }

    public static void main(String[] args) {
        String testString = "Hello, 世界!";
        int size = computeUTF8Size(testString, 0, testString.length());
        System.out.println("UTF-8 size: " + size);
    }
}