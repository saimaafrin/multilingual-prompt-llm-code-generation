import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class OctetDecoder {

    /** 
     * Decodes octets to characters using the UTF-8 decoding and appends the characters to a StringBuffer.
     * @return the index to the next unchecked character in the string to decode
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        while (i < bb.limit()) {
            // Read the next byte
            byte b = bb.get(i);
            // Check if the byte is a valid UTF-8 continuation byte
            if ((b & 0x80) == 0) {
                // Single byte character (ASCII)
                sb.append((char) b);
                i++;
            } else if ((b & 0xE0) == 0xC0) {
                // Two byte character
                if (i + 1 < bb.limit()) {
                    int charCode = ((b & 0x1F) << 6) | (bb.get(i + 1) & 0x3F);
                    sb.append((char) charCode);
                    i += 2;
                } else {
                    break; // Incomplete byte sequence
                }
            } else if ((b & 0xF0) == 0xE0) {
                // Three byte character
                if (i + 2 < bb.limit()) {
                    int charCode = ((b & 0x0F) << 12) | ((bb.get(i + 1) & 0x3F) << 6) | (bb.get(i + 2) & 0x3F);
                    sb.append((char) charCode);
                    i += 3;
                } else {
                    break; // Incomplete byte sequence
                }
            } else if ((b & 0xF8) == 0xF0) {
                // Four byte character
                if (i + 3 < bb.limit()) {
                    int charCode = ((b & 0x07) << 18) | ((bb.get(i + 1) & 0x3F) << 12) | ((bb.get(i + 2) & 0x3F) << 6) | (bb.get(i + 3) & 0x3F);
                    sb.append(Character.toChars(charCode));
                    i += 4;
                } else {
                    break; // Incomplete byte sequence
                }
            } else {
                // Invalid byte, skip it
                i++;
            }
        }
        return i;
    }
}