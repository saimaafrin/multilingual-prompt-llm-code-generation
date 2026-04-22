import java.nio.ByteBuffer;

public class OctetDecoder {

    /** 
     * Decodes octets to characters using the UTF-8 decoding and appends the characters to a StringBuffer.
     * @return the index to the next unchecked character in the string to decode
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        while (i < bb.limit()) {
            int b = bb.get(i) & 0xFF; // Get the byte as an unsigned value
            if (b >= 0 && b <= 0x7F) {
                // 1-byte character (ASCII)
                sb.append((char) b);
                i++;
            } else if (b >= 0xC0 && b <= 0xDF) {
                // 2-byte character
                if (i + 1 >= bb.limit()) break; // Check for enough bytes
                int b2 = bb.get(i + 1) & 0xFF;
                sb.append((char) (((b & 0x1F) << 6) | (b2 & 0x3F)));
                i += 2;
            } else if (b >= 0xE0 && b <= 0xEF) {
                // 3-byte character
                if (i + 2 >= bb.limit()) break; // Check for enough bytes
                int b2 = bb.get(i + 1) & 0xFF;
                int b3 = bb.get(i + 2) & 0xFF;
                sb.append((char) (((b & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F)));
                i += 3;
            } else if (b >= 0xF0 && b <= 0xF7) {
                // 4-byte character
                if (i + 3 >= bb.limit()) break; // Check for enough bytes
                int b2 = bb.get(i + 1) & 0xFF;
                int b3 = bb.get(i + 2) & 0xFF;
                int b4 = bb.get(i + 3) & 0xFF;
                int codePoint = ((b & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
                // Convert code point to characters
                if (codePoint <= 0xFFFF) {
                    sb.append((char) codePoint);
                } else {
                    codePoint -= 0x10000;
                    sb.append((char) ((codePoint >> 10) + 0xD800));
                    sb.append((char) ((codePoint & 0x3FF) + 0xDC00));
                }
                i += 4;
            } else {
                // Invalid byte, skip it
                i++;
            }
        }
        return i;
    }
}