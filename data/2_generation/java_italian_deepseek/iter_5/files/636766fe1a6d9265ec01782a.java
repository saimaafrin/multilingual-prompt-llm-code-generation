import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    // and constantPool is an array of constant pool entries.
    // This is a simplified implementation.

    // Get the CONSTANT_Utf8_info structure from the constant pool
    int utf8InfoIndex = constantPool[constantPoolEntryIndex];
    
    // Read the length of the UTF-8 string
    int length = classFileBuffer.getShort(utf8InfoIndex) & 0xFFFF;
    
    // Read the UTF-8 bytes into a byte array
    byte[] utf8Bytes = new byte[length];
    classFileBuffer.position(utf8InfoIndex + 2);
    classFileBuffer.get(utf8Bytes, 0, length);
    
    // Decode the UTF-8 bytes into a String using the provided charBuffer
    int charCount = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(utf8Bytes)).get(charBuffer, 0, charBuffer.length);
    
    // Return the String
    return new String(charBuffer, 0, charCount);
}