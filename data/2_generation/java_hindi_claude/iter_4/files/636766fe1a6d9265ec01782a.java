import java.nio.ByteBuffer;

public class ConstantPoolReader {
    private byte[] classFileBuffer;
    private int[] cpInfoOffsets;
    
    public String readUtf8(final int constantPoolEntryIndex, final char[] charBuffer) {
        int currentOffset = cpInfoOffsets[constantPoolEntryIndex];
        int utfLength = readUnsignedShort(currentOffset);
        currentOffset += 2;
        int charLength = 0;
        int currentByte;
        
        // Compute the length of the UTF8 string in characters
        int endOffset = currentOffset + utfLength;
        while (currentOffset < endOffset) {
            currentByte = classFileBuffer[currentOffset++] & 0xFF;
            if ((currentByte & 0x80) == 0) {
                charBuffer[charLength++] = (char) currentByte;
            } else if ((currentByte & 0xE0) == 0xC0) {
                charBuffer[charLength++] = 
                    (char) (((currentByte & 0x1F) << 6) + 
                           (classFileBuffer[currentOffset++] & 0x3F));
            } else {
                charBuffer[charLength++] = 
                    (char) (((currentByte & 0xF) << 12) + 
                           ((classFileBuffer[currentOffset++] & 0x3F) << 6) + 
                           (classFileBuffer[currentOffset++] & 0x3F));
            }
        }
        
        return new String(charBuffer, 0, charLength);
    }
    
    private int readUnsignedShort(final int offset) {
        return ((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF);
    }
}