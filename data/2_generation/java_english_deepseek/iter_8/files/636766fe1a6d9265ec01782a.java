import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    // and constantPoolEntryIndex is the index of the CONSTANT_Utf8 entry in the constant pool.

    // Calculate the offset of the CONSTANT_Utf8 entry in the class file buffer
    int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);

    // Read the length of the UTF-8 string (2 bytes)
    int length = classFileBuffer.getShort(offset) & 0xFFFF;
    offset += 2;

    // Decode the UTF-8 bytes into the charBuffer
    for (int i = 0; i < length; i++) {
        charBuffer[i] = (char) (classFileBuffer.get(offset + i) & 0xFF);
    }

    // Convert the charBuffer to a String
    return new String(charBuffer, 0, length);
}

// Helper method to get the offset of a constant pool entry
private int getConstantPoolEntryOffset(int constantPoolEntryIndex) {
    // This method should return the offset of the constant pool entry in the classFileBuffer.
    // The implementation depends on the structure of the constant pool in the class file.
    // For simplicity, this is a placeholder implementation.
    return constantPoolEntryIndex * 8; // Example offset calculation
}

// Assuming classFileBuffer is a ByteBuffer containing the class file data
private ByteBuffer classFileBuffer;