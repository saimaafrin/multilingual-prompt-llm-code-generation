import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    ByteBuffer classFileBuffer = ByteBuffer.allocate(1024); // Example buffer, replace with actual class file buffer

    // Move to the position of the constant pool entry
    classFileBuffer.position(constantPoolEntryIndex);

    // Read the length of the UTF-8 string (first two bytes)
    int length = classFileBuffer.getShort() & 0xFFFF;

    // Read the UTF-8 bytes into a byte array
    byte[] utf8Bytes = new byte[length];
    classFileBuffer.get(utf8Bytes);

    // Decode the UTF-8 bytes into a CharBuffer
    CharBuffer decodedBuffer = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(utf8Bytes));

    // Copy the decoded characters into the provided charBuffer
    decodedBuffer.get(charBuffer, 0, decodedBuffer.length());

    // Convert the charBuffer to a String and return
    return new String(charBuffer, 0, decodedBuffer.length());
}