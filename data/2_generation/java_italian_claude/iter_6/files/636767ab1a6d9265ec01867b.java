import java.nio.charset.StandardCharsets;

public class UTF8Writer {
    /**
     * Scrive i byte codificati in utf8 dalla stringa nel {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || str.length() == 0) {
            return lb;
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        LinkedBuffer currentBuffer = lb;

        for (byte b : utf8Bytes) {
            if (currentBuffer.isFull()) {
                LinkedBuffer nextBuffer = new LinkedBuffer(currentBuffer.getCapacity());
                currentBuffer.setNext(nextBuffer);
                currentBuffer = nextBuffer;
                session.nextBuffer(currentBuffer);
            }
            currentBuffer.write(b);
        }

        return currentBuffer;
    }

    private static class LinkedBuffer {
        private byte[] buffer;
        private int offset;
        private int capacity;
        private LinkedBuffer next;

        public LinkedBuffer(int capacity) {
            this.capacity = capacity;
            this.buffer = new byte[capacity];
            this.offset = 0;
        }

        public boolean isFull() {
            return offset >= capacity;
        }

        public void write(byte b) {
            buffer[offset++] = b;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setNext(LinkedBuffer next) {
            this.next = next;
        }
    }

    private static class WriteSession {
        public void nextBuffer(LinkedBuffer buffer) {
            // Implementation for managing write session
        }
    }
}