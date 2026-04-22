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
        int charLen = 0;
        int max = offset + utfLen;
        while (offset < max) {
            int b1 = classFileBuffer[offset++] & 0xFF;
            switch (b1 >> 4) {
                case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7:
                    // 1 byte
                    charBuffer[charLen++] = (char) b1;
                    break;
                    
                case 12: case 13:
                    // 2 bytes
                    charBuffer[charLen++] = (char) ((b1 & 0x1F) << 6 | classFileBuffer[offset++] & 0x3F);
                    break;
                    
                case 14:
                    // 3 bytes
                    charBuffer[charLen++] = (char) (
                        (b1 & 0x0F) << 12 |
                        (classFileBuffer[offset++] & 0x3F) << 6 |
                        (classFileBuffer[offset++] & 0x3F)
                    );
                    break;
                    
                default:
                    // 2 bytes
                    charBuffer[charLen++] = (char) ((b1 & 0x0F) << 6 | classFileBuffer[offset++] & 0x3F);
            }
        }
        
        return new String(charBuffer, 0, charLen);
    }
    
    private int readUnsignedShort(final int offset) {
        byte[] classFileBuffer = this.classFileBuffer;
        return ((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF);
    }
}