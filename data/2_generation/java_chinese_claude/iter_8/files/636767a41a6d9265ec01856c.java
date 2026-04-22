import java.nio.charset.StandardCharsets;

public class UTF8Utils {
    /**
     * 计算从指定 {@code index} 开始，具有指定 {@code length} 长度的 UTF-8 字符串的大小。
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        int size = 0;
        final int end = index + len;
        
        for (int i = index; i < end; i++) {
            char c = str.charAt(i);
            
            if (c < 0x80) {
                // ASCII characters take 1 byte
                size++;
            } else if (c < 0x800) {
                // 2-byte UTF-8 characters
                size += 2;
            } else if (Character.isSurrogate(c)) {
                // 4-byte UTF-8 characters (surrogate pairs)
                // Skip the next character as it's part of the same code point
                i++;
                size += 4;
            } else {
                // 3-byte UTF-8 characters
                size += 3;
            }
        }
        
        return size;
    }
}