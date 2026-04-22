import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int length = utf8Bytes.length;

        // Ensure the buffer has enough space
        if (lb.remaining() < length) {
            lb = LinkedBuffer.allocate(Math.max(lb.capacity() * 2, length));
        }

        // Write the length of the UTF-8 bytes first
        session.writeVarInt32(length, lb);

        // Write the actual UTF-8 bytes
        lb.put(utf8Bytes, 0, length);

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

    public int remaining() {
        return buffer.length - position;
    }

    public int capacity() {
        return buffer.length;
    }

    public void put(byte[] src, int offset, int length) {
        System.arraycopy(src, offset, buffer, position, length);
        position += length;
    }

    public static LinkedBuffer allocate(int capacity) {
        return new LinkedBuffer(capacity);
    }
}

class WriteSession {
    public void writeVarInt32(int value, LinkedBuffer lb) {
        // Simplified implementation for writing a variable-length integer
        while ((value & 0xFFFFFF80) != 0) {
            lb.put(new byte[]{(byte) ((value & 0x7F) | 0x80)}, 0, 1);
            value >>>= 7;
        }
        lb.put(new byte[]{(byte) (value & 0x7F)}, 0, 1);
    }
}