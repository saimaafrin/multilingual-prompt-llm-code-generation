import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Input parameters cannot be null.");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int bytesWritten = 0;

        while (bytesWritten < utf8Bytes.length) {
            if (lb.remaining() == 0) {
                lb = session.nextBuffer(lb);
            }

            int bytesToWrite = Math.min(lb.remaining(), utf8Bytes.length - bytesWritten);
            System.arraycopy(utf8Bytes, bytesWritten, lb.buffer(), lb.position(), bytesToWrite);
            lb.position(lb.position() + bytesToWrite);
            bytesWritten += bytesToWrite;
        }

        return lb;
    }

    // Assuming LinkedBuffer and WriteSession classes are defined elsewhere
    public static class LinkedBuffer {
        private byte[] buffer;
        private int position;

        public LinkedBuffer(int capacity) {
            this.buffer = new byte[capacity];
            this.position = 0;
        }

        public int remaining() {
            return buffer.length - position;
        }

        public byte[] buffer() {
            return buffer;
        }

        public int position() {
            return position;
        }

        public void position(int position) {
            this.position = position;
        }
    }

    public static class WriteSession {
        public LinkedBuffer nextBuffer(LinkedBuffer currentBuffer) {
            // Implement logic to get the next buffer
            return new LinkedBuffer(currentBuffer.buffer().length);
        }
    }
}