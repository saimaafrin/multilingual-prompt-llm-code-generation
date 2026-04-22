import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetTranslator {

    /**
     * Translate a MIME standard character set name into the Java equivalent.
     * @param charset The MIME standard name.
     * @return The Java equivalent for this name.
     */
    private static String javaCharset(String charset) {
        if (charset == null) {
            throw new IllegalArgumentException("Charset name cannot be null");
        }

        try {
            // Attempt to get the Java Charset object for the given name
            Charset javaCharset = Charset.forName(charset);
            return javaCharset.name();
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            // If the charset is not supported or the name is illegal, return null or a default charset
            return "UTF-8"; // Default to UTF-8 if the charset is not recognized
        }
    }

    public static void main(String[] args) {
        // Example usage
        String mimeCharset = "ISO-8859-1";
        String javaEquivalent = javaCharset(mimeCharset);
        System.out.println("Java equivalent for " + mimeCharset + " is " + javaEquivalent);
    }
}