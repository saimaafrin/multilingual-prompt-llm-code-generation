import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    ByteBuffer classFileBuffer = ByteBuffer.wrap(new byte[0]); // Replace with actual class file data

    // Move to the constant pool entry index
    classFileBuffer.position(constantPoolEntryIndex);

    // Read the length of the UTF-8 string
    int length = classFileBuffer.getShort() & 0xFFFF;

    // Read the UTF-8 bytes into a byte array
    byte[] utf8Bytes = new byte[length];
    classFileBuffer.get(utf8Bytes);

    // Decode the UTF-8 bytes into the provided char buffer
    CharBuffer decodedBuffer = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(utf8Bytes));
    decodedBuffer.get(charBuffer, 0, decodedBuffer.length());

    // Return the string representation
    return new String(charBuffer, 0, decodedBuffer.length());
}