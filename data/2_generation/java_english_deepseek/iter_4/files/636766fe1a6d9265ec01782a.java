import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final class ClassFileReader {
    private final ByteBuffer classFileBuffer;

    public ClassFileReader(ByteBuffer classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * Reads a CONSTANT_Utf8 constant pool entry in {@link #classFileBuffer}.
     * @param constantPoolEntryIndex the index of a CONSTANT_Utf8 entry in the class's constant pool table.
     * @param charBuffer the buffer to be used to read the string. This buffer must be sufficiently large. It is not automatically resized.
     * @return the String corresponding to the specified CONSTANT_Utf8 entry.
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the constant pool entry is structured as follows:
        // 1 byte for tag (CONSTANT_Utf8)
        // 2 bytes for length
        // N bytes for the UTF-8 encoded string

        // Move to the position of the constant pool entry
        classFileBuffer.position(constantPoolEntryIndex);

        // Read the tag (should be 1 for CONSTANT_Utf8)
        byte tag = classFileBuffer.get();
        if (tag != 1) {
            throw new IllegalArgumentException("Invalid CONSTANT_Utf8 tag: " + tag);
        }

        // Read the length of the UTF-8 string
        int length = classFileBuffer.getShort() & 0xFFFF;

        // Read the UTF-8 bytes into a byte array
        byte[] utf8Bytes = new byte[length];
        classFileBuffer.get(utf8Bytes);

        // Decode the UTF-8 bytes into a String using the provided charBuffer
        return new String(utf8Bytes, StandardCharsets.UTF_8);
    }
}