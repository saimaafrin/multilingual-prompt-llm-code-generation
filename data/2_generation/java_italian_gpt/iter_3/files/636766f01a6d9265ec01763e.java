import java.nio.charset.Charset;

public class CharsetTranslator {

    /** 
     * Traduci un nome di set di caratteri standard MIME nell'equivalente Java.
     * @param charset Il nome standard MIME.
     * @return L'equivalente Java per questo nome.
     */
    private static String javaCharset(String charset) {
        if (Charset.isSupported(charset)) {
            return Charset.forName(charset).name();
        } else {
            throw new IllegalArgumentException("Charset not supported: " + charset);
        }
    }

    public static void main(String[] args) {
        // Example usage
        String mimeCharset = "UTF-8";
        String javaCharset = javaCharset(mimeCharset);
        System.out.println("Java Charset: " + javaCharset);
    }
}