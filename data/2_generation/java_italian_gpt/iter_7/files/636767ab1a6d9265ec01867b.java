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
        CharSequence str = "Hello, World!";
        
        writeUTF8(str, session, lb);
        System.out.println("Written bytes: " + lb.getBytes());
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

    public LinkedList<byte[]> getBytes() {
        return buffer;
    }
}