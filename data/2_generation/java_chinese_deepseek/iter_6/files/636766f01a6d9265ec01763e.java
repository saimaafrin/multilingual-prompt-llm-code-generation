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
            // 尝试将MIME字符集名称转换为Java字符集对象
            Charset javaCharset = Charset.forName(charset);
            // 返回Java字符集的规范名称
            return javaCharset.name();
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            // 如果字符集名称不合法或不支持，返回默认字符集名称
            return Charset.defaultCharset().name();
        }
    }

    public static void main(String[] args) {
        // 测试示例
        String mimeCharset = "UTF-8";
        String javaCharsetName = javaCharset(mimeCharset);
        System.out.println("Java Charset Name: " + javaCharsetName);
    }
}