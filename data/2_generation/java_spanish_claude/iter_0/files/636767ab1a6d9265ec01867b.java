import java.nio.charset.StandardCharsets;

public class StringSerializer {
    /**
     * Escribe los bytes codificados en utf8 de la cadena en el {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || str.length() == 0) {
            return lb;
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int size = utf8Bytes.length;
        
        // Check if current buffer has enough space
        if (lb.offset + size > lb.buffer.length) {
            // Create new buffer if needed
            LinkedBuffer newBuffer = new LinkedBuffer(Math.max(size, lb.buffer.length));
            lb.next = newBuffer;
            session.tail = newBuffer;
            System.arraycopy(utf8Bytes, 0, newBuffer.buffer, 0, size);
            newBuffer.offset = size;
            return newBuffer;
        }

        // Copy bytes to current buffer
        System.arraycopy(utf8Bytes, 0, lb.buffer, lb.offset, size);
        lb.offset += size;
        return lb;
    }

    // Helper class for buffer management
    public static class LinkedBuffer {
        byte[] buffer;
        int offset;
        LinkedBuffer next;

        public LinkedBuffer(int size) {
            this.buffer = new byte[size];
            this.offset = 0;
            this.next = null;
        }
    }

    // Helper class for writing session
    public static class WriteSession {
        LinkedBuffer tail;
        
        public WriteSession() {
            this.tail = null;
        }
    }
}