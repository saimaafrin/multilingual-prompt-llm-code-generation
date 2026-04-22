import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    int length = bb.remaining();
    if (i >= length) {
        return i;
    }

    byte[] octets = new byte[length - i];
    bb.get(octets, 0, length - i);

    String decodedString = new String(octets, StandardCharsets.UTF_8);
    sb.append(decodedString);

    return length;
}