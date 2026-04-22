import org.objectweb.asm.ClassReader;

public class ClassReaderImpl {
    private byte[] classFileBuffer;
    
    public short readShort(final int offset) {
        // 从字节数组中读取两个字节并组合成short
        // 由于Java使用大端序存储,需要先读高字节再读低字节
        return (short)(((classFileBuffer[offset] & 0xFF) << 8) 
                | (classFileBuffer[offset + 1] & 0xFF));
    }
}