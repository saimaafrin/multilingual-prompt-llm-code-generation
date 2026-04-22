import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CharsetConverter {

    private static final Map<String, String> MIME_TO_JAVA_CHARSET = new HashMap<>();

    static {
        MIME_TO_JAVA_CHARSET.put("UTF-8", StandardCharsets.UTF_8.name());
        MIME_TO_JAVA_CHARSET.put("ISO-8859-1", StandardCharsets.ISO_8859_1.name());
        MIME_TO_JAVA_CHARSET.put("US-ASCII", StandardCharsets.US_ASCII.name());
        MIME_TO_JAVA_CHARSET.put("UTF-16", StandardCharsets.UTF_16.name());
        MIME_TO_JAVA_CHARSET.put("UTF-16BE", StandardCharsets.UTF_16BE.name());
        MIME_TO_JAVA_CHARSET.put("UTF-16LE", StandardCharsets.UTF_16LE.name());
    }

    /**
     * 将MIME标准字符集名称转换为Java等效名称。
     * @param charset MIME标准名称。
     * @return 此名称的Java等效名称。
     */
    private static String javaCharset(String charset) {
        return MIME_TO_JAVA_CHARSET.getOrDefault(charset, charset);
    }

    public static void main(String[] args) {
        System.out.println(javaCharset("UTF-8")); // 输出: UTF-8
        System.out.println(javaCharset("ISO-8859-1")); // 输出: ISO-8859-1
        System.out.println(javaCharset("UNKNOWN")); // 输出: UNKNOWN
    }
}