public class UtfReader {
    private final byte[] classFileBuffer;

    public UtfReader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * Lee una entrada CONSTANT_Utf8 de un grupo de constantes en {@link #classFileBuffer}.
     * @param constantPoolEntryIndex el índice de una entrada CONSTANT_Utf8 en la tabla de constantes de la clase.
     * @param charBuffer el búfer que se utilizará para leer la cadena. Este búfer debe ser lo suficientemente grande. No se redimensiona automáticamente.
     * @return la cadena correspondiente a la entrada CONSTANT_Utf8 especificada.
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        int offset = getConstantPoolOffset(constantPoolEntryIndex);
        int length = (classFileBuffer[offset] << 8) + (classFileBuffer[offset + 1] & 0xFF);
        offset += 2;

        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) ((classFileBuffer[offset] << 8) + (classFileBuffer[offset + 1] & 0xFF));
            offset += 2;
        }

        return new String(charBuffer, 0, length);
    }

    private int getConstantPoolOffset(int index) {
        // This method should return the correct offset for the given constant pool index.
        // The implementation of this method depends on the structure of the class file.
        // For simplicity, let's assume it returns a fixed offset for demonstration purposes.
        return index * 2; // Placeholder implementation
    }
}