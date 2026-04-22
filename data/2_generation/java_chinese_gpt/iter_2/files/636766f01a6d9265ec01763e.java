import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetConverter {

    /** 
     * 将MIME标准字符集名称转换为Java等效名称。
     * @param charset MIME标准名称。
     * @return 此名称的Java等效名称。
     */
    private static String javaCharset(String charset) {
        if (charset == null) {
            return null;
        }
        try {
            Charset javaCharset = Charset.forName(charset);
            return javaCharset.name();
        } catch (IllegalArgumentException e) {
            return null; // 返回null如果没有找到对应的Java字符集
        }
    }

    public static void main(String[] args) {
        // 测试示例
        System.out.println(javaCharset("UTF-8")); // 输出: UTF-8
        System.out.println(javaCharset("ISO-8859-1")); // 输出: ISO-8859-1
        System.out.println(javaCharset("non-existent-charset")); // 输出: null
    }
}