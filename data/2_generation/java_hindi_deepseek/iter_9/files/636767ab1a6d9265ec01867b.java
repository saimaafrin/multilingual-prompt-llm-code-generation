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
            lb.append(b);
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

        public boolean isFull() {
            return position >= buffer.length;
        }

        public void append(byte b) {
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

        public LinkedBuffer nextBuffer(LinkedBuffer currentBuffer) {
            LinkedBuffer newBuffer = new LinkedBuffer(currentBuffer.getBuffer().length);
            currentBuffer = newBuffer;
            return currentBuffer;
        }

        public LinkedBuffer getCurrentBuffer() {
            return currentBuffer;
        }
    }

    public static void main(String[] args) {
        CharSequence str = "Hello, UTF-8!";
        LinkedBuffer initialBuffer = new LinkedBuffer(10);
        WriteSession session = new WriteSession(initialBuffer);

        LinkedBuffer resultBuffer = writeUTF8(str, session, initialBuffer);

        System.out.println("Bytes written: " + resultBuffer.getPosition());
    }
}