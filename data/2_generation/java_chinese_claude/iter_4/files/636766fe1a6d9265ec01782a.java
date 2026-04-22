import java.nio.charset.StandardCharsets;

public class ClassReader {
    private byte[] classFileBuffer;
    private int[] cpInfoOffsets;
    private static final int CONSTANT_UTF8_TAG = 1;

    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        int offset = cpInfoOffsets[constantPoolEntryIndex];
        // Check if the constant pool entry is a CONSTANT_Utf8
        if (classFileBuffer[offset - 1] != CONSTANT_UTF8_TAG) {
            throw new IllegalArgumentException("Expected CONSTANT_Utf8 but found tag " + classFileBuffer[offset - 1]);
        }
        
        // Read the length of UTF8 bytes
        int utfLen = readUnsignedShort(offset);
        offset += 2;
        
        // Read and decode the UTF8 bytes
        int charLen = 0;
        int currentOffset = offset;
        int endOffset = offset + utfLen;
        
        while (currentOffset < endOffset) {
            int currentByte = classFileBuffer[currentOffset++] & 0xFF;
            
            if ((currentByte & 0x80) == 0) { // 1 byte UTF8
                charBuffer[charLen++] = (char) currentByte;
            } else if ((currentByte & 0xE0) == 0xC0) { // 2 bytes UTF8
                charBuffer[charLen++] = (char) (((currentByte & 0x1F) << 6) + 
                    (classFileBuffer[currentOffset++] & 0x3F));
            } else { // 3 bytes UTF8
                charBuffer[charLen++] = (char) (((currentByte & 0xF) << 12) + 
                    ((classFileBuffer[currentOffset++] & 0x3F) << 6) + 
                    (classFileBuffer[currentOffset++] & 0x3F));
            }
        }
        
        return new String(charBuffer, 0, charLen);
    }
    
    private int readUnsignedShort(final int offset) {
        return ((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF);
    }
}