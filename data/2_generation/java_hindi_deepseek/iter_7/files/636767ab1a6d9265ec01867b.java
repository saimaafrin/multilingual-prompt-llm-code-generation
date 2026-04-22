import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        for (byte b : utf8Bytes) {
            if (lb.remaining() == 0) {
                lb = session.nextBuffer(lb);
            }
            lb.put(b);
        }

        return lb;
    }

    public static class LinkedBuffer {
        private byte[] buffer;
        private int position;

        public LinkedBuffer(int capacity) {
            this.buffer = new byte[capacity];
            this.position = 0;
        }

        public void put(byte b) {
            if (position >= buffer.length) {
                throw new IllegalStateException("Buffer overflow");
            }
            buffer[position++] = b;
        }

        public int remaining() {
            return buffer.length - position;
        }
    }

    public static class WriteSession {
        public LinkedBuffer nextBuffer(LinkedBuffer currentBuffer) {
            // Implement logic to get the next buffer in the chain
            return new LinkedBuffer(currentBuffer.buffer.length); // Example: return a new buffer of the same size
        }
    }
}