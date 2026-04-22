import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetTranslator {

    /**
     * एक MIME मानक वर्ण सेट नाम को जावा समकक्ष में अनुवादित करें।
     * @param charset MIME मानक नाम।
     * @return इस नाम के लिए जावा समकक्ष।
     */
    private static String javaCharset(String charset) {
        try {
            // Try to get the Java Charset for the given MIME charset name
            return Charset.forName(charset).name();
        } catch (UnsupportedCharsetException e) {
            // If the charset is not supported, return the default charset
            return Charset.defaultCharset().name();
        }
    }

    public static void main(String[] args) {
        // Example usage
        String mimeCharset = "UTF-8";
        String javaCharset = javaCharset(mimeCharset);
        System.out.println("Java Charset for " + mimeCharset + " is " + javaCharset);
    }
}