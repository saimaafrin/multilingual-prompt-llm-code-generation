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
            // If the charset is not supported or the name is illegal, return null
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        String mimeCharset = "UTF-8";
        String javaCharset = javaCharset(mimeCharset);
        System.out.println("Java Charset for " + mimeCharset + " is " + javaCharset);
    }
}