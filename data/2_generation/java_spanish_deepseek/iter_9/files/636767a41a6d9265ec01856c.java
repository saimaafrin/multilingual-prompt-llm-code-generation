import java.nio.charset.StandardCharsets;

public class UTF8SizeCalculator {

    /**
     * Calcula el tamaño de la cadena utf8 que comienza en el índice especificado {@code index} con la longitud especificada {@code length}.
     *
     * @param str   La cadena de caracteres.
     * @param index El índice inicial en la cadena.
     * @param len   La longitud de la subcadena a considerar.
     * @return El tamaño en bytes de la subcadena en UTF-8.
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        if (str == null || index < 0 || len < 0 || index + len > str.length()) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        String substring = str.subSequence(index, index + len).toString();
        byte[] utf8Bytes = substring.getBytes(StandardCharsets.UTF_8);
        return utf8Bytes.length;
    }

    public static void main(String[] args) {
        CharSequence str = "Hello, 世界!";
        int index = 7;
        int len = 2;
        int size = computeUTF8Size(str, index, len);
        System.out.println("UTF-8 size: " + size);  // Output: UTF-8 size: 6
    }
}