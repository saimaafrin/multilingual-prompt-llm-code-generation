import java.nio.ByteBuffer;

public class UTF8Decoder {

    /**
     * Decodes octets to characters using the UTF-8 decoding and appends the characters to a StringBuffer.
     * @return the index to the next unchecked character in the string to decode
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        int b1 = bb.get(i) & 0xFF;
        
        // 1 byte UTF-8 character
        if ((b1 & 0x80) == 0) {
            sb.append((char)b1);
            return i + 1;
        }
        
        // 2 byte UTF-8 character
        if ((b1 & 0xE0) == 0xC0) {
            int b2 = bb.get(i + 1) & 0xFF;
            if ((b2 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 encoding");
            }
            int ch = ((b1 & 0x1F) << 6) | (b2 & 0x3F);
            sb.append((char)ch);
            return i + 2;
        }
        
        // 3 byte UTF-8 character
        if ((b1 & 0xF0) == 0xE0) {
            int b2 = bb.get(i + 1) & 0xFF;
            int b3 = bb.get(i + 2) & 0xFF;
            if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 encoding");
            }
            int ch = ((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
            sb.append((char)ch);
            return i + 3;
        }
        
        // 4 byte UTF-8 character
        if ((b1 & 0xF8) == 0xF0) {
            int b2 = bb.get(i + 1) & 0xFF;
            int b3 = bb.get(i + 2) & 0xFF;
            int b4 = bb.get(i + 3) & 0xFF;
            if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80 || (b4 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 encoding");
            }
            int ch = ((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
            // Convert to surrogate pair for characters outside BMP
            ch -= 0x10000;
            sb.append((char)(0xD800 | ((ch >> 10) & 0x3FF)));
            sb.append((char)(0xDC00 | (ch & 0x3FF)));
            return i + 4;
        }
        
        throw new IllegalArgumentException("Invalid UTF-8 encoding");
    }
}