import java.nio.ByteBuffer;

public class UTF8Decoder {

    /**
     * Decodifica octetos a caracteres utilizando la decodificación UTF-8 y agrega los caracteres a un StringBuffer.
     * @return el índice del siguiente carácter no verificado en la cadena para decodificar
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        int b1 = bb.get(i) & 0xFF;
        
        // Single byte character (ASCII)
        if ((b1 & 0x80) == 0) {
            sb.append((char)b1);
            return i + 1;
        }
        
        // 2 byte character
        if ((b1 & 0xE0) == 0xC0) {
            if (i + 1 >= bb.limit()) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            int b2 = bb.get(i + 1) & 0xFF;
            if ((b2 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            int ch = ((b1 & 0x1F) << 6) | (b2 & 0x3F);
            sb.append((char)ch);
            return i + 2;
        }
        
        // 3 byte character  
        if ((b1 & 0xF0) == 0xE0) {
            if (i + 2 >= bb.limit()) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            int b2 = bb.get(i + 1) & 0xFF;
            int b3 = bb.get(i + 2) & 0xFF;
            if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            int ch = ((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
            sb.append((char)ch);
            return i + 3;
        }
        
        // 4 byte character
        if ((b1 & 0xF8) == 0xF0) {
            if (i + 3 >= bb.limit()) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            int b2 = bb.get(i + 1) & 0xFF;
            int b3 = bb.get(i + 2) & 0xFF;
            int b4 = bb.get(i + 3) & 0xFF;
            if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80 || (b4 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            int ch = ((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
            // Convert to surrogate pair for characters outside BMP
            sb.append(Character.highSurrogate(ch));
            sb.append(Character.lowSurrogate(ch));
            return i + 4;
        }
        
        throw new IllegalArgumentException("Invalid UTF-8 sequence");
    }
}