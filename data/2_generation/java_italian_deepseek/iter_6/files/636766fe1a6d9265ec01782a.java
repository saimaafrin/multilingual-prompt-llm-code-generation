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
        // Assuming the constant pool entry is a CONSTANT_Utf8_info structure
        // CONSTANT_Utf8_info structure format:
        // u1 tag (1 byte)
        // u2 length (2 bytes)
        // u1 bytes[length] (variable length)

        // Move to the start of the constant pool entry
        classFileBuffer.position(constantPoolEntryIndex);

        // Read the tag (should be 1 for CONSTANT_Utf8)
        byte tag = classFileBuffer.get();
        if (tag != 1) {
            throw new IllegalArgumentException("Invalid CONSTANT_Utf8 tag");
        }

        // Read the length of the UTF-8 string
        int length = classFileBuffer.getShort() & 0xFFFF;

        // Read the UTF-8 bytes
        byte[] utf8Bytes = new byte[length];
        classFileBuffer.get(utf8Bytes);

        // Convert UTF-8 bytes to a Java String
        String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);

        // Copy the characters to the provided charBuffer
        utf8String.getChars(0, utf8String.length(), charBuffer, 0);

        return utf8String;
    }
}