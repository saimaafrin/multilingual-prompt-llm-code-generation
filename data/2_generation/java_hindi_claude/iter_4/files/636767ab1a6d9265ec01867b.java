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

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        buffer.write(bytes, 0, bytes.length);
        return bytes.length;
    }
}

class LinkedBuffer {
    private byte[] buffer;
    private int position;
    
    public LinkedBuffer(int size) {
        buffer = new byte[size];
        position = 0;
    }
    
    public void write(byte[] bytes, int offset, int length) {
        if (position + length > buffer.length) {
            // Resize buffer if needed
            byte[] newBuffer = new byte[Math.max(buffer.length * 2, position + length)];
            System.arraycopy(buffer, 0, newBuffer, 0, position);
            buffer = newBuffer;
        }
        
        System.arraycopy(bytes, offset, buffer, position, length);
        position += length;
    }
    
    public byte[] toByteArray() {
        byte[] result = new byte[position];
        System.arraycopy(buffer, 0, result, 0, position);
        return result;
    }
}