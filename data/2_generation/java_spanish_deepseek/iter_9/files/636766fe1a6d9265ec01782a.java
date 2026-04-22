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
        // La entrada CONSTANT_Utf8 tiene un formato específico en el class file.
        // El primer byte es el tag (1 para CONSTANT_Utf8), seguido de 2 bytes que indican la longitud de la cadena.
        // Luego sigue la cadena en formato UTF-8.

        // Posicionamos el buffer en la entrada correspondiente.
        classFileBuffer.position(constantPoolEntryIndex);

        // Leemos el tag (debería ser 1 para CONSTANT_Utf8).
        byte tag = classFileBuffer.get();
        if (tag != 1) {
            throw new IllegalArgumentException("Invalid CONSTANT_Utf8 tag: " + tag);
        }

        // Leemos la longitud de la cadena (2 bytes).
        int length = classFileBuffer.getShort() & 0xFFFF;

        // Leemos los bytes de la cadena UTF-8.
        byte[] utf8Bytes = new byte[length];
        classFileBuffer.get(utf8Bytes);

        // Convertimos los bytes UTF-8 a una cadena Java.
        String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);

        // Copiamos la cadena al charBuffer proporcionado.
        utf8String.getChars(0, utf8String.length(), charBuffer, 0);

        return utf8String;
    }
}