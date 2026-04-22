import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStream extends OutputStream {
    private byte[] buf;
    private int count;
    private static final int DEFAULT_SIZE = 32;

    public ByteArrayOutputStream() {
        buf = new byte[DEFAULT_SIZE];
    }

    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        
        // Ensure capacity
        int newcount = count + b.length;
        if (newcount > buf.length) {
            byte[] newbuf = new byte[Math.max(buf.length << 1, newcount)];
            System.arraycopy(buf, 0, newbuf, 0, count);
            buf = newbuf;
        }
        
        // Copy bytes to buffer
        System.arraycopy(b, 0, buf, count, b.length);
        count = newcount;
    }
}