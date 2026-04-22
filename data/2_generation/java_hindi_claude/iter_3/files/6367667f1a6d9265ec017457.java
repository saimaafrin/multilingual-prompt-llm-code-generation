import java.nio.charset.StandardCharsets;

public class UTF8Decoder {
    
    /**
     * Decodes octets to characters using the UTF-8 decoding and appends the characters to a StringBuffer.
     * @param bytes The byte array containing UTF-8 encoded data
     * @param offset The starting position in the byte array
     * @param length The number of bytes to decode
     * @param buffer The StringBuffer to append decoded characters to
     * @return the index to the next unchecked character in the string to decode
     */
    public static int decodeUTF8(byte[] bytes, int offset, int length, StringBuffer buffer) {
        int endIndex = offset + length;
        int currentIndex = offset;
        
        while (currentIndex < endIndex) {
            int octet = bytes[currentIndex] & 0xFF;
            
            if ((octet & 0x80) == 0) {
                // Single byte character (0xxxxxxx)
                buffer.append((char)octet);
                currentIndex++;
            } else if ((octet & 0xE0) == 0xC0) {
                // Two byte character (110xxxxx 10xxxxxx)
                if (currentIndex + 1 >= endIndex) break;
                
                int value = ((octet & 0x1F) << 6) |
                           (bytes[currentIndex + 1] & 0x3F);
                buffer.append((char)value);
                currentIndex += 2;
            } else if ((octet & 0xF0) == 0xE0) {
                // Three byte character (1110xxxx 10xxxxxx 10xxxxxx)
                if (currentIndex + 2 >= endIndex) break;
                
                int value = ((octet & 0x0F) << 12) |
                           ((bytes[currentIndex + 1] & 0x3F) << 6) |
                           (bytes[currentIndex + 2] & 0x3F);
                buffer.append((char)value);
                currentIndex += 3;
            } else if ((octet & 0xF8) == 0xF0) {
                // Four byte character (11110xxx 10xxxxxx 10xxxxxx 10xxxxxx)
                if (currentIndex + 3 >= endIndex) break;
                
                int value = ((octet & 0x07) << 18) |
                           ((bytes[currentIndex + 1] & 0x3F) << 12) |
                           ((bytes[currentIndex + 2] & 0x3F) << 6) |
                           (bytes[currentIndex + 3] & 0x3F);
                // Convert to surrogate pair for characters outside BMP
                value -= 0x10000;
                buffer.append((char)((value >>> 10) + 0xD800));
                buffer.append((char)((value & 0x3FF) + 0xDC00));
                currentIndex += 4;
            } else {
                // Invalid UTF-8 encoding
                buffer.append('?');
                currentIndex++;
            }
        }
        
        return currentIndex;
    }
}