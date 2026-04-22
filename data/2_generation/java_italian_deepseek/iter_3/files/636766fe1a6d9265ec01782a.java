import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final class ClassFileReader {
    private final ByteBuffer classFileBuffer;

    public ClassFileReader(ByteBuffer classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * Legge un'entrata della pool di costanti CONSTANT_Utf8 in {@link #classFileBuffer}.
     * @param constantPoolEntryIndex l'indice di un'entrata CONSTANT_Utf8 nella tabella delle costanti della classe.
     * @param charBuffer il buffer da utilizzare per leggere la stringa. Questo buffer deve essere sufficientemente grande. Non viene ridimensionato automaticamente.
     * @return la String corrispondente all'entrata CONSTANT_Utf8 specificata.
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Posiziona il buffer all'inizio dell'entrata specificata
        classFileBuffer.position(constantPoolEntryIndex);

        // Legge la lunghezza della stringa UTF-8
        int length = classFileBuffer.getShort() & 0xFFFF;

        // Legge i byte della stringa UTF-8
        byte[] utf8Bytes = new byte[length];
        classFileBuffer.get(utf8Bytes);

        // Decodifica i byte UTF-8 in una stringa Java
        String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);

        // Copia la stringa nel buffer di caratteri fornito
        utf8String.getChars(0, utf8String.length(), charBuffer, 0);

        return utf8String;
    }
}