import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    // and constantPool is an array of constant pool entries.
    // This is a simplified implementation assuming the constant pool entry is a CONSTANT_Utf8_info structure.

    // Get the CONSTANT_Utf8_info entry from the constant pool
    int utf8Length = classFileBuffer.getShort(constantPoolEntryIndex) & 0xFFFF; // Length of the UTF-8 string
    int utf8Offset = constantPoolEntryIndex + 2; // Offset to the start of the UTF-8 bytes

    // Decode the UTF-8 bytes into the charBuffer
    byte[] utf8Bytes = new byte[utf8Length];
    classFileBuffer.position(utf8Offset);
    classFileBuffer.get(utf8Bytes, 0, utf8Length);

    // Convert the UTF-8 bytes to a String using the provided charBuffer
    String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);
    utf8String.getChars(0, utf8String.length(), charBuffer, 0);

    return utf8String;
}