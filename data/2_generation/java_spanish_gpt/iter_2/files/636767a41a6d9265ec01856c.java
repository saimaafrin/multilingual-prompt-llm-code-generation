import java.nio.charset.StandardCharsets;

public class UTF8SizeCalculator {

    /** 
     * Calcula el tamaño de la cadena utf8 que comienza en el índice especificado {@code index} con la longitud especificada {@code length}.
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (index < 0 || len < 0 || index + len > str.length()) {
            throw new IndexOutOfBoundsException("Index or length is out of bounds");
        }

        String substring = str.subSequence(index, index + len).toString();
        return substring.getBytes(StandardCharsets.UTF_8).length;
    }

    public static void main(String[] args) {
        String testString = "Hello, 世界"; // Example string
        int utf8Size = computeUTF8Size(testString, 0, testString.length());
        System.out.println("UTF-8 size: " + utf8Size);
    }
}