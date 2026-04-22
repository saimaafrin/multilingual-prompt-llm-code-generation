import org.objectweb.asm.ClassReader;

public class ClassReaderImpl {
    private byte[] classFileBuffer;
    
    public short readShort(final int offset) {
        byte[] b = classFileBuffer;
        return (short) (((b[offset] & 0xFF) << 8) | (b[offset + 1] & 0xFF));
    }
}