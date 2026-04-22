import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    // and constantPool is an array of constant pool entries.
    // This is a simplified implementation assuming the constant pool entry is already parsed.

    // Get the CONSTANT_Utf8_info structure from the constant pool
    int utf8Length = classFileBuffer.getShort(constantPoolEntryIndex + 1) & 0xFFFF; // Length of the UTF-8 string
    byte[] utf8Bytes = new byte[utf8Length];
    classFileBuffer.position(constantPoolEntryIndex + 3); // Skip tag and length
    classFileBuffer.get(utf8Bytes, 0, utf8Length);

    // Decode the UTF-8 bytes into a String using the provided charBuffer
    return new String(utf8Bytes, StandardCharsets.UTF_8);
}