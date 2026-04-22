import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetTranslator {

    /** 
     * Translate a MIME standard character set name into the Java equivalent.
     * @param charset The MIME standard name.
     * @return The Java equivalent for this name.
     */
    private static String javaCharset(String charset) {
        if (charset == null) {
            return null;
        }
        
        switch (charset.toLowerCase()) {
            case "utf-8":
                return StandardCharsets.UTF_8.name();
            case "iso-8859-1":
                return StandardCharsets.ISO_8859_1.name();
            case "us-ascii":
                return StandardCharsets.US_ASCII.name();
            case "utf-16":
                return StandardCharsets.UTF_16.name();
            case "utf-16be":
                return StandardCharsets.UTF_16BE.name();
            case "utf-16le":
                return StandardCharsets.UTF_16LE.name();
            // Add more mappings as needed
            default:
                return Charset.forName(charset).name();
        }
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(javaCharset("UTF-8")); // Output: UTF-8
        System.out.println(javaCharset("ISO-8859-1")); // Output: ISO-8859-1
        System.out.println(javaCharset("unknown-charset")); // Output: unknown-charset
    }
}