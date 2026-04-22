import java.nio.charset.StandardCharsets;

public class LinkedBuffer {
    private byte[] buffer;
    private int position;

    public LinkedBuffer(int capacity) {
        this.buffer = new byte[capacity];
        this.position = 0;
    }

    public void write(byte[] data) {
        if (position + data.length > buffer.length) {
            // Resize buffer if necessary
            byte[] newBuffer = new byte[buffer.length * 2];
            System.arraycopy(buffer, 0, newBuffer, 0, position);
            buffer = newBuffer;
        }
        System.arraycopy(data, 0, buffer, position, data.length);
        position += data.length;
    }

    public byte[] toByteArray() {
        byte[] result = new byte[position];
        System.arraycopy(buffer, 0, result, 0, position);
        return result;
    }
}

public class WriteSession {
    // Placeholder for any session-related data or methods
}

public class UTF8Writer {
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || lb == null) {
            throw new IllegalArgumentException("Input parameters cannot be null.");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        lb.write(utf8Bytes);

        return lb;
    }

    public static void main(String[] args) {
        LinkedBuffer lb = new LinkedBuffer(1024);
        WriteSession session = new WriteSession();
        CharSequence str = "Hello, UTF-8!";

        writeUTF8(str, session, lb);

        byte[] result = lb.toByteArray();
        System.out.println(new String(result, StandardCharsets.UTF_8));
    }
}