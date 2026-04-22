import java.nio.ByteBuffer;

public class ClassReader {
    private ByteBuffer classFileBuffer;
    private char[] charBuffer;
    
    public String readUTF8(final int constantPoolEntryIndex, final char[] charBuffer) {
        int currentIndex = classFileBuffer.position();
        int utfLength = classFileBuffer.getShort(currentIndex) & 0xFFFF;
        currentIndex += 2;
        
        int charLength = 0;
        int endIndex = currentIndex + utfLength;
        
        while (currentIndex < endIndex) {
            int currentByte = classFileBuffer.get(currentIndex++) & 0xFF;
            if ((currentByte & 0x80) == 0) {
                // Single byte character
                charBuffer[charLength++] = (char) currentByte;
            } else if ((currentByte & 0xE0) == 0xC0) {
                // Two byte character
                charBuffer[charLength++] = (char) (((currentByte & 0x1F) << 6) 
                    | (classFileBuffer.get(currentIndex++) & 0x3F));
            } else {
                // Three byte character
                charBuffer[charLength++] = (char) (((currentByte & 0xF) << 12)
                    | ((classFileBuffer.get(currentIndex++) & 0x3F) << 6)
                    | (classFileBuffer.get(currentIndex++) & 0x3F));
            }
        }
        
        classFileBuffer.position(endIndex);
        return new String(charBuffer, 0, charLength);
    }
}