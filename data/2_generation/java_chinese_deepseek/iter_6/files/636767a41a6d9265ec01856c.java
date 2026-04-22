import java.nio.charset.StandardCharsets;

public class UTF8SizeCalculator {

    /**
     * 计算从指定 {@code index} 开始，具有指定 {@code length} 长度的 UTF-8 字符串的大小。
     *
     * @param str   输入的字符序列
     * @param index 开始计算的索引
     * @param len   要计算的字符长度
     * @return UTF-8 编码后的字节大小
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (index < 0 || len < 0 || index + len > str.length()) {
            throw new IllegalArgumentException("Invalid index or length");
        }

        String substring = str.subSequence(index, index + len).toString();
        byte[] utf8Bytes = substring.getBytes(StandardCharsets.UTF_8);
        return utf8Bytes.length;
    }

    public static void main(String[] args) {
        CharSequence str = "Hello, 世界!";
        int index = 7;
        int len = 2;
        int size = computeUTF8Size(str, index, len);
        System.out.println("UTF-8 size: " + size);  // 输出: UTF-8 size: 6
    }
}