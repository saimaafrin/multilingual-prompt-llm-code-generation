import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class OctetDecoder {

    /** 
     * Decodifica gli ottetti in caratteri utilizzando la decodifica UTF-8 e aggiunge i caratteri ad uno oggetto StringBuffer.
     * @return l'indice del prossimo carattere non controllato nella stringa da decodificare
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        while (bb.hasRemaining()) {
            int byteValue = bb.get() & 0xFF; // Read the next byte
            if (byteValue >= 0x80) { // If it's a multi-byte character
                // Handle UTF-8 decoding
                byte[] utf8Bytes = new byte[4]; // Max 4 bytes for UTF-8
                utf8Bytes[0] = (byte) byteValue;
                int byteCount = 1;

                if ((byteValue & 0xE0) == 0xC0) {
                    byteCount = 2; // 110xxxxx
                } else if ((byteValue & 0xF0) == 0xE0) {
                    byteCount = 3; // 1110xxxx
                } else if ((byteValue & 0xF8) == 0xF0) {
                    byteCount = 4; // 11110xxx
                }

                for (int j = 1; j < byteCount; j++) {
                    if (!bb.hasRemaining()) {
                        return i; // Not enough bytes for a complete character
                    }
                    utf8Bytes[j] = bb.get();
                }

                // Decode the UTF-8 bytes to a character
                String decodedChar = new String(utf8Bytes, 0, byteCount, StandardCharsets.UTF_8);
                sb.append(decodedChar);
            } else {
                // Single byte character
                sb.append((char) byteValue);
            }
            i++;
        }
        return i;
    }
}