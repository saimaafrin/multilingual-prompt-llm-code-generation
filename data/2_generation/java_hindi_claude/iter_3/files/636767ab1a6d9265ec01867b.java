import java.nio.charset.StandardCharsets;

public class StringUtils {
    /**
     * Writes the utf8-encoded bytes from the string into the LinkedBuffer.
     * @param str The input string to encode
     * @param buffer The buffer to write the encoded bytes to
     * @return The number of bytes written
     */
    public static int writeUTF8(String str, LinkedBuffer buffer) {
        if (str == null || buffer == null) {
            return 0;
        }

        byte[] utf8Bytes = str.getBytes(StandardCharsets.UTF_8);
        buffer.write(utf8Bytes);
        return utf8Bytes.length;
    }
}

class LinkedBuffer {
    private byte[] buffer;
    private int position;
    private static final int DEFAULT_CAPACITY = 256;

    public LinkedBuffer() {
        this(DEFAULT_CAPACITY);
    }

    public LinkedBuffer(int size) {
        buffer = new byte[size];
        position = 0;
    }

    public void write(byte[] bytes) {
        if (position + bytes.length > buffer.length) {
            // Resize buffer if needed
            byte[] newBuffer = new byte[Math.max(buffer.length * 2, position + bytes.length)];
            System.arraycopy(buffer, 0, newBuffer, 0, position);
            buffer = newBuffer;
        }
        System.arraycopy(bytes, 0, buffer, position, bytes.length);
        position += bytes.length;
    }

    public byte[] toByteArray() {
        byte[] result = new byte[position];
        System.arraycopy(buffer, 0, result, 0, position);
        return result;
    }
}