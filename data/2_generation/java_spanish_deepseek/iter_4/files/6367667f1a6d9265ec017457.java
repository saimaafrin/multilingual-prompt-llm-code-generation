import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    // Obtener el primer byte
    byte b1 = bb.get(i);
    
    // Determinar el número de bytes en el carácter UTF-8
    int numBytes;
    if ((b1 & 0x80) == 0) {
        // 1 byte
        numBytes = 1;
    } else if ((b1 & 0xE0) == 0xC0) {
        // 2 bytes
        numBytes = 2;
    } else if ((b1 & 0xF0) == 0xE0) {
        // 3 bytes
        numBytes = 3;
    } else if ((b1 & 0xF8) == 0xF0) {
        // 4 bytes
        numBytes = 4;
    } else {
        // Secuencia inválida
        throw new IllegalArgumentException("Secuencia de bytes UTF-8 inválida");
    }

    // Verificar que hay suficientes bytes en el buffer
    if (i + numBytes > bb.limit()) {
        throw new IllegalArgumentException("No hay suficientes bytes para decodificar el carácter UTF-8");
    }

    // Crear un array para almacenar los bytes del carácter
    byte[] charBytes = new byte[numBytes];
    for (int j = 0; j < numBytes; j++) {
        charBytes[j] = bb.get(i + j);
    }

    // Decodificar los bytes a un String
    String decodedChar = new String(charBytes, StandardCharsets.UTF_8);

    // Agregar el carácter decodificado al StringBuilder
    sb.append(decodedChar);

    // Retornar el índice del siguiente carácter no verificado
    return i + numBytes;
}