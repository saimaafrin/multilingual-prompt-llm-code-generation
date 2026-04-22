public class UtfReader {
    
    private byte[] classFileBuffer; // Assuming this is initialized elsewhere

    /**
     * 读取 {@link #classFileBuffer} 中的 CONSTANT_Utf8 常量池条目。
     * @param constantPoolEntryIndex 类的常量池表中 CONSTANT_Utf8 条目的索引。
     * @param charBuffer 用于读取字符串的缓冲区。此缓冲区必须足够大。不会自动调整大小。
     * @return 与指定的 CONSTANT_Utf8 条目对应的字符串。
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the classFileBuffer is structured correctly and contains the necessary data
        int offset = getUtf8Offset(constantPoolEntryIndex);
        int length = getUtf8Length(constantPoolEntryIndex);
        
        // Read the UTF-8 bytes and convert to characters
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) (classFileBuffer[offset + i] & 0xFF);
        }
        
        return new String(charBuffer, 0, length);
    }

    private int getUtf8Offset(int index) {
        // Logic to determine the offset of the UTF-8 entry in classFileBuffer
        // This is a placeholder implementation
        return index; // Replace with actual logic
    }

    private int getUtf8Length(int index) {
        // Logic to determine the length of the UTF-8 entry in classFileBuffer
        // This is a placeholder implementation
        return 5; // Replace with actual logic
    }
}