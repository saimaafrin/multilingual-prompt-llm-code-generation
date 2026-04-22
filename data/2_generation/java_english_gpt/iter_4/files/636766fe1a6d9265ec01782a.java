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
        int offset = 10; // Starting offset after magic number and version

        for (int i = 1; i < constantPoolCount; i++) {
            int tag = classFileBuffer[offset] & 0xFF; // Read the tag
            offset++; // Move to the next byte

            switch (tag) {
                case 1: // CONSTANT_Utf8
                    int length = ByteBuffer.wrap(classFileBuffer, offset, 2).getShort(); // Read length
                    offset += 2; // Move past length
                    if (i == constantPoolEntryIndex) {
                        // Read the UTF-8 bytes
                        for (int j = 0; j < length; j++) {
                            charBuffer[j] = (char) classFileBuffer[offset + j]; // Convert bytes to chars
                        }
                        return new String(charBuffer, 0, length); // Return the string
                    }
                    offset += length; // Move past the UTF-8 bytes
                    break;
                case 7: // CONSTANT_Class
                case 8: // CONSTANT_String
                case 9: // CONSTANT_Fieldref
                case 10: // CONSTANT_Methodref
                case 11: // CONSTANT_InterfaceMethodref
                case 12: // CONSTANT_NameAndType
                case 15: // CONSTANT_MethodHandle
                case 16: // CONSTANT_MethodType
                case 18: // CONSTANT_InvokeDynamic
                    // Handle other constant types (not implemented here)
                    // Each of these types has a different structure, so we would need to skip the appropriate number of bytes
                    break;
                default:
                    throw new IllegalArgumentException("Unknown constant pool tag: " + tag);
            }
        }
        throw new IndexOutOfBoundsException("Constant pool entry index out of bounds: " + constantPoolEntryIndex);
    }
}