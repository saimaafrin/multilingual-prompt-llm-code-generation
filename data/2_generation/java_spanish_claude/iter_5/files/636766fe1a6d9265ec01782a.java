import java.nio.ByteBuffer;

public class ClassReader {
    private ByteBuffer classFileBuffer;
    
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Get the UTF8 string length
        int utfLength = classFileBuffer.getShort(constantPoolEntryIndex) & 0xFFFF;
        
        int currentBufferPosition = constantPoolEntryIndex + 2;
        int charBufferIndex = 0;
        
        // Read the UTF8 encoded bytes and convert to chars
        while (utfLength > 0) {
            int currentByte = classFileBuffer.get(currentBufferPosition++) & 0xFF;
            
            if ((currentByte & 0x80) == 0) { // 1 byte UTF8 char
                charBuffer[charBufferIndex++] = (char) currentByte;
                utfLength--;
            } else if ((currentByte & 0xE0) == 0xC0) { // 2 byte UTF8 char
                int byte2 = classFileBuffer.get(currentBufferPosition++) & 0xFF;
                charBuffer[charBufferIndex++] = (char) (((currentByte & 0x1F) << 6) | (byte2 & 0x3F));
                utfLength -= 2;
            } else { // 3 byte UTF8 char
                int byte2 = classFileBuffer.get(currentBufferPosition++) & 0xFF;
                int byte3 = classFileBuffer.get(currentBufferPosition++) & 0xFF;
                charBuffer[charBufferIndex++] = 
                    (char) (((currentByte & 0x0F) << 12) | 
                           ((byte2 & 0x3F) << 6) | 
                           (byte3 & 0x3F));
                utfLength -= 3;
            }
        }
        
        return new String(charBuffer, 0, charBufferIndex);
    }
}