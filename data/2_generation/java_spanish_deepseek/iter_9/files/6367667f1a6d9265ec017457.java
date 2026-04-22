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
        throw new IllegalArgumentException("Invalid UTF-8 sequence");
    }
    
    // Verificar que hay suficientes bytes en el buffer
    if (i + numBytes > bb.limit()) {
        throw new IllegalArgumentException("Incomplete UTF-8 sequence");
    }
    
    // Crear un array para almacenar los bytes del carácter
    byte[] bytes = new byte[numBytes];
    for (int j = 0; j < numBytes; j++) {
        bytes[j] = bb.get(i + j);
    }
    
    // Decodificar los bytes a un carácter UTF-8
    String str = new String(bytes, StandardCharsets.UTF_8);
    
    // Agregar el carácter al StringBuilder
    sb.append(str);
    
    // Retornar el índice del siguiente carácter no verificado
    return i + numBytes;
}