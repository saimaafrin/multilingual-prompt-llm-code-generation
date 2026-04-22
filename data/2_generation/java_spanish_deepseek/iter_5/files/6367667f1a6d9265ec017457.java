import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    // Obtener el primer byte
    byte b1 = bb.get(i);
    
    // Determinar el número de bytes en el carácter UTF-8
    int byteCount;
    if ((b1 & 0x80) == 0) {
        // 1 byte
        byteCount = 1;
    } else if ((b1 & 0xE0) == 0xC0) {
        // 2 bytes
        byteCount = 2;
    } else if ((b1 & 0xF0) == 0xE0) {
        // 3 bytes
        byteCount = 3;
    } else if ((b1 & 0xF8) == 0xF0) {
        // 4 bytes
        byteCount = 4;
    } else {
        // Carácter inválido
        throw new IllegalArgumentException("Invalid UTF-8 sequence");
    }
    
    // Verificar que hay suficientes bytes en el buffer
    if (i + byteCount > bb.limit()) {
        throw new IllegalArgumentException("Incomplete UTF-8 sequence");
    }
    
    // Crear un array para almacenar los bytes del carácter
    byte[] bytes = new byte[byteCount];
    for (int j = 0; j < byteCount; j++) {
        bytes[j] = bb.get(i + j);
    }
    
    // Decodificar los bytes a un String
    String decodedChar = new String(bytes, StandardCharsets.UTF_8);
    
    // Agregar el carácter decodificado al StringBuilder
    sb.append(decodedChar);
    
    // Retornar el índice del siguiente carácter no verificado
    return i + byteCount;
}