import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ClassFileReader {
    private final ByteBuffer classFileBuffer;

    public ClassFileReader(ByteBuffer classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * 读取 {@link #classFileBuffer} 中的 CONSTANT_Utf8 常量池条目。
     * @param constantPoolEntryIndex 类的常量池表中 CONSTANT_Utf8 条目的索引。
     * @param charBuffer 用于读取字符串的缓冲区。此缓冲区必须足够大。不会自动调整大小。
     * @return 与指定的 CONSTANT_Utf8 条目对应的字符串。
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // 假设常量池条目从索引1开始，并且每个条目占用2个字节
        int offset = constantPoolEntryIndex * 2;

        // 读取字符串长度
        int length = classFileBuffer.getShort(offset) & 0xFFFF;
        offset += 2;

        // 读取字符串内容
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) (classFileBuffer.get(offset + i) & 0xFF);
        }

        // 将字符数组转换为字符串
        return new String(charBuffer, 0, length);
    }
}