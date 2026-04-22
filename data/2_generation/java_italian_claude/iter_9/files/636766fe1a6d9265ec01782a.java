import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class ClassFileReader {
    private byte[] classFileBuffer;
    private int[] cpInfoOffsets;
    
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        int offset = cpInfoOffsets[constantPoolEntryIndex];
        int utfLen = ((classFileBuffer[offset + 1] & 0xFF) << 8) | (classFileBuffer[offset + 2] & 0xFF);
        offset += 3;
        
        int charLen = 0;
        int max = offset + utfLen;
        while (offset < max) {
            int currentByte = classFileBuffer[offset++] & 0xFF;
            if (currentByte < 0x80) {
                // 1 byte UTF-8 encoding
                charBuffer[charLen++] = (char) currentByte;
            } else if ((currentByte & 0xE0) == 0xC0) {
                // 2 byte UTF-8 encoding
                charBuffer[charLen++] = (char) (((currentByte & 0x1F) << 6) | 
                    (classFileBuffer[offset++] & 0x3F));
            } else {
                // 3 byte UTF-8 encoding
                charBuffer[charLen++] = (char) (((currentByte & 0xF) << 12) | 
                    ((classFileBuffer[offset++] & 0x3F) << 6) | 
                    (classFileBuffer[offset++] & 0x3F));
            }
        }
        return new String(charBuffer, 0, charLen);
    }
}