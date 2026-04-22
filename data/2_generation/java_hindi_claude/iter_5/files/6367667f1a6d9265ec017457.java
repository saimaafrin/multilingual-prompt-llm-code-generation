import java.nio.charset.StandardCharsets;

public class UTF8Decoder {
    
    /**
     * Decodes octets to characters using the UTF-8 decoding and appends the characters to a StringBuffer.
     * @param bytes The byte array containing UTF-8 encoded data
     * @param offset The starting offset in the byte array
     * @param length The number of bytes to decode
     * @param buffer The StringBuffer to append decoded characters to
     * @return the index to the next unchecked character in the string to decode
     */
    public static int decodeUTF8(byte[] bytes, int offset, int length, StringBuffer buffer) {
        int end = offset + length;
        int i = offset;
        
        while (i < end) {
            int byte1 = bytes[i] & 0xFF;
            
            if (byte1 <= 0x7F) {
                // Single byte character
                buffer.append((char)byte1);
                i++;
            }
            else if ((byte1 & 0xE0) == 0xC0) {
                // Two byte character
                if (i + 1 >= end) break;
                int byte2 = bytes[i + 1] & 0xFF;
                if ((byte2 & 0xC0) != 0x80) break;
                
                int codePoint = ((byte1 & 0x1F) << 6) | (byte2 & 0x3F);
                buffer.append((char)codePoint);
                i += 2;
            }
            else if ((byte1 & 0xF0) == 0xE0) {
                // Three byte character
                if (i + 2 >= end) break;
                int byte2 = bytes[i + 1] & 0xFF;
                int byte3 = bytes[i + 2] & 0xFF;
                if ((byte2 & 0xC0) != 0x80 || (byte3 & 0xC0) != 0x80) break;
                
                int codePoint = ((byte1 & 0x0F) << 12) | ((byte2 & 0x3F) << 6) | (byte3 & 0x3F);
                buffer.append((char)codePoint);
                i += 3;
            }
            else if ((byte1 & 0xF8) == 0xF0) {
                // Four byte character
                if (i + 3 >= end) break;
                int byte2 = bytes[i + 1] & 0xFF;
                int byte3 = bytes[i + 2] & 0xFF;
                int byte4 = bytes[i + 3] & 0xFF;
                if ((byte2 & 0xC0) != 0x80 || (byte3 & 0xC0) != 0x80 || (byte4 & 0xC0) != 0x80) break;
                
                int codePoint = ((byte1 & 0x07) << 18) | ((byte2 & 0x3F) << 12) | 
                               ((byte3 & 0x3F) << 6) | (byte4 & 0x3F);
                buffer.append(Character.highSurrogate(codePoint));
                buffer.append(Character.lowSurrogate(codePoint));
                i += 4;
            }
            else {
                // Invalid UTF-8 byte
                break;
            }
        }
        
        return i;
    }
}