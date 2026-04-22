import java.nio.charset.StandardCharsets;

public class UTF8Utils {

    /**
     * Calcula el tamaño de la cadena utf8 que comienza en el índice especificado {@code index} con la longitud especificada {@code length}.
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        int utf8Size = 0;
        final int end = index + len;

        for (int i = index; i < end; i++) {
            char c = str.charAt(i);
            
            if (c <= 0x7F) {
                utf8Size++;
            } else if (c <= 0x7FF) {
                utf8Size += 2;
            } else if (Character.isHighSurrogate(c) && i + 1 < end && 
                      Character.isLowSurrogate(str.charAt(i + 1))) {
                utf8Size += 4;
                i++;
            } else {
                utf8Size += 3;
            }
        }

        return utf8Size;
    }
}