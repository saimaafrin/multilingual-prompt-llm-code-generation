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
        byte[] buffer = lb.getBuffer();
        int position = lb.getPosition();

        // Ensure there is enough space in the buffer
        if (position + utf8Bytes.length > buffer.length) {
            // Handle buffer overflow (e.g., by resizing or chaining buffers)
            // For simplicity, we assume the buffer is large enough
            throw new IllegalStateException("Buffer overflow");
        }

        // Copy the UTF-8 bytes into the buffer
        System.arraycopy(utf8Bytes, 0, buffer, position, utf8Bytes.length);
        lb.setPosition(position + utf8Bytes.length);

        return lb;
    }
}