import java.nio.charset.StandardCharsets;

public class UtfReader {
    private byte[] classFileBuffer;

    public UtfReader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /** 
     * Reads a CONSTANT_Utf8 constant pool entry in  {@link #classFileBuffer}.
     * @param constantPoolEntryIndex the index of a CONSTANT_Utf8 entry in the class's constant pool table.
     * @param charBuffer the buffer to be used to read the string. This buffer must be sufficiently large. It is not automatically resized.
     * @return the String corresponding to the specified CONSTANT_Utf8 entry.
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the classFileBuffer contains the constant pool entries
        // and that the entry starts at a specific offset.
        int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);
        
        // Read the length of the UTF-8 string
        int length = (classFileBuffer[offset] << 8) + (classFileBuffer[offset + 1] & 0xFF);
        
        // Read the UTF-8 bytes
        byte[] utf8Bytes = new byte[length];
        System.arraycopy(classFileBuffer, offset + 2, utf8Bytes, 0, length);
        
        // Convert UTF-8 bytes to String
        return new String(utf8Bytes, StandardCharsets.UTF_8);
    }

    private int getConstantPoolEntryOffset(int index) {
        // This method should return the correct offset for the given constant pool entry index.
        // The implementation of this method depends on the structure of the classFileBuffer.
        // For simplicity, let's assume each entry is of fixed size (this is not true in practice).
        return index * 10; // Placeholder implementation
    }
}