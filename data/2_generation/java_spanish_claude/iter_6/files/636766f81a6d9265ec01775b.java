import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Attribute;

public class CustomClassReader extends ClassReader {

    public CustomClassReader(byte[] classFile) {
        super(classFile);
    }

    public long readLong(final int offset) {
        // Read 8 bytes starting at offset and combine into a long
        long high = readInt(offset);
        long low = readInt(offset + 4) & 0xFFFFFFFFL;
        return (high << 32) | low;
    }

    private int readInt(final int offset) {
        byte[] classFileBuffer = getBytesFromClassReader();
        return ((classFileBuffer[offset] & 0xFF) << 24)
            | ((classFileBuffer[offset + 1] & 0xFF) << 16)
            | ((classFileBuffer[offset + 2] & 0xFF) << 8)
            | (classFileBuffer[offset + 3] & 0xFF);
    }

    private byte[] getBytesFromClassReader() {
        try {
            java.lang.reflect.Field field = ClassReader.class.getDeclaredField("b");
            field.setAccessible(true);
            return (byte[]) field.get(this);
        } catch (Exception e) {
            throw new RuntimeException("Could not access ClassReader bytes", e);
        }
    }
}