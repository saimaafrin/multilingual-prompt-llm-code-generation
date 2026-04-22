import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    // and constantPool is an array of constant pool entries.
    // This is a simplified implementation assuming the constant pool entry is already parsed.

    // Get the constant pool entry at the specified index
    // For simplicity, assume the entry is a CONSTANT_Utf8_info structure
    // CONSTANT_Utf8_info structure:
    // u1 tag (1 byte)
    // u2 length (2 bytes)
    // u1 bytes[length] (variable length)

    // Read the tag (should be 1 for CONSTANT_Utf8)
    byte tag = classFileBuffer.get(constantPoolEntryIndex);
    if (tag != 1) {
        throw new IllegalArgumentException("Invalid CONSTANT_Utf8 tag at index " + constantPoolEntryIndex);
    }

    // Read the length of the UTF-8 string (2 bytes)
    int length = classFileBuffer.getShort(constantPoolEntryIndex + 1) & 0xFFFF;

    // Read the UTF-8 bytes into a byte array
    byte[] utf8Bytes = new byte[length];
    classFileBuffer.position(constantPoolEntryIndex + 3);
    classFileBuffer.get(utf8Bytes, 0, length);

    // Convert the UTF-8 bytes to a Java String
    String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);

    // Copy the characters to the provided charBuffer
    utf8String.getChars(0, utf8String.length(), charBuffer, 0);

    return utf8String;
}