import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UTF8Decoder {

    /**
     * Decodifica octetos a caracteres utilizando la decodificación UTF-8 y agrega los caracteres a un StringBuilder.
     * @param i el índice actual en el ByteBuffer
     * @param bb el ByteBuffer que contiene los octetos a decodificar
     * @param sb el StringBuilder donde se agregarán los caracteres decodificados
     * @return el índice del siguiente carácter no verificado en la cadena para decodificar
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        // Verifica si hay suficientes bytes para decodificar
        if (bb.remaining() < 1) {
            return i;
        }

        // Lee el primer byte
        byte b1 = bb.get(i);
        int codePoint;

        // Determina el número de bytes en el carácter UTF-8
        if ((b1 & 0x80) == 0) {
            // 1 byte: 0xxxxxxx
            codePoint = b1 & 0x7F;
            i += 1;
        } else if ((b1 & 0xE0) == 0xC0) {
            // 2 bytes: 110xxxxx 10xxxxxx
            if (bb.remaining() < 2) {
                return i;
            }
            byte b2 = bb.get(i + 1);
            codePoint = ((b1 & 0x1F) << 6) | (b2 & 0x3F);
            i += 2;
        } else if ((b1 & 0xF0) == 0xE0) {
            // 3 bytes: 1110xxxx 10xxxxxx 10xxxxxx
            if (bb.remaining() < 3) {
                return i;
            }
            byte b2 = bb.get(i + 1);
            byte b3 = bb.get(i + 2);
            codePoint = ((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
            i += 3;
        } else if ((b1 & 0xF8) == 0xF0) {
            // 4 bytes: 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
            if (bb.remaining() < 4) {
                return i;
            }
            byte b2 = bb.get(i + 1);
            byte b3 = bb.get(i + 2);
            byte b4 = bb.get(i + 3);
            codePoint = ((b1 & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
            i += 4;
        } else {
            // Carácter inválido
            return i;
        }

        // Agrega el carácter decodificado al StringBuilder
        sb.appendCodePoint(codePoint);

        return i;
    }

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{(byte) 0xC3, (byte) 0xA9}); // 'é' en UTF-8
        StringBuilder sb = new StringBuilder();
        int nextIndex = decodeOctets(0, bb, sb);
        System.out.println("Decoded String: " + sb.toString());
        System.out.println("Next Index: " + nextIndex);
    }
}