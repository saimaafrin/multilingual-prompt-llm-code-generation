import java.nio.ByteBuffer;

public class ConstantPoolReader {
    private byte[] classFileBuffer;
    private int[] cpInfoOffsets;
    
    public String readUTF8(final int constantPoolEntryIndex, final char[] charBuffer) {
        int offset = cpInfoOffsets[constantPoolEntryIndex];
        int length = readUnsignedShort(offset);
        offset += 2;
        
        int charLength = 0;
        int currentOffset = offset;
        int endOffset = offset + length;
        
        while (currentOffset < endOffset) {
            int currentByte = classFileBuffer[currentOffset++] & 0xFF;
            if ((currentByte & 0x80) == 0) {
                // Single byte character
                charBuffer[charLength++] = (char) currentByte;
            } else if ((currentByte & 0xE0) == 0xC0) {
                // Two byte character
                charBuffer[charLength++] = (char) (((currentByte & 0x1F) << 6) 
                    | (classFileBuffer[currentOffset++] & 0x3F));
            } else {
                // Three byte character
                charBuffer[charLength++] = (char) (((currentByte & 0xF) << 12)
                    | ((classFileBuffer[currentOffset++] & 0x3F) << 6)
                    | (classFileBuffer[currentOffset++] & 0x3F));
            }
        }
        return new String(charBuffer, 0, charLength);
    }
    
    private int readUnsignedShort(final int offset) {
        return ((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF);
    }
}