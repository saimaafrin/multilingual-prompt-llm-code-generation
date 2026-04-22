import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    int length = bb.remaining();
    if (i >= length) {
        return i;
    }

    byte firstByte = bb.get(i);
    int codePoint;
    int bytesToRead;

    if ((firstByte & 0x80) == 0) { // 1-byte sequence
        codePoint = firstByte & 0x7F;
        bytesToRead = 1;
    } else if ((firstByte & 0xE0) == 0xC0) { // 2-byte sequence
        codePoint = firstByte & 0x1F;
        bytesToRead = 2;
    } else if ((firstByte & 0xF0) == 0xE0) { // 3-byte sequence
        codePoint = firstByte & 0x0F;
        bytesToRead = 3;
    } else if ((firstByte & 0xF8) == 0xF0) { // 4-byte sequence
        codePoint = firstByte & 0x07;
        bytesToRead = 4;
    } else {
        throw new IllegalArgumentException("Invalid UTF-8 sequence");
    }

    if (i + bytesToRead > length) {
        throw new IllegalArgumentException("Incomplete UTF-8 sequence");
    }

    for (int j = 1; j < bytesToRead; j++) {
        byte nextByte = bb.get(i + j);
        if ((nextByte & 0xC0) != 0x80) {
            throw new IllegalArgumentException("Invalid UTF-8 sequence");
        }
        codePoint = (codePoint << 6) | (nextByte & 0x3F);
    }

    sb.append(Character.toChars(codePoint));
    return i + bytesToRead;
}