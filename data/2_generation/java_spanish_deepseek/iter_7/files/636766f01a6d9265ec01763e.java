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
        } catch (IllegalCharsetNameException e) {
            throw new IllegalArgumentException("Nombre de charset no válido: " + charset, e);
        } catch (UnsupportedCharsetException e) {
            throw new IllegalArgumentException("Charset no soportado: " + charset, e);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String mimeCharset = "UTF-8";
        String javaCharset = javaCharset(mimeCharset);
        System.out.println("El charset Java equivalente para " + mimeCharset + " es: " + javaCharset);
    }
}