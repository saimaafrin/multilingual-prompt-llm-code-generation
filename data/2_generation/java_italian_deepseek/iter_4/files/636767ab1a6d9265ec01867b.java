import java.nio.charset.StandardCharsets;

public class Utf8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        for (byte b : utf8Bytes) {
            lb = ensureCapacity(lb, session);
            lb.buffer[lb.tail++] = b;
        }

        return lb;
    }

    private static LinkedBuffer ensureCapacity(LinkedBuffer lb, WriteSession session) {
        if (lb.tail >= lb.buffer.length) {
            lb = session.nextBuffer(lb);
        }
        return lb;
    }

    public static class LinkedBuffer {
        public byte[] buffer;
        public int tail;

        public LinkedBuffer(int size) {
            this.buffer = new byte[size];
            this.tail = 0;
        }
    }

    public static class WriteSession {
        public LinkedBuffer nextBuffer(LinkedBuffer current) {
            // Implementation for obtaining the next buffer
            return new LinkedBuffer(current.buffer.length); // Example: return a new buffer of the same size
        }
    }
}