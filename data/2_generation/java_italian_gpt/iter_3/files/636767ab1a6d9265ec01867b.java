import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class UTF8Writer {

    /** 
     * Scrive i byte codificati in utf8 dalla stringa nel {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || lb == null) {
            throw new IllegalArgumentException("Input string and LinkedBuffer cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        lb.addBytes(utf8Bytes);
        return lb;
    }

    public static void main(String[] args) {
        // Example usage
        WriteSession session = new WriteSession();
        LinkedBuffer lb = new LinkedBuffer();
        writeUTF8("Hello, World!", session, lb);
        System.out.println(lb);
    }
}

class WriteSession {
    // Implementation of WriteSession
}

class LinkedBuffer {
    private LinkedList<byte[]> buffer = new LinkedList<>();

    public void addBytes(byte[] bytes) {
        buffer.add(bytes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte[] bytes : buffer) {
            sb.append(new String(bytes, StandardCharsets.UTF_8));
        }
        return sb.toString();
    }
}