import org.objectweb.asm.ClassReader;

public class CustomClassReader extends ClassReader {
    
    public CustomClassReader(byte[] classFile) {
        super(classFile);
    }

    /**
     * Reads a signed short value in this {@link ClassReader}. <i>This method is intended for {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public short readShort(final int offset) {
        byte[] classFileBuffer = this.b;
        return (short) (((classFileBuffer[offset] & 0xFF) << 8) 
                | (classFileBuffer[offset + 1] & 0xFF));
    }
}