import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class OctetDecoder {

    /** 
     * Decodifica gli ottetti in caratteri utilizzando la decodifica UTF-8 e aggiunge i caratteri ad uno oggetto StringBuffer.
     * @return l'indice del prossimo carattere non controllato nella stringa da decodificare
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        while (bb.hasRemaining()) {
            int byteValue = bb.get() & 0xFF; // Get the next byte and convert to unsigned
            if (byteValue >= 0x80) { // Check if it's a multi-byte character
                // Handle UTF-8 multi-byte sequences
                if ((byteValue & 0xE0) == 0xC0) { // 2-byte sequence
                    if (bb.remaining() < 1) break; // Not enough bytes
                    int nextByte = bb.get() & 0xFF;
                    sb.append((char) (((byteValue & 0x1F) << 6) | (nextByte & 0x3F)));
                } else if ((byteValue & 0xF0) == 0xE0) { // 3-byte sequence
                    if (bb.remaining() < 2) break; // Not enough bytes
                    int nextByte1 = bb.get() & 0xFF;
                    int nextByte2 = bb.get() & 0xFF;
                    sb.append((char) (((byteValue & 0x0F) << 12) | ((nextByte1 & 0x3F) << 6) | (nextByte2 & 0x3F)));
                } else if ((byteValue & 0xF8) == 0xF0) { // 4-byte sequence
                    if (bb.remaining() < 3) break; // Not enough bytes
                    int nextByte1 = bb.get() & 0xFF;
                    int nextByte2 = bb.get() & 0xFF;
                    int nextByte3 = bb.get() & 0xFF;
                    int codePoint = ((byteValue & 0x07) << 18) | ((nextByte1 & 0x3F) << 12) | ((nextByte2 & 0x3F) << 6) | (nextByte3 & 0x3F);
                    // Convert code point to characters
                    if (codePoint <= 0xFFFF) {
                        sb.append((char) codePoint);
                    } else {
                        codePoint -= 0x10000;
                        sb.append((char) (0xD800 | (codePoint >> 10)));
                        sb.append((char) (0xDC00 | (codePoint & 0x3FF)));
                    }
                } else {
                    // Invalid UTF-8 byte sequence
                    break;
                }
            } else {
                // Single-byte character (ASCII)
                sb.append((char) byteValue);
            }
            i++;
        }
        return i;
    }
}