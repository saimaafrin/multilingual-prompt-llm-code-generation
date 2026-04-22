import java.nio.ByteBuffer;

public class ConstantPoolReader {
    private final byte[] classFileBuffer;

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
        // Assuming the constant pool starts at a certain offset
        int constantPoolCount = ByteBuffer.wrap(classFileBuffer, 8, 2).getShort(); // Read the constant pool count
        int offset = 10; // Starting offset after magic number and version

        for (int i = 1; i < constantPoolCount; i++) {
            int tag = classFileBuffer[offset] & 0xFF; // Read the tag
            offset++; // Move to the next byte

            if (tag == 1) { // CONSTANT_Utf8
                int length = ByteBuffer.wrap(classFileBuffer, offset, 2).getShort(); // Read length of Utf8
                offset += 2; // Move past length

                if (length > charBuffer.length) {
                    throw new IllegalArgumentException("charBuffer is not large enough");
                }

                // Read the UTF-8 bytes
                for (int j = 0; j < length; j++) {
                    charBuffer[j] = (char) classFileBuffer[offset + j];
                }
                offset += length; // Move past the UTF-8 bytes

                return new String(charBuffer, 0, length); // Return the constructed string
            } else {
                // Handle other constant types (not implemented for brevity)
                // Skip the entry based on its type
                switch (tag) {
                    case 7: // CONSTANT_Class
                    case 8: // CONSTANT_String
                        offset += 2; // Skip 2 bytes for these types
                        break;
                    case 9: // CONSTANT_Fieldref
                    case 10: // CONSTANT_Methodref
                    case 11: // CONSTANT_InterfaceMethodref
                        offset += 4; // Skip 4 bytes for these types
                        break;
                    case 12: // CONSTANT_NameAndType
                        offset += 4; // Skip 4 bytes for this type
                        break;
                    case 3: // CONSTANT_Integer
                    case 4: // CONSTANT_Float
                    case 5: // CONSTANT_Long
                    case 6: // CONSTANT_Double
                        offset += 8; // Skip 8 bytes for these types
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown constant pool tag: " + tag);
                }
            }
        }
        throw new IndexOutOfBoundsException("Invalid constant pool entry index: " + constantPoolEntryIndex);
    }
}