import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        // Convert the CharSequence to a byte array using UTF-8 encoding
        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);

        // Write the bytes to the LinkedBuffer
        for (byte b : utf8Bytes) {
            if (lb.isFull()) {
                lb = session.allocateNewBuffer();
            }
            lb.put(b);
        }

        return lb;
    }

    // Assuming LinkedBuffer and WriteSession are defined as follows:
    public static class LinkedBuffer {
        private final ByteBuffer buffer;
        private int position;

        public LinkedBuffer(int capacity) {
            this.buffer = ByteBuffer.allocate(capacity);
            this.position = 0;
        }

        public boolean isFull() {
            return position >= buffer.capacity();
        }

        public void put(byte b) {
            if (isFull()) {
                throw new IllegalStateException("Buffer is full");
            }
            buffer.put(position++, b);
        }

        public ByteBuffer getBuffer() {
            return buffer;
        }
    }

    public static class WriteSession {
        public LinkedBuffer allocateNewBuffer() {
            // Allocate a new buffer with a default capacity
            return new LinkedBuffer(1024);
        }
    }
}