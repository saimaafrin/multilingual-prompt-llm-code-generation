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

    public static class LinkedBuffer {
        private final LinkedList<byte[]> buffers = new LinkedList<>();

        public void write(byte[] bytes) {
            buffers.add(bytes);
        }

        public LinkedList<byte[]> getBuffers() {
            return buffers;
        }
    }

    public static class WriteSession {
        // Implementation of WriteSession can be added here
    }

    public static void main(String[] args) {
        WriteSession session = new WriteSession();
        LinkedBuffer lb = new LinkedBuffer();
        String testString = "Hello, UTF-8!";
        
        writeUTF8(testString, session, lb);
        
        // Output the buffers for verification
        for (byte[] buffer : lb.getBuffers()) {
            System.out.println(new String(buffer, StandardCharsets.UTF_8));
        }
    }
}