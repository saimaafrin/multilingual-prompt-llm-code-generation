import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetTranslator {

    /**
     * एक MIME मानक वर्ण सेट नाम को जावा समकक्ष में अनुवादित करें।
     * @param charset MIME मानक नाम।
     * @return इस नाम के लिए जावा समकक्ष।
     */
    private static String javaCharset(String charset) {
        if (charset == null) {
            throw new IllegalArgumentException("Charset name cannot be null");
        }

        try {
            // Try to get the Java equivalent charset
            Charset javaCharset = Charset.forName(charset);
            return javaCharset.name();
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            // If the charset is not supported, return the default charset
            return Charset.defaultCharset().name();
        }
    }

    public static void main(String[] args) {
        // Example usage
        String mimeCharset = "UTF-8";
        String javaEquivalent = javaCharset(mimeCharset);
        System.out.println("Java equivalent for " + mimeCharset + " is " + javaEquivalent);
    }
}