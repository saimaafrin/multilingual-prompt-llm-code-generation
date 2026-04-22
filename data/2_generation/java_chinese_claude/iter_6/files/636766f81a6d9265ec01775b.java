import org.objectweb.asm.ClassReader;

public class ClassReaderHelper {
    /**
     * 在此 {@link ClassReader} 中读取一个有符号的长整型值。<i>此方法旨在用于 {@link Attribute} 子类，通常不用于类生成器或适配器。</i>
     * @param offset 要读取的值在此 {@link ClassReader} 中的起始偏移量。
     * @return 读取的值。
     */
    public long readLong(final int offset) {
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
    
    private byte[] b; // Class file byte array
    
    public ClassReaderHelper(byte[] classFile) {
        this.b = classFile;
    }
}