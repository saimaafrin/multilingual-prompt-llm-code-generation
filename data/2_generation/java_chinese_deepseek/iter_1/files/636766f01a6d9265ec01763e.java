import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetConverter {

    /**
     * 将MIME标准字符集名称转换为Java等效名称。
     * @param charset MIME标准名称。
     * @return 此名称的Java等效名称。
     */
    private static String javaCharset(String charset) {
        try {
            // 尝试将MIME标准字符集名称转换为Java Charset对象
            Charset javaCharset = Charset.forName(charset);
            // 返回Java Charset的标准名称
            return javaCharset.name();
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            // 如果字符集名称不合法或不支持，返回默认的UTF-8
            return "UTF-8";
        }
    }

    public static void main(String[] args) {
        // 测试示例
        System.out.println(javaCharset("ISO-8859-1")); // 输出: ISO-8859-1
        System.out.println(javaCharset("UTF-8"));      // 输出: UTF-8
        System.out.println(javaCharset("invalid"));    // 输出: UTF-8
    }
}