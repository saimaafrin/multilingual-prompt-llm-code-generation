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
        // Asumimos que el índice es válido y que el búfer es lo suficientemente grande.
        // La entrada CONSTANT_Utf8 comienza con un byte que indica el tipo de entrada (1 para CONSTANT_Utf8).
        // Luego sigue un short que indica la longitud de la cadena UTF-8.
        int position = constantPoolEntryIndex;
        byte tag = classFileBuffer.get(position);
        if (tag != 1) {
            throw new IllegalArgumentException("La entrada no es de tipo CONSTANT_Utf8.");
        }
        position += 1;
        int length = classFileBuffer.getShort(position) & 0xFFFF; // Convertir a unsigned short
        position += 2;

        // Leer los bytes de la cadena UTF-8
        byte[] utf8Bytes = new byte[length];
        classFileBuffer.position(position);
        classFileBuffer.get(utf8Bytes, 0, length);

        // Convertir los bytes UTF-8 a una cadena Java
        String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);

        // Copiar la cadena al búfer de caracteres proporcionado
        utf8String.getChars(0, utf8String.length(), charBuffer, 0);

        return utf8String;
    }
}