import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TemplateEncoder {
    /**
     * 对包含模板参数名称的字符串进行编，特别是字符 '{' 和 '}' 将被百分比编码。
     * @param s 包含零个或多个模板参数名称的字符串
     * @return 编码后的模板参数名称字符串。
     */
    public static String encodeTemplateNames(String s) {
        if (s == null) {
            return null;
        }
        
        try {
            // Encode the string using UTF-8 and replace '{' and '}' with their percent-encoded values
            String encoded = URLEncoder.encode(s, "UTF-8");
            encoded = encoded.replace("+", "%20"); // Replace spaces encoded as '+' with '%20'
            return encoded.replace("%7B", "{").replace("%7D", "}");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported", e);
        }
    }

    public static void main(String[] args) {
        String input = "Hello {name}, welcome to {place}!";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);
    }
}