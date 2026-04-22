import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
            // Replace '{' with its percent encoding
            String result = s.replace("{", URLEncoder.encode("{", StandardCharsets.UTF_8.toString()));
            // Replace '}' with its percent encoding
            result = result.replace("}", URLEncoder.encode("}", StandardCharsets.UTF_8.toString()));
            return result;
        } catch (UnsupportedEncodingException e) {
            // This should never happen with UTF-8
            throw new RuntimeException("UTF-8 encoding not supported", e);
        }
    }
}