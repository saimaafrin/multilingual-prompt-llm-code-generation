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
        final int bytesLength = bytes.length;
        
        if (lb.offset + bytesLength > lb.buffer.length) {
            // Not enough space in current buffer, create new one
            LinkedBuffer newBuffer = new LinkedBuffer(Math.max(bytesLength, LinkedBuffer.DEFAULT_BUFFER_SIZE));
            lb.next = newBuffer;
            System.arraycopy(bytes, 0, newBuffer.buffer, 0, bytesLength);
            newBuffer.offset = bytesLength;
            session.size += bytesLength;
            return newBuffer;
        }
        
        // Enough space in current buffer
        System.arraycopy(bytes, 0, lb.buffer, lb.offset, bytesLength);
        lb.offset += bytesLength;
        session.size += bytesLength;
        return lb;
    }
    
    // Supporting classes needed for compilation
    public static class LinkedBuffer {
        public static final int DEFAULT_BUFFER_SIZE = 256;
        byte[] buffer;
        int offset;
        LinkedBuffer next;
        
        public LinkedBuffer(int size) {
            buffer = new byte[size];
            offset = 0;
            next = null;
        }
    }
    
    public static class WriteSession {
        int size;
        
        public WriteSession() {
            size = 0;
        }
    }
}