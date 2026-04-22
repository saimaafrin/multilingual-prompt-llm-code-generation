import java.nio.charset.StandardCharsets;
import io.protostuff.LinkedBuffer;
import io.protostuff.WriteSession;

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

        if (lb.offset + length > lb.buffer.length) {
            // If the buffer is full, flush it and get a new one
            lb = session.nextBuffer(lb, length);
        }

        System.arraycopy(utf8Bytes, 0, lb.buffer, lb.offset, length);
        lb.offset += length;

        return lb;
    }
}