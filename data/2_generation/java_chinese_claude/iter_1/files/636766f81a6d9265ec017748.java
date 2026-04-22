import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64Utils {
    /**
     * 按照 Base64 规则解码字符串。
     */
    public static String base64Decode(final String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(s);
            return new String(decodedBytes, StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
            // Return empty string if input is not valid base64
            return "";
        }
    }
}