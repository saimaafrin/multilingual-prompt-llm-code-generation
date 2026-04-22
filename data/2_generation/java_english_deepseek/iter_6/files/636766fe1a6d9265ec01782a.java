import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a ByteBuffer containing the class file data
    // and constantPool is an array of constant pool entries.
    // This is a simplified implementation assuming the constant pool entry is already parsed.

    // Get the constant pool entry at the specified index
    ConstantPoolEntry entry = constantPool[constantPoolEntryIndex];

    // Ensure the entry is of type CONSTANT_Utf8
    if (entry.getTag() != ConstantPoolEntry.CONSTANT_Utf8) {
        throw new IllegalArgumentException("The specified constant pool entry is not a CONSTANT_Utf8 entry.");
    }

    // Get the byte array representing the UTF-8 string
    byte[] utf8Bytes = entry.getBytes();

    // Decode the UTF-8 bytes into a String using the provided charBuffer
    int length = utf8Bytes.length;
    int charCount = 0;
    int i = 0;

    while (i < length) {
        int b1 = utf8Bytes[i++] & 0xFF;
        if (b1 < 0x80) {
            // 1-byte sequence
            charBuffer[charCount++] = (char) b1;
        } else if ((b1 & 0xE0) == 0xC0) {
            // 2-byte sequence
            int b2 = utf8Bytes[i++] & 0xFF;
            charBuffer[charCount++] = (char) (((b1 & 0x1F) << 6) | (b2 & 0x3F);
        } else if ((b1 & 0xF0) == 0xE0) {
            // 3-byte sequence
            int b2 = utf8Bytes[i++] & 0xFF;
            int b3 = utf8Bytes[i++] & 0xFF;
            charBuffer[charCount++] = (char) (((b1 & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
        } else {
            // Invalid UTF-8 sequence
            throw new IllegalArgumentException("Invalid UTF-8 sequence in constant pool entry.");
        }
    }

    // Create a String from the charBuffer
    return new String(charBuffer, 0, charCount);
}

// Assuming ConstantPoolEntry is a class representing a constant pool entry
class ConstantPoolEntry {
    public static final int CONSTANT_Utf8 = 1;

    private int tag;
    private byte[] bytes;

    public ConstantPoolEntry(int tag, byte[] bytes) {
        this.tag = tag;
        this.bytes = bytes;
    }

    public int getTag() {
        return tag;
    }

    public byte[] getBytes() {
        return bytes;
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Example constant pool entry for a UTF-8 string
        byte[] utf8Bytes = "Hello, World!".getBytes(StandardCharsets.UTF_8);
        ConstantPoolEntry entry = new ConstantPoolEntry(ConstantPoolEntry.CONSTANT_Utf8, utf8Bytes);

        // Assuming constantPool is an array of ConstantPoolEntry
        ConstantPoolEntry[] constantPool = new ConstantPoolEntry[1];
        constantPool[0] = entry;

        // Char buffer to hold the decoded string
        char[] charBuffer = new char[100];

        // Read the UTF-8 string from the constant pool
        String result = readUtf(0, charBuffer);
        System.out.println(result);  // Output: Hello, World!
    }
}