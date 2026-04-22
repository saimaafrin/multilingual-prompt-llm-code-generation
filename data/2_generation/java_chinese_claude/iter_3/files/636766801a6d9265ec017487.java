import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TemplateEncoder {
    /**
     * 对包含模板参数名称的字符串进行编，特别是字符 '{' 和 '}' 将被百分比编码。
     * @param s 包含零个或多个模板参数名称的字符串
     * @return 编码后的模板参数名称字符串。
     */
    public static String encodeTemplateNames(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        try {
            // Replace '{' with '%7B' and '}' with '%7D'
            String encoded = s.replace("{", "%7B")
                            .replace("}", "%7D");
            return encoded;
        } catch (Exception e) {
            return s;
        }
    }
}