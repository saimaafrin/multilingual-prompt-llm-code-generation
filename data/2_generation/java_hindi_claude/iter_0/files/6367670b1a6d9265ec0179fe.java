import java.io.IOException;
import java.io.OutputStream;

public class ByteOutputStream extends OutputStream {
    
    private byte[] buffer;
    private int pos;
    
    public ByteOutputStream() {
        buffer = new byte[32];
        pos = 0;
    }
    
    public void write(byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        
        // Ensure buffer has enough capacity
        if (pos + b.length > buffer.length) {
            byte[] newBuffer = new byte[Math.max(buffer.length * 2, pos + b.length)];
            System.arraycopy(buffer, 0, newBuffer, 0, pos);
            buffer = newBuffer;
        }
        
        // Copy bytes to buffer
        System.arraycopy(b, 0, buffer, pos, b.length);
        pos += b.length;
    }
    
    @Override
    public void write(int b) throws IOException {
        if (pos >= buffer.length) {
            byte[] newBuffer = new byte[buffer.length * 2];
            System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
            buffer = newBuffer;
        }
        buffer[pos++] = (byte)b;
    }
    
    public byte[] toByteArray() {
        byte[] result = new byte[pos];
        System.arraycopy(buffer, 0, result, 0, pos);
        return result;
    }
}