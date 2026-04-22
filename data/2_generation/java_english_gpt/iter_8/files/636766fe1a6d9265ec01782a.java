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
        // Assuming the constant pool starts at a certain offset
        int offset = getConstantPoolOffset(constantPoolEntryIndex);
        
        // Read the length of the UTF-8 string
        int length = (classFileBuffer[offset] << 8) + (classFileBuffer[offset + 1] & 0xFF);
        
        // Read the UTF-8 bytes
        byte[] utf8Bytes = new byte[length];
        System.arraycopy(classFileBuffer, offset + 2, utf8Bytes, 0, length);
        
        // Convert UTF-8 bytes to a String
        String result = new String(utf8Bytes, StandardCharsets.UTF_8);
        
        // Fill the charBuffer if needed
        if (charBuffer.length >= result.length()) {
            result.getChars(0, result.length(), charBuffer, 0);
        } else {
            throw new IllegalArgumentException("charBuffer is not large enough");
        }
        
        return result;
    }

    private int getConstantPoolOffset(int index) {
        // This method should return the correct offset for the given constant pool index
        // For simplicity, let's assume each entry is 2 bytes for the length + variable length for the UTF-8 string
        // In a real implementation, you would need to parse the constant pool structure properly
        return index * 2; // Placeholder implementation
    }
}