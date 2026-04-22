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

        int size = 0;
        for (int i = index; i < index + len; i++) {
            char c = str.charAt(i);
            if (c <= 0x7F) {
                size += 1; // 1 byte for ASCII
            } else if (c <= 0x7FF) {
                size += 2; // 2 bytes for characters in range 0x80 to 0x7FF
            } else if (c >= 0xD800 && c <= 0xDFFF) {
                // Surrogate pair
                if (i + 1 < index + len) {
                    char next = str.charAt(i + 1);
                    if (next >= 0xDC00 && next <= 0xDFFF) {
                        size += 4; // 4 bytes for surrogate pairs
                        i++; // Skip the next character
                    } else {
                        throw new IllegalArgumentException("Invalid surrogate pair");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid surrogate pair");
                }
            } else {
                size += 3; // 3 bytes for characters in range 0x800 to 0xFFFF
            }
        }
        return size;
    }

    public static void main(String[] args) {
        String testString = "Hello, 你好!";
        int size = computeUTF8Size(testString, 0, testString.length());
        System.out.println("UTF-8 size: " + size);
    }
}