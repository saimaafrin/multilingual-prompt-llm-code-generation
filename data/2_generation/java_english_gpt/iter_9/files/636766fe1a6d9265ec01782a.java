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
        // Read the length of the UTF-8 string
        int length = ((classFileBuffer[constantPoolEntryIndex] & 0xFF) << 8) | (classFileBuffer[constantPoolEntryIndex + 1] & 0xFF);
        
        // Read the UTF-8 bytes
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) (classFileBuffer[constantPoolEntryIndex + 2 + i] & 0xFF);
        }
        
        return new String(charBuffer, 0, length);
    }
}