public class ConstantPoolReader {
    private byte[] classFileBuffer;

    public ConstantPoolReader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * Legge un'entrata della pool di costanti CONSTANT_Utf8 in {@link #classFileBuffer}.
     * @param constantPoolEntryIndex l'indice di un'entrata CONSTANT_Utf8 nella tabella delle costanti della classe.
     * @param charBuffer il buffer da utilizzare per leggere la stringa. Questo buffer deve essere sufficientemente grande. Non viene ridimensionato automaticamente.
     * @return la String corrispondente all'entrata CONSTANT_Utf8 specificata.
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Read the length of the UTF-8 string
        int length = ((classFileBuffer[constantPoolEntryIndex] & 0xFF) << 8) | (classFileBuffer[constantPoolEntryIndex + 1] & 0xFF);
        
        // Read the UTF-8 bytes
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) (classFileBuffer[constantPoolEntryIndex + 2 + i] & 0xFF);
        }
        
        return new String(charBuffer, 0, length);
    }
}