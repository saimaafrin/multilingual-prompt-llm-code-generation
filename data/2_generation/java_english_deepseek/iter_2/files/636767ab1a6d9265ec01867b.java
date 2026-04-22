import org.objenesis.instantiator.util.LinkedBuffer;
import org.objenesis.instantiator.util.WriteSession;

public class UTF8Writer {

    /**
     * Writes the utf8-encoded bytes from the string into the {@link LinkedBuffer}.
     *
     * @param str     the character sequence to encode
     * @param session the write session
     * @param lb      the linked buffer to write into
     * @return the updated linked buffer
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8);
        for (byte b : utf8Bytes) {
            if (lb.remaining() == 0) {
                lb = lb.allocateNewBuffer(session);
            }
            lb.put(b);
        }

        return lb;
    }
}