import java.nio.ByteBuffer;

public class ClassReader {
    private ByteBuffer classFileBuffer;
    
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Get the UTF8 string length
        int utfLen = classFileBuffer.getShort(constantPoolEntryIndex) & 0xFFFF;
        
        int strLen = 0;
        int c;
        int st = constantPoolEntryIndex + 2;
        int cc = 0;
        
        while (cc < utfLen) {
            c = classFileBuffer.get(st + cc) & 0xFF;
            if ((c & 0x80) == 0) {
                // 0xxxxxxx
                charBuffer[strLen++] = (char) c;
            } else if ((c & 0xE0) == 0xC0) {
                // 110xxxxx 10xxxxxx
                charBuffer[strLen++] = (char) (((c & 0x1F) << 6) + 
                    (classFileBuffer.get(st + cc + 1) & 0x3F));
                cc++;
            } else {
                // 1110xxxx 10xxxxxx 10xxxxxx
                charBuffer[strLen++] = (char) (((c & 0xF) << 12) + 
                    ((classFileBuffer.get(st + cc + 1) & 0x3F) << 6) +
                    (classFileBuffer.get(st + cc + 2) & 0x3F));
                cc += 2;
            }
            cc++;
        }
        
        return new String(charBuffer, 0, strLen);
    }
}