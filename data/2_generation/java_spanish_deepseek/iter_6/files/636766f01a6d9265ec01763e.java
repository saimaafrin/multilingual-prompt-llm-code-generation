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
        if (charset == null) {
            throw new IllegalArgumentException("El nombre del charset no puede ser nulo.");
        }

        try {
            // Intenta obtener el Charset correspondiente al nombre MIME
            Charset javaCharset = Charset.forName(charset);
            return javaCharset.name();
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            // Si el nombre no es válido o no es soportado, devuelve el charset por defecto (UTF-8)
            return Charset.defaultCharset().name();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String mimeCharset = "ISO-8859-1";
        String javaCharset = javaCharset(mimeCharset);
        System.out.println("El charset Java equivalente para " + mimeCharset + " es: " + javaCharset);
    }
}