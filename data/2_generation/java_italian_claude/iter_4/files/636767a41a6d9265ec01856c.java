import java.nio.charset.StandardCharsets;

public class UTF8Utils {
    /**
     * Calcola la dimensione della stringa utf8 che inizia all'indice specificato {@code index} con la lunghezza specificata {@code length}.
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        int utf8Size = 0;
        final int end = index + len;
        
        for (int i = index; i < end; i++) {
            char c = str.charAt(i);
            
            if (c < 0x80) {
                // ASCII character (1 byte)
                utf8Size++;
            } else if (c < 0x800) {
                // 2-byte UTF-8 character
                utf8Size += 2;
            } else if (Character.isSurrogate(c)) {
                // 4-byte UTF-8 character (surrogate pair)
                utf8Size += 4;
                i++; // Skip the low surrogate
            } else {
                // 3-byte UTF-8 character
                utf8Size += 3;
            }
        }
        
        return utf8Size;
    }
}