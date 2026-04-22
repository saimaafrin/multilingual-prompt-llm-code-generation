import org.objectweb.asm.ClassReader;

public class ClassReaderExtension {
    private ClassReader classReader;
    
    /**
     * 在此 {@link ClassReader} 中读取一个有符号的长整型值。<i>此方法旨在用于 {@link Attribute} 子类，通常不用于类生成器或适配器。</i>
     * @param offset 要读取的值在此 {@link ClassReader} 中的起始偏移量。
     * @return 读取的值。
     */
    public long readLong(final int offset) {
        byte[] b = classReader.b;
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