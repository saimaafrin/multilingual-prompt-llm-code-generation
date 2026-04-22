import org.objectweb.asm.ClassReader;

public class ClassReaderUtils {
    /**
     * Reads a signed long value in this {@link ClassReader}. <i>This method is intended for {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public long readLong(int offset) {
        byte[] b = new byte[8];
        System.arraycopy(this.b, offset, b, 0, 8);
        
        return ((long)(b[0] & 0xFF) << 56) |
               ((long)(b[1] & 0xFF) << 48) |
               ((long)(b[2] & 0xFF) << 40) | 
               ((long)(b[3] & 0xFF) << 32) |
               ((long)(b[4] & 0xFF) << 24) |
               ((long)(b[5] & 0xFF) << 16) |
               ((long)(b[6] & 0xFF) << 8) |
               ((long)(b[7] & 0xFF));
    }
    
    private final byte[] b;
    
    public ClassReaderUtils(byte[] b) {
        this.b = b;
    }
}