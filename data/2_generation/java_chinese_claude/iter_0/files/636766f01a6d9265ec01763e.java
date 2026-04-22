import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class CharsetConverter {
    
    private static final Map<String, String> MIME_TO_JAVA_CHARSET = new HashMap<>();
    
    static {
        MIME_TO_JAVA_CHARSET.put("iso-8859-1", "ISO-8859-1");
        MIME_TO_JAVA_CHARSET.put("iso_8859_1", "ISO-8859-1");
        MIME_TO_JAVA_CHARSET.put("iso8859_1", "ISO-8859-1");
        MIME_TO_JAVA_CHARSET.put("iso-8859-2", "ISO-8859-2");
        MIME_TO_JAVA_CHARSET.put("iso_8859_2", "ISO-8859-2");
        MIME_TO_JAVA_CHARSET.put("iso8859_2", "ISO-8859-2");
        MIME_TO_JAVA_CHARSET.put("utf-8", "UTF-8");
        MIME_TO_JAVA_CHARSET.put("utf8", "UTF-8");
        MIME_TO_JAVA_CHARSET.put("utf-16", "UTF-16");
        MIME_TO_JAVA_CHARSET.put("utf16", "UTF-16");
        MIME_TO_JAVA_CHARSET.put("us-ascii", "US-ASCII");
        MIME_TO_JAVA_CHARSET.put("ascii", "US-ASCII");
        MIME_TO_JAVA_CHARSET.put("gb2312", "GB2312");
        MIME_TO_JAVA_CHARSET.put("gbk", "GBK");
        MIME_TO_JAVA_CHARSET.put("big5", "Big5");
    }

    /**
     * 将MIME标准字符集名称转换为Java等效名称。
     * @param charset MIME标准名称。
     * @return 此名称的Java等效名称。
     */
    private static String javaCharset(String charset) {
        if (charset == null) {
            return Charset.defaultCharset().name();
        }
        
        String normalized = charset.toLowerCase().trim();
        String javaCharset = MIME_TO_JAVA_CHARSET.get(normalized);
        
        return javaCharset != null ? javaCharset : charset;
    }
}