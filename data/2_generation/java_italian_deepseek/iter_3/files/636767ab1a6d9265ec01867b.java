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
            lb = LinkedBuffer.ensureCapacity(lb, length);
        }

        // Write the UTF-8 bytes to the LinkedBuffer
        for (byte b : utf8Bytes) {
            lb.put(b);
        }

        return lb;
    }

    // Assuming LinkedBuffer and WriteSession are defined elsewhere
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

        public static LinkedBuffer ensureCapacity(LinkedBuffer lb, int requiredCapacity) {
            if (lb.remaining() >= requiredCapacity) {
                return lb;
            }
            int newCapacity = lb.buffer.length + requiredCapacity;
            LinkedBuffer newBuffer = new LinkedBuffer(newCapacity);
            System.arraycopy(lb.buffer, 0, newBuffer.buffer, 0, lb.position);
            newBuffer.position = lb.position;
            return newBuffer;
        }
    }

    public static class WriteSession {
        // Placeholder for WriteSession implementation
    }
}