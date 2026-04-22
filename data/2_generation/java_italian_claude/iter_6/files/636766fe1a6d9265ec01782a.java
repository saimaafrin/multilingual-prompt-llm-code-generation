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
            if (currentByte > 127) {
                if ((currentByte & 0xE0) == 0xC0) {
                    offset++;
                } else if ((currentByte & 0xF0) == 0xE0) {
                    offset += 2;
                } else {
                    throw new IllegalStateException("Invalid UTF8 string in class file");
                }
            }
            charBuffer[charLen++] = (char) currentByte;
        }
        
        return new String(charBuffer, 0, charLen);
    }
}