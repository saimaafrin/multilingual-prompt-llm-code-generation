import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    int b1 = bb.get(i) & 0xFF;
    if (b1 < 0x80) {
        // 1-byte sequence
        sb.append((char) b1);
        return i + 1;
    } else if ((b1 & 0xE0) == 0xC0) {
        // 2-byte sequence
        if (i + 1 >= bb.limit()) {
            throw new IllegalArgumentException("Invalid UTF-8 sequence: incomplete 2-byte sequence");
        }
        int b2 = bb.get(i + 1) & 0xFF;
        if ((b2 & 0xC0) != 0x80) {
            throw new IllegalArgumentException("Invalid UTF-8 sequence: invalid continuation byte");
        }
        int codePoint = ((b1 & 0x1F) << 6) | (b2 & 0x3F);
        sb.append((char) codePoint);
        return i + 2;
    } else if ((b1 & 0xF0) == 0xE0) {
        // 3-byte sequence
        if (i + 2 >= bb.limit()) {
            throw new IllegalArgumentException("Invalid UTF-8 sequence: incomplete 3-byte sequence");
        }
        int b2 = bb.get(i + 1) & 0xFF;
        int b3 = bb.get(i + 2) & 0xFF;
        if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80) {
            throw new IllegalArgumentException("Invalid UTF-8 sequence: invalid continuation bytes");
        }
        int codePoint = ((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
        sb.append((char) codePoint);
        return i + 3;
    } else if ((b1 & 0xF8) == 0xF0) {
        // 4-byte sequence
        if (i + 3 >= bb.limit()) {
            throw new IllegalArgumentException("Invalid UTF-8 sequence: incomplete 4-byte sequence");
        }
        int b2 = bb.get(i + 1) & 0xFF;
        int b3 = bb.get(i + 2) & 0xFF;
        int b4 = bb.get(i + 3) & 0xFF;
        if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80 || (b4 & 0xC0) != 0x80) {
            throw new IllegalArgumentException("Invalid UTF-8 sequence: invalid continuation bytes");
        }
        int codePoint = ((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
        sb.append(Character.toChars(codePoint));
        return i + 4;
    } else {
        throw new IllegalArgumentException("Invalid UTF-8 sequence: invalid start byte");
    }
}