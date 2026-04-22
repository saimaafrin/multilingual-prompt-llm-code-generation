import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetTranslator {

    /**
     * Traduce un nombre de conjunto de caracteres estándar MIME al equivalente en Java.
     * @param charset El nombre estándar MIME.
     * @return El equivalente en Java para este nombre.
     */
    private static String javaCharset(String charset) {
        try {
            // Intenta obtener el Charset correspondiente al nombre MIME
            Charset javaCharset = Charset.forName(charset);
            return javaCharset.name();
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            // Si el nombre no es válido o no es soportado, devuelve el nombre por defecto "UTF-8"
            return "UTF-8";
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String mimeCharset = "ISO-8859-1";
        String javaCharset = javaCharset(mimeCharset);
        System.out.println("El equivalente en Java para " + mimeCharset + " es: " + javaCharset);
    }
}