import java.nio.charset.StandardCharsets;

public class Utf8Writer {

    /** 
     * Writes the utf8-encoded bytes from the string into the  {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || lb == null) {
            throw new IllegalArgumentException("String and LinkedBuffer must not be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        lb.write(utf8Bytes);
        return lb;
    }
}

class LinkedBuffer {
    private byte[] buffer;
    private int position;

    public LinkedBuffer(int size) {
        buffer = new byte[size];
        position = 0;
    }

    public void write(byte[] bytes) {
        if (position + bytes.length > buffer.length) {
            throw new ArrayIndexOutOfBoundsException("Not enough space in LinkedBuffer");
        }
        System.arraycopy(bytes, 0, buffer, position, bytes.length);
        position += bytes.length;
    }

    // Additional methods for LinkedBuffer can be added here
}

class WriteSession {
    // Implementation of WriteSession can be added here
}