import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    // Get the current byte at position i
    byte b1 = bb.get(i);
    
    // Check if the byte is a single-byte character (0xxxxxxx)
    if ((b1 & 0x80) == 0) {
        sb.append((char) b1);
        return i + 1;
    }
    
    // Check if the byte is a two-byte character (110xxxxx)
    if ((b1 & 0xE0) == 0xC0) {
        byte b2 = bb.get(i + 1);
        if ((b2 & 0xC0) == 0x80) {
            int codePoint = ((b1 & 0x1F) << 6) | (b2 & 0x3F);
            sb.append((char) codePoint);
            return i + 2;
        }
    }
    
    // Check if the byte is a three-byte character (1110xxxx)
    if ((b1 & 0xF0) == 0xE0) {
        byte b2 = bb.get(i + 1);
        byte b3 = bb.get(i + 2);
        if ((b2 & 0xC0) == 0x80 && (b3 & 0xC0) == 0x80) {
            int codePoint = ((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
            sb.append((char) codePoint);
            return i + 3;
        }
    }
    
    // Check if the byte is a four-byte character (11110xxx)
    if ((b1 & 0xF8) == 0xF0) {
        byte b2 = bb.get(i + 1);
        byte b3 = bb.get(i + 2);
        byte b4 = bb.get(i + 3);
        if ((b2 & 0xC0) == 0x80 && (b3 & 0xC0) == 0x80 && (b4 & 0xC0) == 0x80) {
            int codePoint = ((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
            sb.append(Character.toChars(codePoint));
            return i + 4;
        }
    }
    
    // If the byte sequence is invalid, append the replacement character and move to the next byte
    sb.append('\uFFFD');
    return i + 1;
}