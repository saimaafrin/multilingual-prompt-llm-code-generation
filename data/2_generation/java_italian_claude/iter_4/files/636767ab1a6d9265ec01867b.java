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
            }
            currentBuffer.write(b);
            session.size++;
        }

        return currentBuffer;
    }

    // Helper class to represent a linked buffer
    private static class LinkedBuffer {
        private byte[] buffer;
        private int index;
        private LinkedBuffer next;
        private final int capacity;

        public LinkedBuffer(int capacity) {
            this.capacity = capacity;
            this.buffer = new byte[capacity];
            this.index = 0;
        }

        public boolean isFull() {
            return index >= capacity;
        }

        public void write(byte b) {
            buffer[index++] = b;
        }

        public void setNext(LinkedBuffer next) {
            this.next = next;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    // Helper class to track write session
    private static class WriteSession {
        int size;

        public WriteSession() {
            this.size = 0;
        }
    }
}