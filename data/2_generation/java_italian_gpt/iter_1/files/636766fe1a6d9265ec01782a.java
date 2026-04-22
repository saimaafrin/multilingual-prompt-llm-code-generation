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
        // Assuming the classFileBuffer is structured correctly and contains the necessary data
        int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);
        int length = (classFileBuffer[offset + 1] << 8) | (classFileBuffer[offset + 2] & 0xFF);
        
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) classFileBuffer[offset + 3 + i];
        }
        
        return new String(charBuffer, 0, length);
    }

    private int getConstantPoolEntryOffset(int index) {
        // This method should return the offset of the constant pool entry based on the index
        // For simplicity, let's assume each entry is of fixed size (this is not true in real class files)
        return index * 10; // Placeholder for actual offset calculation
    }
}