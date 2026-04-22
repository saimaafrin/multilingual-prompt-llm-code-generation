import java.nio.charset.StandardCharsets;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.core.buffer.MessageBuffer;

public class UTF8Writer {

    /**
     * Writes the utf8-encoded bytes from the string into the {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int length = utf8Bytes.length;

        // Ensure the LinkedBuffer has enough space
        LinkedBuffer currentBuffer = lb;
        if (currentBuffer.remaining() < length) {
            currentBuffer = LinkedBuffer.allocate(Math.max(length, currentBuffer.size()));
        }

        // Write the bytes into the LinkedBuffer
        MessageBuffer messageBuffer = currentBuffer.currentMessageBuffer();
        messageBuffer.putBytes(currentBuffer.getOffset(), utf8Bytes, 0, length);
        currentBuffer.addOffset(length);

        return currentBuffer;
    }
}