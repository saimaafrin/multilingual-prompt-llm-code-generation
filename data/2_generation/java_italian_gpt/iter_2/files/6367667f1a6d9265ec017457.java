import java.nio.ByteBuffer;

public class OctetDecoder {

    /** 
     * Decodifica gli ottetti in caratteri utilizzando la decodifica UTF-8 e aggiunge i caratteri ad uno oggetto StringBuilder.
     * @return l'indice del prossimo carattere non controllato nella stringa da decodificare
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        while (i < bb.limit()) {
            int b = bb.get(i) & 0xFF; // Get the byte and convert to unsigned
            if ((b & 0x80) == 0) { // 1-byte character (ASCII)
                sb.append((char) b);
                i++;
            } else if ((b & 0xE0) == 0xC0) { // 2-byte character
                if (i + 1 >= bb.limit()) break; // Check for enough bytes
                int b2 = bb.get(i + 1) & 0xFF;
                sb.append((char) (((b & 0x1F) << 6) | (b2 & 0x3F)));
                i += 2;
            } else if ((b & 0xF0) == 0xE0) { // 3-byte character
                if (i + 2 >= bb.limit()) break; // Check for enough bytes
                int b2 = bb.get(i + 1) & 0xFF;
                int b3 = bb.get(i + 2) & 0xFF;
                sb.append((char) (((b & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F)));
                i += 3;
            } else if ((b & 0xF8) == 0xF0) { // 4-byte character
                if (i + 3 >= bb.limit()) break; // Check for enough bytes
                int b2 = bb.get(i + 1) & 0xFF;
                int b3 = bb.get(i + 2) & 0xFF;
                int b4 = bb.get(i + 3) & 0xFF;
                int codePoint = (((b & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F)) - 0x10000;
                sb.append((char) (0xD800 + (codePoint >> 10))); // High surrogate
                sb.append((char) (0xDC00 + (codePoint & 0x3FF))); // Low surrogate
                i += 4;
            } else {
                // Invalid byte sequence, break
                break;
            }
        }
        return i; // Return the index of the next unchecked character
    }
}