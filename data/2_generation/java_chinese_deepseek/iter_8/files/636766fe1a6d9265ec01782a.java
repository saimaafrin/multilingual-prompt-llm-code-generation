import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    ByteBuffer classFileBuffer = ByteBuffer.allocate(1024); // Example buffer, replace with actual class file buffer

    // Move to the constant pool entry position
    classFileBuffer.position(constantPoolEntryIndex);

    // Read the length of the UTF-8 string (first two bytes)
    int length = classFileBuffer.getShort() & 0xFFFF;

    // Decode the UTF-8 bytes into the provided charBuffer
    CharBuffer decodedBuffer = StandardCharsets.UTF_8.decode(classFileBuffer.slice().limit(length));
    decodedBuffer.get(charBuffer, 0, decodedBuffer.length());

    // Return the string representation of the charBuffer
    return new String(charBuffer, 0, decodedBuffer.length());
}