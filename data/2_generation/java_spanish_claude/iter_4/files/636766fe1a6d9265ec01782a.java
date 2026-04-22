import java.nio.ByteBuffer;

public class ClassReader {
    private ByteBuffer classFileBuffer;
    
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Get the UTF8 string length from the constant pool entry
        int utfLength = classFileBuffer.getShort(constantPoolEntryIndex) & 0xFFFF;
        
        // Position buffer at start of UTF8 bytes
        int currentPosition = constantPoolEntryIndex + 2;
        int endPosition = currentPosition + utfLength;
        
        // Index in the char buffer
        int strLength = 0;
        
        // Read the UTF8 bytes
        while (currentPosition < endPosition) {
            int currentByte = classFileBuffer.get(currentPosition++) & 0xFF;
            
            if ((currentByte & 0x80) == 0) {
                // Single byte character
                charBuffer[strLength++] = (char) currentByte;
            } else if ((currentByte & 0xE0) == 0xC0) {
                // 2-byte character
                charBuffer[strLength++] = (char) (((currentByte & 0x1F) << 6) 
                    | (classFileBuffer.get(currentPosition++) & 0x3F));
            } else {
                // 3-byte character
                charBuffer[strLength++] = (char) (((currentByte & 0xF) << 12)
                    | ((classFileBuffer.get(currentPosition++) & 0x3F) << 6)
                    | (classFileBuffer.get(currentPosition++) & 0x3F));
            }
        }
        
        // Convert char buffer to String
        return new String(charBuffer, 0, strLength);
    }
}