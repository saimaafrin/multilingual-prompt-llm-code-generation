import java.nio.charset.StandardCharsets;

public class UTF8SizeCalculator {

    /** 
     * 计算从指定 {@code index} 开始，具有指定 {@code length} 长度的 UTF-8 字符串的大小。
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (index < 0 || len < 0 || index + len > str.length()) {
            throw new IndexOutOfBoundsException("Index or length is out of bounds");
        }

        String substring = str.subSequence(index, index + len).toString();
        return substring.getBytes(StandardCharsets.UTF_8).length;
    }

    public static void main(String[] args) {
        String testString = "Hello, 世界"; // Example string
        int size = computeUTF8Size(testString, 0, 5); // Calculate size of "Hello"
        System.out.println("UTF-8 size: " + size); // Output the size
    }
}