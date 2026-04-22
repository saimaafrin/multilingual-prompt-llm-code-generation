import java.nio.charset.StandardCharsets;
import java.nio.ByteBuffer;

public class UTF8Writer {

    /**
     * स्ट्रिंग से UTF8-कोडित बाइट्स को {@link LinkedBuffer} में लिखता है।
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || lb == null) {
            throw new IllegalArgumentException("Input string and LinkedBuffer cannot be null");
        }

        byte[] bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        lb.write(bytes);
        return lb;
    }
}

class LinkedBuffer {
    private ByteBuffer buffer;

    public LinkedBuffer(int capacity) {
        buffer = ByteBuffer.allocate(capacity);
    }

    public void write(byte[] bytes) {
        if (buffer.remaining() < bytes.length) {
            throw new IllegalArgumentException("Not enough space in LinkedBuffer");
        }
        buffer.put(bytes);
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }
}

class WriteSession {
    // Implementation of WriteSession
}