import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    // Ensure the buffer has enough remaining bytes
    if (bb.remaining() < 1) {
        return i;
    }

    // Get the first byte
    byte b1 = bb.get(i);
    if ((b1 & 0x80) == 0) {
        // 1-byte sequence (0xxxxxxx)
        sb.append((char) b1);
        return i + 1;
    } else if ((b1 & 0xE0) == 0xC0) {
        // 2-byte sequence (110xxxxx 10xxxxxx)
        if (bb.remaining() < 2) {
            return i;
        }
        byte b2 = bb.get(i + 1);
        if ((b2 & 0xC0) != 0x80) {
            return i;
        }
        int codePoint = ((b1 & 0x1F) << 6) | (b2 & 0x3F);
        sb.append((char) codePoint);
        return i + 2;
    } else if ((b1 & 0xF0) == 0xE0) {
        // 3-byte sequence (1110xxxx 10xxxxxx 10xxxxxx)
        if (bb.remaining() < 3) {
            return i;
        }
        byte b2 = bb.get(i + 1);
        byte b3 = bb.get(i + 2);
        if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80) {
            return i;
        }
        int codePoint = ((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
        sb.append((char) codePoint);
        return i + 3;
    } else if ((b1 & 0xF8) == 0xF0) {
        // 4-byte sequence (11110xxx 10xxxxxx 10xxxxxx 10xxxxxx)
        if (bb.remaining() < 4) {
            return i;
        }
        byte b2 = bb.get(i + 1);
        byte b3 = bb.get(i + 2);
        byte b4 = bb.get(i + 3);
        if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80 || (b4 & 0xC0) != 0x80) {
            return i;
        }
        int codePoint = ((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
        sb.append(Character.toChars(codePoint));
        return i + 4;
    } else {
        // Invalid UTF-8 sequence
        return i;
    }
}