import org.objectweb.asm.ClassReader;

public class CustomClassReader {
    private ClassReader reader;
    private byte[] classFileBuffer;

    public CustomClassReader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
        this.reader = new ClassReader(classFileBuffer);
    }

    public long readLong(final int offset) {
        byte[] b = classFileBuffer;
        return ((b[offset] & 0xFF) << 56)
            | ((b[offset + 1] & 0xFF) << 48)
            | ((b[offset + 2] & 0xFF) << 40) 
            | ((b[offset + 3] & 0xFF) << 32)
            | ((b[offset + 4] & 0xFF) << 24)
            | ((b[offset + 5] & 0xFF) << 16)
            | ((b[offset + 6] & 0xFF) << 8)
            | (b[offset + 7] & 0xFF);
    }
}