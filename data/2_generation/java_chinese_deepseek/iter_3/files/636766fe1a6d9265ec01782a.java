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
        // 假设常量池条目索引指向的 CONSTANT_Utf8 条目的格式为：
        // 1字节的 tag (值为1)
        // 2字节的 length
        // length 字节的 UTF-8 编码字符串

        // 定位到常量池条目的起始位置
        int position = constantPoolEntryIndex;

        // 读取 tag (应为1，表示 CONSTANT_Utf8)
        byte tag = classFileBuffer.get(position);
        if (tag != 1) {
            throw new IllegalArgumentException("Invalid CONSTANT_Utf8 tag: " + tag);
        }

        // 读取字符串长度
        int length = classFileBuffer.getShort(position + 1) & 0xFFFF;

        // 读取 UTF-8 编码的字节数据
        byte[] utf8Bytes = new byte[length];
        classFileBuffer.position(position + 3);
        classFileBuffer.get(utf8Bytes);

        // 将 UTF-8 字节数据解码为字符串
        String str = new String(utf8Bytes, StandardCharsets.UTF_8);

        // 将字符串复制到 charBuffer 中
        str.getChars(0, str.length(), charBuffer, 0);

        return str;
    }
}