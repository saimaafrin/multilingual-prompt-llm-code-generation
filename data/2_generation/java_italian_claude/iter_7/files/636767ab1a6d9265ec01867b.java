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

        int remaining = utf8Bytes.length;
        int position = 0;

        while (remaining > 0) {
            int available = currentBuffer.buffer.length - currentBuffer.offset;
            int copyLength = Math.min(available, remaining);

            System.arraycopy(utf8Bytes, position, currentBuffer.buffer, currentBuffer.offset, copyLength);
            
            currentBuffer.offset += copyLength;
            position += copyLength;
            remaining -= copyLength;

            if (remaining > 0) {
                currentBuffer = new LinkedBuffer(Math.max(remaining, 256));
                session.tail = currentBuffer;
            }
        }

        return currentBuffer;
    }

    private static class LinkedBuffer {
        byte[] buffer;
        int offset;
        LinkedBuffer next;

        LinkedBuffer(int size) {
            this.buffer = new byte[size];
            this.offset = 0;
            this.next = null;
        }
    }

    private static class WriteSession {
        LinkedBuffer tail;
    }
}