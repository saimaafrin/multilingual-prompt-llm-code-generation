import java.nio.ByteBuffer;

public class UTF8Decoder {

    /**
     * Decodes octets to characters using the UTF-8 decoding and appends the characters to a StringBuffer.
     * @return the index to the next unchecked character in the string to decode
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        int b1 = bb.get(i) & 0xFF;
        
        // Single byte character
        if ((b1 >> 7) == 0) {
            sb.append((char)b1);
            return i + 1;
        }
        
        // Two byte character
        if ((b1 >> 5) == 0b110) {
            int b2 = bb.get(i + 1) & 0xFF;
            if ((b2 >> 6) != 0b10) {
                throw new IllegalArgumentException("Invalid UTF-8 encoding");
            }
            int cp = ((b1 & 0x1F) << 6) | (b2 & 0x3F);
            sb.append((char)cp);
            return i + 2;
        }
        
        // Three byte character
        if ((b1 >> 4) == 0b1110) {
            int b2 = bb.get(i + 1) & 0xFF;
            int b3 = bb.get(i + 2) & 0xFF;
            if ((b2 >> 6) != 0b10 || (b3 >> 6) != 0b10) {
                throw new IllegalArgumentException("Invalid UTF-8 encoding");
            }
            int cp = ((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
            sb.append((char)cp);
            return i + 3;
        }
        
        // Four byte character
        if ((b1 >> 3) == 0b11110) {
            int b2 = bb.get(i + 1) & 0xFF;
            int b3 = bb.get(i + 2) & 0xFF;
            int b4 = bb.get(i + 3) & 0xFF;
            if ((b2 >> 6) != 0b10 || (b3 >> 6) != 0b10 || (b4 >> 6) != 0b10) {
                throw new IllegalArgumentException("Invalid UTF-8 encoding");
            }
            int cp = ((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
            // Convert to surrogate pair for characters outside BMP
            sb.append(Character.highSurrogate(cp));
            sb.append(Character.lowSurrogate(cp));
            return i + 4;
        }
        
        throw new IllegalArgumentException("Invalid UTF-8 encoding");
    }
}