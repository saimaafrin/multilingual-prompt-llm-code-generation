import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetConverter {

    /** 
     * 将MIME标准字符集名称转换为Java等效名称。
     * @param charset MIME标准名称。
     * @return 此名称的Java等效名称。
     */
    private static String javaCharset(String charset) {
        if (charset == null || charset.isEmpty()) {
            return null;
        }
        
        // Convert MIME charset to Java charset
        try {
            Charset javaCharset = Charset.forName(charset);
            return javaCharset.name();
        } catch (IllegalArgumentException e) {
            // If the charset is not recognized, return null or handle accordingly
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        String mimeCharset = "UTF-8";
        String javaEquivalent = javaCharset(mimeCharset);
        System.out.println("Java equivalent of " + mimeCharset + " is: " + javaEquivalent);
    }
}