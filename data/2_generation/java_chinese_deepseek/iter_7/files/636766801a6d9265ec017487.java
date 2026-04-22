import java.nio.charset.StandardCharsets;
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
        
        StringBuilder encodedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '}') {
                try {
                    encodedString.append(URLEncoder.encode(String.valueOf(c), StandardCharsets.UTF_8.toString()));
                } catch (Exception e) {
                    // This should not happen as UTF-8 is always supported
                    encodedString.append(c);
                }
            } else {
                encodedString.append(c);
            }
        }
        return encodedString.toString();
    }

    public static void main(String[] args) {
        String input = "This is a {template} with {parameters}.";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);
    }
}