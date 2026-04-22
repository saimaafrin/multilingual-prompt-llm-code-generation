import org.objectweb.asm.ClassReader;

public class CustomClassReader {
    private ClassReader reader;
    private byte[] classFileBuffer;

    public CustomClassReader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    public long readLong(final int offset) {
        byte[] b = classFileBuffer;
        return (((long) b[offset] & 0xFF) << 56)
                | (((long) b[offset + 1] & 0xFF) << 48)
                | (((long) b[offset + 2] & 0xFF) << 40) 
                | (((long) b[offset + 3] & 0xFF) << 32)
                | (((long) b[offset + 4] & 0xFF) << 24)
                | (((long) b[offset + 5] & 0xFF) << 16)
                | (((long) b[offset + 6] & 0xFF) << 8)
                | (((long) b[offset + 7] & 0xFF));
    }
}