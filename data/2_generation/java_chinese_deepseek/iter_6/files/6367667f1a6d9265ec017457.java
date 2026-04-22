import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    byte[] bytes = new byte[bb.remaining()];
    bb.get(bytes);
    String decodedString = new String(bytes, i, bytes.length - i, StandardCharsets.UTF_8);
    sb.append(decodedString);
    return i + decodedString.length();
}