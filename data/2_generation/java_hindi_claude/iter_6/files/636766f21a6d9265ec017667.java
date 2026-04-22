import org.objectweb.asm.ClassReader;

public class ClassReaderUtils {
    /**
     * Reads a signed short value in this {@link ClassReader}. <i>This method is intended for {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public short readShort(int offset) {
        byte[] classFileBuffer = new byte[offset + 2];
        return (short) ((classFileBuffer[offset] << 8) | (classFileBuffer[offset + 1] & 0xFF));
    }
}