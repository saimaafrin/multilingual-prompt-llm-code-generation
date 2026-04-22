import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final class ClassFileReader {
    private final ByteBuffer classFileBuffer;

    public ClassFileReader(ByteBuffer classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * Lee una entrada CONSTANT_Utf8 de un grupo de constantes en {@link #classFileBuffer}.
     * @param constantPoolEntryIndex el índice de una entrada CONSTANT_Utf8 en la tabla de constantes de la clase.
     * @param charBuffer el búfer que se utilizará para leer la cadena. Este búfer debe ser lo suficientemente grande. No se redimensiona automáticamente.
     * @return la cadena correspondiente a la entrada CONSTANT_Utf8 especificada.
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Obtener la posición de la entrada CONSTANT_Utf8 en el buffer
        int utf8EntryPosition = getUtf8EntryPosition(constantPoolEntryIndex);
        
        // Leer la longitud de la cadena UTF-8
        int length = classFileBuffer.getShort(utf8EntryPosition) & 0xFFFF;
        
        // Leer los bytes de la cadena UTF-8
        byte[] utf8Bytes = new byte[length];
        classFileBuffer.position(utf8EntryPosition + 2);
        classFileBuffer.get(utf8Bytes, 0, length);
        
        // Convertir los bytes UTF-8 a una cadena de caracteres
        String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);
        
        // Copiar la cadena al charBuffer
        utf8String.getChars(0, utf8String.length(), charBuffer, 0);
        
        return utf8String;
    }

    private int getUtf8EntryPosition(int constantPoolEntryIndex) {
        // Implementación ficticia para obtener la posición de la entrada CONSTANT_Utf8
        // En una implementación real, esto dependería de la estructura del archivo de clase.
        return constantPoolEntryIndex * 2; // Ejemplo simplificado
    }
}