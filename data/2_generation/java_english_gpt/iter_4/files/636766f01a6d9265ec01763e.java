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
        
        // Convert the charset name to lowercase to handle case insensitivity
        String lowerCharset = charset.toLowerCase();
        
        // Check for common MIME charset names and return the corresponding Java charset
        switch (lowerCharset) {
            case "utf-8":
                return StandardCharsets.UTF_8.name();
            case "utf-16":
                return StandardCharsets.UTF_16.name();
            case "utf-16be":
                return StandardCharsets.UTF_16BE.name();
            case "utf-16le":
                return StandardCharsets.UTF_16LE.name();
            case "iso-8859-1":
                return StandardCharsets.ISO_8859_1.name();
            case "windows-1252":
                return "windows-1252"; // Not in StandardCharsets, but commonly used
            case "us-ascii":
                return StandardCharsets.US_ASCII.name();
            // Add more mappings as needed
            default:
                // If the charset is not recognized, return the original charset name
                return charset;
        }
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(javaCharset("UTF-8")); // Output: UTF-8
        System.out.println(javaCharset("ISO-8859-1")); // Output: ISO-8859-1
        System.out.println(javaCharset("windows-1252")); // Output: windows-1252
    }
}