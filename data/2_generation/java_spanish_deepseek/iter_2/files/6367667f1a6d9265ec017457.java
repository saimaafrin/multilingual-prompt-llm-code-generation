import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    // Obtener el byte actual
    byte b = bb.get(i);
    
    // Determinar el número de bytes que componen el carácter UTF-8
    int numBytes;
    if ((b & 0x80) == 0) {
        // 1 byte: 0xxxxxxx
        numBytes = 1;
    } else if ((b & 0xE0) == 0xC0) {
        // 2 bytes: 110xxxxx
        numBytes = 2;
    } else if ((b & 0xF0) == 0xE0) {
        // 3 bytes: 1110xxxx
        numBytes = 3;
    } else if ((b & 0xF8) == 0xF0) {
        // 4 bytes: 11110xxx
        numBytes = 4;
    } else {
        // Secuencia inválida
        throw new IllegalArgumentException("Invalid UTF-8 sequence");
    }

    // Verificar que hay suficientes bytes restantes en el buffer
    if (i + numBytes > bb.limit()) {
        throw new IllegalArgumentException("Incomplete UTF-8 sequence");
    }

    // Crear un array para almacenar los bytes del carácter
    byte[] charBytes = new byte[numBytes];
    for (int j = 0; j < numBytes; j++) {
        charBytes[j] = bb.get(i + j);
    }

    // Decodificar los bytes a un String y agregarlo al StringBuilder
    String decodedChar = new String(charBytes, StandardCharsets.UTF_8);
    sb.append(decodedChar);

    // Retornar el índice del siguiente carácter no verificado
    return i + numBytes;
}