import java.nio.charset.StandardCharsets;

public class StringSerializer {
    
    /**
     * Writes the utf8-encoded bytes from the string into the LinkedBuffer.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || str.length() == 0) {
            return lb;
        }

        final byte[] bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        LinkedBuffer buffer = lb;
        
        // Check if current buffer has enough space
        if (buffer.offset + bytes.length > buffer.buffer.length) {
            // Create new buffer if needed
            buffer = new LinkedBuffer(Math.max(bytes.length, buffer.buffer.length));
            session.tail = buffer;
            if (session.head == null) {
                session.head = buffer;
            }
        }
        
        // Copy bytes to buffer
        System.arraycopy(bytes, 0, buffer.buffer, buffer.offset, bytes.length);
        buffer.offset += bytes.length;
        
        return buffer;
    }
    
    // Supporting classes needed for compilation
    public static class LinkedBuffer {
        byte[] buffer;
        int offset;
        LinkedBuffer next;
        
        public LinkedBuffer(int size) {
            this.buffer = new byte[size];
            this.offset = 0;
        }
    }
    
    public static class WriteSession {
        LinkedBuffer head;
        LinkedBuffer tail;
    }
}