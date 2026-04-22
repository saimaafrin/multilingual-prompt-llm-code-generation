public class UtfReader {
    
    private byte[] classFileBuffer;

    /**
     * 读取 {@link #classFileBuffer} 中的 CONSTANT_Utf8 常量池条目。
     * @param constantPoolEntryIndex 类的常量池表中 CONSTANT_Utf8 条目的索引。
     * @param charBuffer 用于读取字符串的缓冲区。此缓冲区必须足够大。不会自动调整大小。
     * @return 与指定的 CONSTANT_Utf8 条目对应的字符串。
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // 假设 classFileBuffer 已经被填充并且常量池的偏移量已知
        int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);
        int length = (classFileBuffer[offset] << 8) + (classFileBuffer[offset + 1] & 0xFF);
        
        // 读取 UTF-8 字符串
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) ((classFileBuffer[offset + 2 + (i * 2)] << 8) + (classFileBuffer[offset + 2 + (i * 2) + 1] & 0xFF));
        }
        
        return new String(charBuffer, 0, length);
    }

    private int getConstantPoolEntryOffset(int index) {
        // 这里应该有逻辑来计算常量池条目的偏移量
        // 这只是一个占位符实现
        return index * 2; // 示例实现
    }
}