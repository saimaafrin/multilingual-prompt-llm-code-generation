import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

/**
 * Translate a MIME standard character set name into the Java equivalent.
 * @param charset The MIME standard name.
 * @return The Java equivalent for this name.
 */
private static String javaCharset(String charset) {
    try {
        // Attempt to get the Java Charset object for the given MIME charset name
        Charset javaCharset = Charset.forName(charset);
        // Return the canonical name of the Charset
        return javaCharset.name();
    } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
        // If the charset is not supported or the name is illegal, return null
        return null;
    }
}