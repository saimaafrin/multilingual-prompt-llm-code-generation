import java.nio.charset.StandardCharsets;

public class LinkedBuffer {
    private byte[] buffer;
    private int position;

    public LinkedBuffer(byte[] buffer, int position) {
        this.buffer = buffer;
        this.position = position;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

public class WriteSession {
    // Placeholder for WriteSession class
}

public class Utf8Writer {
    /**
     * Writes the utf8-encoded bytes from the string into the {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || lb == null) {
            return lb;
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int bytesLength = utf8Bytes.length;

        if (lb.getBuffer().length - lb.getPosition() < bytesLength) {
            // Handle buffer overflow, e.g., by expanding the buffer or returning null
            return null;
        }

        System.arraycopy(utf8Bytes, 0, lb.getBuffer(), lb.getPosition(), bytesLength);
        lb.setPosition(lb.getPosition() + bytesLength);

        return lb;
    }
}