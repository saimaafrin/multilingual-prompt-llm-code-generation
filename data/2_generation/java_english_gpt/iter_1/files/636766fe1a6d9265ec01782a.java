import java.nio.ByteBuffer;

public class UtfReader {
    private final byte[] classFileBuffer;

    public UtfReader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * Reads a CONSTANT_Utf8 constant pool entry in {@link #classFileBuffer}.
     * @param constantPoolEntryIndex the index of a CONSTANT_Utf8 entry in the class's constant pool table.
     * @param charBuffer the buffer to be used to read the string. This buffer must be sufficiently large. It is not automatically resized.
     * @return the String corresponding to the specified CONSTANT_Utf8 entry.
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the constant pool starts at a certain offset
        int offset = getConstantPoolOffset(constantPoolEntryIndex);
        
        // Read the length of the UTF-8 string
        int length = (classFileBuffer[offset] << 8) + (classFileBuffer[offset + 1] & 0xFF);
        offset += 2;

        // Read the UTF-8 bytes and convert to characters
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) ((classFileBuffer[offset] << 8) + (classFileBuffer[offset + 1] & 0xFF));
            offset += 2;
        }

        return new String(charBuffer, 0, length);
    }

    private int getConstantPoolOffset(int index) {
        // This method should return the correct offset for the given constant pool index
        // For simplicity, let's assume each entry is 4 bytes (this is not accurate for real class files)
        return index * 4; // Placeholder implementation
    }
}