import java.nio.charset.StandardCharsets;

public class ClassReader {
    private byte[] classFileBuffer;
    private int[] cpInfoOffsets;
    private static final int CONSTANT_UTF8_TAG = 1;

    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        int offset = cpInfoOffsets[constantPoolEntryIndex];
        
        // Check if entry is CONSTANT_Utf8
        if (classFileBuffer[offset - 1] != CONSTANT_UTF8_TAG) {
            throw new IllegalArgumentException("Expected CONSTANT_Utf8 at index " + constantPoolEntryIndex);
        }
        
        // Read the length of UTF8 bytes
        int utfLen = readUnsignedShort(offset);
        offset += 2;
        
        // Read and decode UTF8 bytes into characters
        int strLen = 0;
        int charIndex = 0;
        int endOffset = offset + utfLen;
        
        while (offset < endOffset) {
            int byte1 = classFileBuffer[offset++] & 0xFF;
            
            if ((byte1 & 0x80) == 0) { // 1 byte UTF8
                charBuffer[charIndex++] = (char) byte1;
            } else if ((byte1 & 0xE0) == 0xC0) { // 2 byte UTF8
                int byte2 = classFileBuffer[offset++] & 0xFF;
                charBuffer[charIndex++] = (char) (((byte1 & 0x1F) << 6) | (byte2 & 0x3F));
            } else { // 3 byte UTF8
                int byte2 = classFileBuffer[offset++] & 0xFF;
                int byte3 = classFileBuffer[offset++] & 0xFF;
                charBuffer[charIndex++] = (char) (((byte1 & 0x0F) << 12) 
                    | ((byte2 & 0x3F) << 6) 
                    | (byte3 & 0x3F));
            }
            strLen++;
        }
        
        return new String(charBuffer, 0, strLen);
    }
    
    private int readUnsignedShort(final int offset) {
        return ((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF);
    }
}