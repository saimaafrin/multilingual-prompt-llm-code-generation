import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    // and constantPoolEntryIndex is the index of the CONSTANT_Utf8 entry in the constant pool.

    // Calculate the offset of the constant pool entry in the class file buffer
    int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);

    // Read the length of the UTF-8 string (2 bytes)
    int length = classFileBuffer.getShort(offset) & 0xFFFF;
    offset += 2;

    // Read the UTF-8 bytes into a byte array
    byte[] utf8Bytes = new byte[length];
    for (int i = 0; i < length; i++) {
        utf8Bytes[i] = classFileBuffer.get(offset + i);
    }

    // Convert the UTF-8 bytes to a String using the provided char buffer
    return new String(utf8Bytes, StandardCharsets.UTF_8);
}

// Helper method to calculate the offset of a constant pool entry
private int getConstantPoolEntryOffset(int constantPoolEntryIndex) {
    // This method should be implemented based on the structure of the class file.
    // For simplicity, we assume that the constant pool starts at a fixed offset.
    // In a real implementation, this would need to account for the class file header,
    // constant pool size, and other factors.
    return CONSTANT_POOL_START_OFFSET + (constantPoolEntryIndex - 1) * CONSTANT_POOL_ENTRY_SIZE;
}

// Example constants (these would need to be defined based on the class file structure)
private static final int CONSTANT_POOL_START_OFFSET = 10; // Example offset
private static final int CONSTANT_POOL_ENTRY_SIZE = 8; // Example size

// Assuming classFileBuffer is a ByteBuffer containing the class file data
private ByteBuffer classFileBuffer;