import java.nio.ByteBuffer;

public class ClassReader {
    private ByteBuffer classFileBuffer;
    
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Get the start position of the UTF8 constant pool entry
        int position = classFileBuffer.position();
        
        // Read the length of UTF8 bytes
        int utfLen = classFileBuffer.getShort() & 0xFFFF;
        
        // Read and convert UTF8 bytes to chars
        int charLen = 0;
        int c, c2, c3;
        while (classFileBuffer.position() < position + 2 + utfLen) {
            c = classFileBuffer.get() & 0xFF;
            if (c > 127) {
                classFileBuffer.position(classFileBuffer.position() - 1);
                break;
            }
            charBuffer[charLen++] = (char) c;
        }
        
        while (classFileBuffer.position() < position + 2 + utfLen) {
            c = classFileBuffer.get() & 0xFF;
            switch (c >> 4) {
                case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7:
                    charBuffer[charLen++] = (char) c;
                    break;
                    
                case 12: case 13:
                    c2 = classFileBuffer.get() & 0xFF;
                    charBuffer[charLen++] = (char) (((c & 0x1F) << 6) | (c2 & 0x3F));
                    break;
                    
                case 14:
                    c2 = classFileBuffer.get() & 0xFF;
                    c3 = classFileBuffer.get() & 0xFF;
                    charBuffer[charLen++] = 
                        (char) (((c & 0x0F) << 12) | ((c2 & 0x3F) << 6) | (c3 & 0x3F));
                    break;
                    
                default:
                    throw new IllegalArgumentException(
                        "Invalid UTF8 encoding at constant pool entry " + constantPoolEntryIndex);
            }
        }
        
        return new String(charBuffer, 0, charLen);
    }
}