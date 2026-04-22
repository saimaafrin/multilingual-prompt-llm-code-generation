import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetTranslator {

    /** 
     * Traduce un nombre de conjunto de caracteres estándar MIME al equivalente en Java.
     * @param charset El nombre estándar MIME.
     * @return El equivalente en Java para este nombre.
     */
    private static String javaCharset(String charset) {
        if (charset == null || charset.isEmpty()) {
            return StandardCharsets.UTF_8.name(); // Default to UTF-8 if input is null or empty
        }
        
        try {
            Charset javaCharset = Charset.forName(charset);
            return javaCharset.name();
        } catch (IllegalArgumentException e) {
            return StandardCharsets.UTF_8.name(); // Return UTF-8 if the charset is not valid
        }
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(javaCharset("UTF-8")); // Output: UTF-8
        System.out.println(javaCharset("ISO-8859-1")); // Output: ISO-8859-1
        System.out.println(javaCharset("invalid-charset")); // Output: UTF-8
    }
}