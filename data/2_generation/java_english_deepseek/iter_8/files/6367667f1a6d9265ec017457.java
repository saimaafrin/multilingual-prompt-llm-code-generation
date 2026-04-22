import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    // Ensure the buffer has enough remaining bytes
    if (bb.remaining() < 1) {
        return i;
    }

    // Get the first byte
    byte b1 = bb.get();
    int codePoint;

    // Determine the number of bytes in the UTF-8 sequence
    if ((b1 & 0x80) == 0) {
        // 1-byte sequence (0xxxxxxx)
        codePoint = b1 & 0x7F;
    } else if ((b1 & 0xE0) == 0xC0) {
        // 2-byte sequence (110xxxxx 10xxxxxx)
        if (bb.remaining() < 1) {
            return i;
        }
        byte b2 = bb.get();
        codePoint = ((b1 & 0x1F) << 6) | (b2 & 0x3F);
    } else if ((b1 & 0xF0) == 0xE0) {
        // 3-byte sequence (1110xxxx 10xxxxxx 10xxxxxx)
        if (bb.remaining() < 2) {
            return i;
        }
        byte b2 = bb.get();
        byte b3 = bb.get();
        codePoint = ((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
    } else if ((b1 & 0xF8) == 0xF0) {
        // 4-byte sequence (11110xxx 10xxxxxx 10xxxxxx 10xxxxxx)
        if (bb.remaining() < 3) {
            return i;
        }
        byte b2 = bb.get();
        byte b3 = bb.get();
        byte b4 = bb.get();
        codePoint = ((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
    } else {
        // Invalid UTF-8 sequence
        return i;
    }

    // Append the decoded character to the StringBuilder
    sb.appendCodePoint(codePoint);

    // Return the next index to check
    return i + 1;
}