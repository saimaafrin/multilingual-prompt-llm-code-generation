import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int length = utf8Bytes.length;

        // Ensure the LinkedBuffer has enough space
        if (lb.remaining() < length) {
            lb = LinkedBuffer.allocate(Math.max(lb.capacity() * 2, length));
        }

        // Write the bytes to the LinkedBuffer
        lb.put(utf8Bytes, 0, length);

        // Update the WriteSession with the number of bytes written
        session.bytesWritten(length);

        return lb;
    }

    // Assuming LinkedBuffer and WriteSession classes are defined as follows:
    static class LinkedBuffer {
        private byte[] buffer;
        private int position;
        private int capacity;

        public LinkedBuffer(int capacity) {
            this.buffer = new byte[capacity];
            this.position = 0;
            this.capacity = capacity;
        }

        public void put(byte[] src, int offset, int length) {
            System.arraycopy(src, offset, buffer, position, length);
            position += length;
        }

        public int remaining() {
            return capacity - position;
        }

        public static LinkedBuffer allocate(int capacity) {
            return new LinkedBuffer(capacity);
        }

        public int capacity() {
            return capacity;
        }
    }

    static class WriteSession {
        private int bytesWritten;

        public void bytesWritten(int count) {
            this.bytesWritten += count;
        }

        public int getBytesWritten() {
            return bytesWritten;
        }
    }
}