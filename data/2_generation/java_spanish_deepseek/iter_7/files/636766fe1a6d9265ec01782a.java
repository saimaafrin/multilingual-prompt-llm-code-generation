import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Asumimos que classFileBuffer es un ByteBuffer que contiene el archivo de clase.
    // Este método es un ejemplo y debe ser adaptado según la implementación real de classFileBuffer.
    
    // Obtener la entrada de la tabla de constantes
    int utf8Length = classFileBuffer.getShort(constantPoolEntryIndex) & 0xFFFF;
    byte[] utf8Bytes = new byte[utf8Length];
    classFileBuffer.position(constantPoolEntryIndex + 2); // Saltar el campo de longitud
    classFileBuffer.get(utf8Bytes, 0, utf8Length);
    
    // Convertir los bytes a una cadena UTF-8
    String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);
    
    // Copiar la cadena al búfer de caracteres
    utf8String.getChars(0, utf8String.length(), charBuffer, 0);
    
    return utf8String;
}