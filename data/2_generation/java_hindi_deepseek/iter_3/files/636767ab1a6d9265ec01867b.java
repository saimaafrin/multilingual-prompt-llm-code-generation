import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Input parameters cannot be null.");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        for (byte b : utf8Bytes) {
            if (lb.isFull()) {
                lb = session.nextBuffer(lb);
            }
            lb.put(b);
        }

        return lb;
    }

    public static class LinkedBuffer {
        private final byte[] buffer;
        private int position;

        public LinkedBuffer(int capacity) {
            this.buffer = new byte[capacity];
            this.position = 0;
        }

        public boolean isFull() {
            return position >= buffer.length;
        }

        public void put(byte b) {
            if (isFull()) {
                throw new IllegalStateException("Buffer is full.");
            }
            buffer[position++] = b;
        }

        public byte[] getBuffer() {
            return buffer;
        }

        public int getPosition() {
            return position;
        }
    }

    public static class WriteSession {
        private LinkedBuffer currentBuffer;

        public WriteSession(LinkedBuffer initialBuffer) {
            this.currentBuffer = initialBuffer;
        }

        public LinkedBuffer nextBuffer(LinkedBuffer current) {
            LinkedBuffer newBuffer = new LinkedBuffer(current.getBuffer().length);
            currentBuffer = newBuffer;
            return newBuffer;
        }

        public LinkedBuffer getCurrentBuffer() {
            return currentBuffer;
        }
    }
}