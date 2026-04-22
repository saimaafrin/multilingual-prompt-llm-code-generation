import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

private static String javaCharset(String charset) {
    try {
        // Attempt to get the Java Charset object for the given MIME charset name
        Charset javaCharset = Charset.forName(charset);
        // Return the canonical name of the Charset
        return javaCharset.name();
    } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
        // If the charset name is invalid or unsupported, return null
        return null;
    }
}