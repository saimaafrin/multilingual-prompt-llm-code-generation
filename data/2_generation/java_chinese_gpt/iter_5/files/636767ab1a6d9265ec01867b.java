import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || lb == null) {
            throw new IllegalArgumentException("Input string and LinkedBuffer cannot be null");
        }

        byte[] bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        lb.write(bytes);
        return lb;
    }

    public static void main(String[] args) {
        // Example usage
        WriteSession session = new WriteSession();
        LinkedBuffer lb = new LinkedBuffer();
        String exampleString = "Hello, UTF-8!";
        
        writeUTF8(exampleString, session, lb);
        System.out.println("Written bytes: " + lb.getBytes());
    }
}

class WriteSession {
    // Implementation of WriteSession
}

class LinkedBuffer {
    private LinkedList<Byte> buffer = new LinkedList<>();

    public void write(byte[] bytes) {
        for (byte b : bytes) {
            buffer.add(b);
        }
    }

    public byte[] getBytes() {
        byte[] byteArray = new byte[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            byteArray[i] = buffer.get(i);
        }
        return byteArray;
    }
}