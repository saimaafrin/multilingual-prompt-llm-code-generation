import java.nio.charset.StandardCharsets;

public class UTF8Writer {
    /**
     * Scrive i byte codificati in utf8 dalla stringa nel {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || str.length() == 0) {
            return lb;
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        LinkedBuffer currentBuffer = lb;
        
        int offset = 0;
        while (offset < utf8Bytes.length) {
            int remaining = currentBuffer.buffer.length - currentBuffer.offset;
            int bytesToCopy = Math.min(remaining, utf8Bytes.length - offset);
            
            System.arraycopy(utf8Bytes, offset, currentBuffer.buffer, currentBuffer.offset, bytesToCopy);
            currentBuffer.offset += bytesToCopy;
            offset += bytesToCopy;
            
            if (offset < utf8Bytes.length) {
                currentBuffer = new LinkedBuffer(session.nextBufferSize);
                session.tail = currentBuffer;
            }
        }
        
        return currentBuffer;
    }
    
    // Supporting class definitions
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
        LinkedBuffer tail;
        int nextBufferSize;
        
        public WriteSession(int bufferSize) {
            this.nextBufferSize = bufferSize;
        }
    }
}