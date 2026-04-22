import java.nio.ByteBuffer;

public class UTF8Decoder {

    /**
     * Decodifica gli ottetti in caratteri utilizzando la decodifica UTF-8 e aggiunge i caratteri ad uno oggetto StringBuffer.
     * @return l'indice del prossimo carattere non controllato nella stringa da decodificare
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        int b1 = bb.get(i) & 0xFF;
        
        // Single byte character (0-127)
        if ((b1 & 0x80) == 0) {
            sb.append((char)b1);
            return i + 1;
        }
        
        // 2 byte character (128-2047)
        if ((b1 & 0xE0) == 0xC0) {
            int b2 = bb.get(i + 1) & 0xFF;
            int cp = ((b1 & 0x1F) << 6) | (b2 & 0x3F);
            sb.append((char)cp);
            return i + 2;
        }
        
        // 3 byte character (2048-65535)
        if ((b1 & 0xF0) == 0xE0) {
            int b2 = bb.get(i + 1) & 0xFF;
            int b3 = bb.get(i + 2) & 0xFF;
            int cp = ((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
            sb.append((char)cp);
            return i + 3;
        }
        
        // 4 byte character (65536-1114111)
        if ((b1 & 0xF8) == 0xF0) {
            int b2 = bb.get(i + 1) & 0xFF;
            int b3 = bb.get(i + 2) & 0xFF;
            int b4 = bb.get(i + 3) & 0xFF;
            int cp = ((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
            // Convert to surrogate pair for characters above U+FFFF
            sb.append(Character.highSurrogate(cp));
            sb.append(Character.lowSurrogate(cp));
            return i + 4;
        }
        
        // Invalid UTF-8 byte
        sb.append('?');
        return i + 1;
    }
}