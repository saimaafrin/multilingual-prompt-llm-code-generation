public class UtfReader {
    private byte[] classFileBuffer;

    public UtfReader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * 读取 {@link #classFileBuffer} 中的 CONSTANT_Utf8 常量池条目。
     * @param constantPoolEntryIndex 类的常量池表中 CONSTANT_Utf8 条目的索引。
     * @param charBuffer 用于读取字符串的缓冲区。此缓冲区必须足够大。不会自动调整大小。
     * @return 与指定的 CONSTANT_Utf8 条目对应的字符串。
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // 假设 classFileBuffer 中的 CONSTANT_Utf8 条目格式为：
        // 1. 2字节的长度
        // 2. 紧接着是 UTF-8 字符串的字节
        int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);
        int length = ((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF);
        
        // 读取 UTF-8 字符串
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) (classFileBuffer[offset + 2 + i] & 0xFF);
        }
        
        return new String(charBuffer, 0, length);
    }

    private int getConstantPoolEntryOffset(int index) {
        // 这里需要实现获取常量池条目的偏移量的逻辑
        // 这只是一个示例，具体实现取决于 classFileBuffer 的结构
        // 假设每个常量池条目占用固定大小
        return index * 10; // 示例值，实际值应根据常量池条目的大小计算
    }
}