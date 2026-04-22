import org.objectweb.asm.ClassReader;

public class CustomClassReader extends ClassReader {
    
    public CustomClassReader(byte[] classFile) {
        super(classFile);
    }

    /**
     * Reads a signed long value in this {@link ClassReader}. <i>This method is intended for {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public long readLong(final int offset) {
        byte[] b = this.b;
        return (((long)b[offset] & 0xFF) << 56)
            | (((long)b[offset + 1] & 0xFF) << 48)
            | (((long)b[offset + 2] & 0xFF) << 40) 
            | (((long)b[offset + 3] & 0xFF) << 32)
            | (((long)b[offset + 4] & 0xFF) << 24)
            | (((long)b[offset + 5] & 0xFF) << 16)
            | (((long)b[offset + 6] & 0xFF) << 8)
            | ((long)b[offset + 7] & 0xFF);
    }
}