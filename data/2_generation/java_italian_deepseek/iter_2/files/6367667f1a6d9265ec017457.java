import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    byte firstByte = bb.get(i);
    int codePoint;
    int bytesToRead;

    if ((firstByte & 0x80) == 0) {
        // 1-byte sequence (0xxxxxxx)
        codePoint = firstByte & 0x7F;
        bytesToRead = 0;
    } else if ((firstByte & 0xE0) == 0xC0) {
        // 2-byte sequence (110xxxxx 10xxxxxx)
        codePoint = firstByte & 0x1F;
        bytesToRead = 1;
    } else if ((firstByte & 0xF0) == 0xE0) {
        // 3-byte sequence (1110xxxx 10xxxxxx 10xxxxxx)
        codePoint = firstByte & 0x0F;
        bytesToRead = 2;
    } else if ((firstByte & 0xF8) == 0xF0) {
        // 4-byte sequence (11110xxx 10xxxxxx 10xxxxxx 10xxxxxx)
        codePoint = firstByte & 0x07;
        bytesToRead = 3;
    } else {
        // Invalid UTF-8 sequence
        throw new IllegalArgumentException("Invalid UTF-8 sequence");
    }

    for (int j = 1; j <= bytesToRead; j++) {
        byte nextByte = bb.get(i + j);
        if ((nextByte & 0xC0) != 0x80) {
            throw new IllegalArgumentException("Invalid UTF-8 sequence");
        }
        codePoint = (codePoint << 6) | (nextByte & 0x3F);
    }

    sb.append(Character.toChars(codePoint));
    return i + bytesToRead + 1;
}