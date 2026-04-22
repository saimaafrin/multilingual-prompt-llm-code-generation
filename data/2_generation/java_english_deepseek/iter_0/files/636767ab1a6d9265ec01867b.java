import java.nio.charset.StandardCharsets;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;

public class UTF8Writer {

    /**
     * Writes the utf8-encoded bytes from the string into the {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || lb == null) {
            throw new IllegalArgumentException("Input string and LinkedBuffer must not be null.");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int bytesToWrite = utf8Bytes.length;

        LinkedBuffer currentBuffer = lb;
        int remaining = currentBuffer.remaining();

        while (bytesToWrite > 0) {
            if (remaining == 0) {
                currentBuffer = currentBuffer.next();
                remaining = currentBuffer.remaining();
            }

            int bytesWritten = Math.min(remaining, bytesToWrite);
            System.arraycopy(utf8Bytes, utf8Bytes.length - bytesToWrite, currentBuffer.array(), currentBuffer.position(), bytesWritten);
            currentBuffer.position(currentBuffer.position() + bytesWritten);
            bytesToWrite -= bytesWritten;
            remaining -= bytesWritten;
        }

        return lb;
    }

    public static class WriteSession {
        // Placeholder for WriteSession implementation
    }

    public static void main(String[] args) {
        LinkedBuffer buffer = LinkedBuffer.allocate(1024);
        WriteSession session = new WriteSession();
        CharSequence str = "Hello, World!";
        LinkedBuffer result = writeUTF8(str, session, buffer);
        System.out.println("UTF-8 bytes written to LinkedBuffer.");
    }
}