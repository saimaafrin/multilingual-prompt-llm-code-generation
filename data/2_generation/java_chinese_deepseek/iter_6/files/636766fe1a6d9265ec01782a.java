import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

final class ClassFileReader {
    private final ByteBuffer classFileBuffer;

    public ClassFileReader(ByteBuffer classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * 读取 {@link #classFileBuffer} 中的 CONSTANT_Utf8 常量池条目。
     * @param constantPoolEntryIndex 类的常量池表中 CONSTANT_Utf8 条目的索引。
     * @param charBuffer 用于读取字符串的缓冲区。此缓冲区必须足够大。不会自动调整大小。
     * @return 与指定的 CONSTANT_Utf8 条目对应的字符串。
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the constant pool entry is stored as a length-prefixed UTF-8 string
        // and the constantPoolEntryIndex is the offset in the buffer.
        classFileBuffer.position(constantPoolEntryIndex);

        // Read the length of the UTF-8 string (assuming it's a 2-byte unsigned integer)
        int length = classFileBuffer.getShort() & 0xFFFF;

        // Read the UTF-8 bytes into a temporary buffer
        byte[] utf8Bytes = new byte[length];
        classFileBuffer.get(utf8Bytes);

        // Decode the UTF-8 bytes into the provided charBuffer
        CharBuffer decodedBuffer = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(utf8Bytes));
        decodedBuffer.get(charBuffer, 0, decodedBuffer.length());

        // Return the string representation
        return new String(charBuffer, 0, decodedBuffer.length());
    }
}