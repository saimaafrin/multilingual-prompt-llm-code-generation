import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        // Convert the CharSequence to a byte array using UTF-8 encoding
        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);

        // Write the bytes to the LinkedBuffer
        for (byte b : utf8Bytes) {
            lb = session.write(b, lb);
        }

        return lb;
    }

    // Assuming LinkedBuffer and WriteSession are defined elsewhere
    public static class LinkedBuffer {
        // Placeholder for LinkedBuffer implementation
    }

    public static class WriteSession {
        // Placeholder for WriteSession implementation
        public LinkedBuffer write(byte b, LinkedBuffer lb) {
            // Placeholder for write implementation
            return lb;
        }
    }
}