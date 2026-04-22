import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Asumimos que classFileBuffer es un ByteBuffer que contiene el archivo de clase.
    // Este método es un ejemplo y no incluye la lógica completa para leer el archivo de clase.
    // La implementación real dependerá de cómo se almacene y acceda a classFileBuffer.

    // Obtener la entrada de la tabla de constantes
    int utf8Length = classFileBuffer.getShort(constantPoolEntryIndex) & 0xFFFF; // Longitud de la cadena UTF-8
    byte[] utf8Bytes = new byte[utf8Length];
    classFileBuffer.position(constantPoolEntryIndex + 2); // Saltar el campo de longitud
    classFileBuffer.get(utf8Bytes, 0, utf8Length); // Leer los bytes UTF-8

    // Convertir los bytes UTF-8 a una cadena Java
    String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);

    // Copiar la cadena al búfer de caracteres proporcionado
    utf8String.getChars(0, utf8String.length(), charBuffer, 0);

    return utf8String;
}