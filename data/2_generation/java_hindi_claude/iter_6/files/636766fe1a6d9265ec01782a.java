import java.nio.ByteBuffer;

public class ClassReader {
    private ByteBuffer classFileBuffer;
    private char[] charBuffer;
    
    public String readUtf8(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Get the start index of this UTF8 string in the class file
        int currentIndex = getItemIndex(constantPoolEntryIndex);
        int utfLength = readUnsignedShort(currentIndex);
        currentIndex += 2;
        
        // Read the UTF8 string characters
        int charIndex = 0;
        int endIndex = currentIndex + utfLength;
        while (currentIndex < endIndex) {
            int currentByte = classFileBuffer.get(currentIndex++) & 0xFF;
            if ((currentByte & 0x80) == 0) {
                // Single byte character
                charBuffer[charIndex++] = (char) currentByte;
            } else if ((currentByte & 0xE0) == 0xC0) {
                // Two byte character
                charBuffer[charIndex++] = (char) (((currentByte & 0x1F) << 6) 
                    | (classFileBuffer.get(currentIndex++) & 0x3F));
            } else {
                // Three byte character
                charBuffer[charIndex++] = (char) (((currentByte & 0xF) << 12)
                    | ((classFileBuffer.get(currentIndex++) & 0x3F) << 6)
                    | (classFileBuffer.get(currentIndex++) & 0x3F));
            }
        }
        
        // Return the decoded string
        return new String(charBuffer, 0, charIndex);
    }
    
    // Helper method to get the start index of a constant pool entry
    private int getItemIndex(int constantPoolIndex) {
        // Implementation would depend on constant pool structure
        return 0; // Placeholder
    }
    
    // Helper method to read an unsigned short from the buffer
    private int readUnsignedShort(int index) {
        return ((classFileBuffer.get(index) & 0xFF) << 8) | (classFileBuffer.get(index + 1) & 0xFF);
    }
}