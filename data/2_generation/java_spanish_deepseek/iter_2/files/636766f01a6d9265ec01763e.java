import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetTranslator {

    /**
     * Traduce un nombre de conjunto de caracteres estándar MIME al equivalente en Java.
     * @param charset El nombre estándar MIME.
     * @return El equivalente en Java para este nombre.
     */
    private static String javaCharset(String charset) {
        switch (charset.toLowerCase()) {
            case "us-ascii":
                return StandardCharsets.US_ASCII.name();
            case "iso-8859-1":
                return StandardCharsets.ISO_8859_1.name();
            case "utf-8":
                return StandardCharsets.UTF_8.name();
            case "utf-16":
                return StandardCharsets.UTF_16.name();
            case "utf-16be":
                return StandardCharsets.UTF_16BE.name();
            case "utf-16le":
                return StandardCharsets.UTF_16LE.name();
            default:
                // Si no es un charset estándar, intenta obtenerlo directamente
                try {
                    return Charset.forName(charset).name();
                } catch (Exception e) {
                    throw new IllegalArgumentException("Charset no soportado: " + charset);
                }
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        System.out.println(javaCharset("utf-8"));  // Debería imprimir "UTF-8"
        System.out.println(javaCharset("iso-8859-1"));  // Debería imprimir "ISO-8859-1"
    }
}