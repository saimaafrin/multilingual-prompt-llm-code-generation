import org.objectweb.asm.ClassReader;

public class ClassReaderUtils {
    /**
     * Reads a signed short value in this {@link ClassReader}. <i>This method is intended for {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public short readShort(int offset) {
        byte[] classFileBuffer = this.getClassFileBuffer();
        return (short) (((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF));
    }

    // Helper method to get class file buffer
    private byte[] getClassFileBuffer() {
        // Implementation would depend on how the class file buffer is stored
        // This is just a placeholder
        return new byte[0];
    }
}