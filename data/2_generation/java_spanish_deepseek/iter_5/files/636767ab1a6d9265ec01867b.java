import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.wrap(utf8Bytes);

        while (buffer.hasRemaining()) {
            if (lb.remaining() == 0) {
                lb = session.nextBuffer(lb);
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
                throw new IllegalStateException("Buffer overflow");
            }
            buffer[position++] = b;
        }

        public int remaining() {
            return buffer.length - position;
        }
    }

    public static class WriteSession {
        private LinkedBuffer currentBuffer;

        public WriteSession(LinkedBuffer initialBuffer) {
            this.currentBuffer = initialBuffer;
        }

        public LinkedBuffer nextBuffer(LinkedBuffer current) {
            // Simulate getting a new buffer, e.g., from a pool or allocating a new one
            LinkedBuffer newBuffer = new LinkedBuffer(current.buffer.length);
            currentBuffer = newBuffer;
            return newBuffer;
        }
    }

    public static void main(String[] args) {
        LinkedBuffer lb = new LinkedBuffer(10);
        WriteSession session = new WriteSession(lb);
        CharSequence str = "Hello, UTF-8!";
        lb = writeUTF8(str, session, lb);

        // Print the contents of the buffer
        System.out.println("Buffer contents:");
        for (byte b : lb.buffer) {
            System.out.print((char) b);
        }
    }
}