import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    // and constantPool is an array of constant pool entries.
    // This is a simplified implementation and may need adjustments based on the actual class file structure.

    // Get the constant pool entry at the specified index
    int utf8Length = classFileBuffer.getShort(constantPoolEntryIndex) & 0xFFFF;
    byte[] utf8Bytes = new byte[utf8Length];
    classFileBuffer.get(utf8Bytes, 0, utf8Length);

    // Decode the UTF-8 bytes into a String using the provided charBuffer
    String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);
    utf8String.getChars(0, utf8String.length(), charBuffer, 0);

    return utf8String;
}