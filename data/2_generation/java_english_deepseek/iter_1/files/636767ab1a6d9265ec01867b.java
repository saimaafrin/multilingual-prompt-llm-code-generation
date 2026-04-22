import org.objenesis.instantiator.util.LinkedBuffer;
import org.objenesis.instantiator.util.WriteSession;

import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    /**
     * Writes the utf8-encoded bytes from the string into the {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int length = utf8Bytes.length;

        // Ensure the buffer has enough space
        if (lb.remaining() < length) {
            lb = session.allocate(length);
        }

        // Write the bytes into the buffer
        for (byte b : utf8Bytes) {
            lb.put(b);
        }

        return lb;
    }
}