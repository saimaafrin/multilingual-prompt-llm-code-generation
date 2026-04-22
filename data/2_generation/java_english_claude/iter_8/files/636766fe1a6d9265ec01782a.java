import java.nio.charset.StandardCharsets;

public class ClassReader {
    private byte[] classFileBuffer;
    private int[] cpInfoOffsets;

    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        int offset = cpInfoOffsets[constantPoolEntryIndex];
        int utfLength = readUnsignedShort(offset);
        offset += 2;
        int charLength = 0;
        int currentOffset = offset;
        int endOffset = offset + utfLength;
        
        while (currentOffset < endOffset) {
            int currentByte = classFileBuffer[currentOffset++] & 0xFF;
            if ((currentByte & 0x80) == 0) {
                charBuffer[charLength++] = (char) currentByte;
            } else if ((currentByte & 0xE0) == 0xC0) {
                charBuffer[charLength++] = 
                    (char)(((currentByte & 0x1F) << 6) + 
                    (classFileBuffer[currentOffset++] & 0x3F));
            } else {
                charBuffer[charLength++] = 
                    (char)(((currentByte & 0xF) << 12) + 
                    ((classFileBuffer[currentOffset++] & 0x3F) << 6) + 
                    (classFileBuffer[currentOffset++] & 0x3F));
            }
        }
        return new String(charBuffer, 0, charLength);
    }

    private int readUnsignedShort(final int offset) {
        byte[] classFileBuffer = this.classFileBuffer;
        return ((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF);
    }
}