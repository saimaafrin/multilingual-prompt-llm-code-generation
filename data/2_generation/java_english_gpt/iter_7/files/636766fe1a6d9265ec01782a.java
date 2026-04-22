import java.nio.ByteBuffer;

public class ConstantPoolReader {
    private byte[] classFileBuffer;

    public ConstantPoolReader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * Reads a CONSTANT_Utf8 constant pool entry in  {@link #classFileBuffer}.
     * @param constantPoolEntryIndex the index of a CONSTANT_Utf8 entry in the class's constant pool table.
     * @param charBuffer the buffer to be used to read the string. This buffer must be sufficiently large. It is not automatically resized.
     * @return the String corresponding to the specified CONSTANT_Utf8 entry.
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the constant pool starts at a specific offset
        int constantPoolCount = ByteBuffer.wrap(classFileBuffer, 8, 2).getShort(); // Read the constant pool count
        int offset = 10; // Start reading after the magic number and version

        for (int i = 1; i < constantPoolCount; i++) {
            int tag = classFileBuffer[offset] & 0xFF; // Read the tag
            offset++; // Move to the next byte

            switch (tag) {
                case 1: // CONSTANT_Utf8
                    int length = ByteBuffer.wrap(classFileBuffer, offset, 2).getShort(); // Read length of Utf8
                    offset += 2; // Move past length
                    if (i == constantPoolEntryIndex) {
                        // Read the UTF-8 bytes
                        for (int j = 0; j < length; j++) {
                            charBuffer[j] = (char) classFileBuffer[offset + j]; // Convert bytes to chars
                        }
                        return new String(charBuffer, 0, length); // Return the constructed string
                    }
                    offset += length; // Move past the UTF-8 bytes
                    break;
                // Handle other constant types if necessary
                default:
                    // Skip the entry based on its type
                    break;
            }
        }
        throw new IndexOutOfBoundsException("Invalid constant pool entry index: " + constantPoolEntryIndex);
    }
}