import java.nio.charset.Charset;

public class CharsetTranslator {

    /** 
     * Traduce un nombre de conjunto de caracteres estándar MIME al equivalente en Java.
     * @param charset El nombre estándar MIME.
     * @return El equivalente en Java para este nombre.
     */
    private static String javaCharset(String charset) {
        if (Charset.isSupported(charset)) {
            return Charset.forName(charset).name();
        } else {
            throw new IllegalArgumentException("Charset not supported: " + charset);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String mimeCharset = "UTF-8";
        String javaCharset = javaCharset(mimeCharset);
        System.out.println("El equivalente en Java para " + mimeCharset + " es: " + javaCharset);
    }
}