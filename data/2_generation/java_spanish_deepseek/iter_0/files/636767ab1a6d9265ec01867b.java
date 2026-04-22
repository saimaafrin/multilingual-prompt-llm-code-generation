import java.nio.charset.StandardCharsets;
import java.nio.ByteBuffer;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.wrap(utf8Bytes);

        while (buffer.hasRemaining()) {
            if (lb.remaining() == 0) {
                lb = lb.ensureCapacity(session, 1);
            }
            lb.put(buffer.get());
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
                throw new IndexOutOfBoundsException("Buffer overflow");
            }
            buffer[position++] = b;
        }

        public int remaining() {
            return buffer.length - position;
        }

        public LinkedBuffer ensureCapacity(WriteSession session, int required) {
            if (remaining() >= required) {
                return this;
            }
            LinkedBuffer newBuffer = new LinkedBuffer(buffer.length * 2);
            System.arraycopy(buffer, 0, newBuffer.buffer, 0, position);
            newBuffer.position = position;
            return newBuffer;
        }
    }

    public static class WriteSession {
        // Placeholder for session-related operations
    }

    public static void main(String[] args) {
        WriteSession session = new WriteSession();
        LinkedBuffer lb = new LinkedBuffer(10);
        CharSequence str = "Hello, UTF-8!";
        lb = writeUTF8(str, session, lb);
        System.out.println("Bytes written: " + lb.position);
    }
}