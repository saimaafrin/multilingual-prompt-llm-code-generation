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
        // 假设 classFileBuffer 中的常量池条目格式为：
        // 1. 先是一个 u2 的长度字段
        // 2. 然后是长度字段指定的字节数的 UTF-8 字节
        int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);
        int length = ((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF);
        
        // 读取 UTF-8 字节并转换为字符
        int charCount = 0;
        for (int i = 0; i < length; i++) {
            charBuffer[charCount++] = (char) classFileBuffer[offset + 2 + i];
        }
        
        return new String(charBuffer, 0, charCount);
    }

    private int getConstantPoolEntryOffset(int index) {
        // 这里需要实现获取常量池条目的偏移量的逻辑
        // 这只是一个占位符，具体实现取决于 classFileBuffer 的结构
        return index; // 需要根据实际常量池结构进行调整
    }
}