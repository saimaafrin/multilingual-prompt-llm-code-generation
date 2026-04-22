import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int length = utf8Bytes.length;

        // Write the length of the UTF-8 bytes first
        lb = writeLength(length, session, lb);

        // Write the actual UTF-8 bytes
        for (byte b : utf8Bytes) {
            if (lb.remaining() == 0) {
                lb = session.nextBuffer(lb);
            }
            lb.put(b);
        }

        return lb;
    }

    private static LinkedBuffer writeLength(int length, WriteSession session, LinkedBuffer lb) {
        if (length <= 0x7F) {
            if (lb.remaining() == 0) {
                lb = session.nextBuffer(lb);
            }
            lb.put((byte) length);
        } else if (length <= 0x3FFF) {
            if (lb.remaining() < 2) {
                lb = session.nextBuffer(lb);
            }
            lb.put((byte) ((length >> 8) | 0x80));
            lb.put((byte) (length & 0xFF));
        } else {
            if (lb.remaining() < 3) {
                lb = session.nextBuffer(lb);
            }
            lb.put((byte) ((length >> 16) | 0xC0));
            lb.put((byte) ((length >> 8) & 0xFF));
            lb.put((byte) (length & 0xFF));
        }
        return lb;
    }
}

class LinkedBuffer {
    private byte[] buffer;
    private int position;

    public LinkedBuffer(int capacity) {
        this.buffer = new byte[capacity];
        this.position = 0;
    }

    public void put(byte b) {
        if (position >= buffer.length) {
            throw new IllegalStateException("Buffer overflow");
        }
        buffer[position++] = b;
    }

    public int remaining() {
        return buffer.length - position;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getPosition() {
        return position;
    }
}

class WriteSession {
    public LinkedBuffer nextBuffer(LinkedBuffer currentBuffer) {
        // Implement logic to get the next buffer in the chain
        return new LinkedBuffer(currentBuffer.getBuffer().length);
    }
}