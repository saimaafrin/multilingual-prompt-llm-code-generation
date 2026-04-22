import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetConverter {

    /**
     * Traduci un nome di set di caratteri standard MIME nell'equivalente Java.
     * @param charset Il nome standard MIME.
     * @return L'equivalente Java per questo nome.
     */
    private static String javaCharset(String charset) {
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
            default:
                // Se il charset non è uno di quelli standard, prova a creare un Charset
                try {
                    return Charset.forName(charset).name();
                } catch (Exception e) {
                    // Se non esiste, ritorna il charset di default (UTF-8)
                    return StandardCharsets.UTF_8.name();
                }
        }
    }

    public static void main(String[] args) {
        System.out.println(javaCharset("utf-8")); // Output: UTF-8
        System.out.println(javaCharset("iso-8859-1")); // Output: ISO-8859-1
        System.out.println(javaCharset("unknown-charset")); // Output: UTF-8
    }
}