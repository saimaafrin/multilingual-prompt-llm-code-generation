import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    // and constantPool is an array of constant pool entries.
    // This is a simplified implementation.

    // Get the CONSTANT_Utf8_info entry from the constant pool
    int utf8Length = classFileBuffer.getShort(constantPoolEntryIndex + 1); // Length of the UTF-8 string
    byte[] utf8Bytes = new byte[utf8Length];
    classFileBuffer.position(constantPoolEntryIndex + 3); // Skip tag and length
    classFileBuffer.get(utf8Bytes, 0, utf8Length);

    // Decode the UTF-8 bytes into a String using the provided charBuffer
    int charCount = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(utf8Bytes)).get(charBuffer, 0, charBuffer.length);

    return new String(charBuffer, 0, charCount);
}