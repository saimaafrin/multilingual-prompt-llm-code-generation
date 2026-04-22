import java.nio.ByteBuffer;

public class ClassReader {
    private ByteBuffer classFileBuffer;
    private char[] charBuffer;
    
    public String readUTF8(final int constantPoolEntryIndex, final char[] charBuffer) {
        int currentIndex = classFileBuffer.position();
        int utfLength = classFileBuffer.getShort(currentIndex) & 0xFFFF;
        
        if (utfLength == 0) {
            return "";
        }
        
        int endIndex = currentIndex + 2 + utfLength;
        int strLength = 0;
        int index = currentIndex + 2;
        byte[] classBuffer = classFileBuffer.array();
        
        while (index < endIndex) {
            int currentByte = classBuffer[index++] & 0xFF;
            if ((currentByte & 0x80) == 0) {
                // Single byte character
                charBuffer[strLength++] = (char) currentByte;
            } else if ((currentByte & 0xE0) == 0xC0) {
                // 2-byte character
                charBuffer[strLength++] = (char) (((currentByte & 0x1F) << 6) 
                    | (classBuffer[index++] & 0x3F));
            } else {
                // 3-byte character
                charBuffer[strLength++] = (char) (((currentByte & 0xF) << 12)
                    | ((classBuffer[index++] & 0x3F) << 6) 
                    | (classBuffer[index++] & 0x3F));
            }
        }
        
        classFileBuffer.position(endIndex);
        return new String(charBuffer, 0, strLength);
    }
}