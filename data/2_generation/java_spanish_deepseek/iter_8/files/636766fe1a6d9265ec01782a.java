import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Asumimos que classFileBuffer es un ByteBuffer que contiene el archivo de clase.
    // Este método es un ejemplo y no incluye la lógica completa para leer el archivo de clase.
    // Debes implementar la lógica para obtener el ByteBuffer correcto.

    // Obtener el offset de la entrada en la tabla de constantes
    int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);

    // Leer la longitud de la cadena UTF-8
    int length = classFileBuffer.getShort(offset) & 0xFFFF;

    // Leer los bytes de la cadena UTF-8
    byte[] utf8Bytes = new byte[length];
    classFileBuffer.position(offset + 2);
    classFileBuffer.get(utf8Bytes);

    // Convertir los bytes UTF-8 a una cadena Java
    String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);

    // Copiar la cadena al búfer de caracteres
    utf8String.getChars(0, utf8String.length(), charBuffer, 0);

    return utf8String;
}

// Método de ejemplo para obtener el offset de una entrada en la tabla de constantes
private int getConstantPoolEntryOffset(int constantPoolEntryIndex) {
    // Implementa la lógica para obtener el offset de la entrada en la tabla de constantes
    // Esto es un ejemplo y debe ser adaptado a tu implementación específica.
    return constantPoolEntryIndex * 8; // Ejemplo simplificado
}

// Ejemplo de ByteBuffer que contiene el archivo de clase
private ByteBuffer classFileBuffer = ByteBuffer.allocate(1024); // Ejemplo simplificado