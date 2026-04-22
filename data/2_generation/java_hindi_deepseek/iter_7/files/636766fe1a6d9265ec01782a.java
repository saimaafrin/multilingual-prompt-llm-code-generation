import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    // Assuming classFileBuffer is a byte array containing the class file data
    // and constantPool is an array of ConstantPoolEntry objects.
    // This is a simplified implementation and may need adjustments based on the actual class file structure.

    try {
        // Get the constant pool entry at the specified index
        ConstantPoolEntry entry = constantPool[constantPoolEntryIndex];
        
        // Check if the entry is of type CONSTANT_Utf8
        if (entry.getTag() != ConstantPoolEntry.CONSTANT_Utf8) {
            throw new IllegalArgumentException("The specified constant pool entry is not a CONSTANT_Utf8 entry.");
        }

        // Read the UTF-8 bytes from the entry
        byte[] utf8Bytes = entry.getBytes();

        // Use a DataInputStream to read the UTF-8 bytes into the charBuffer
        ByteArrayInputStream bais = new ByteArrayInputStream(utf8Bytes);
        DataInputStream dis = new DataInputStream(bais);

        // Read the UTF-8 string into the charBuffer
        int length = dis.readUnsignedShort();
        dis.readFully(charBuffer, 0, length);

        // Convert the charBuffer to a String
        return new String(charBuffer, 0, length);
    } catch (IOException e) {
        throw new RuntimeException("Error reading UTF-8 string from constant pool", e);
    }
}

// Assuming ConstantPoolEntry is a class that represents a constant pool entry
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
        byte[] utf8Bytes = {0x00, 0x05, 0x48, 0x65, 0x6C, 0x6C, 0x6F}; // Represents "Hello"
        ConstantPoolEntry entry = new ConstantPoolEntry(ConstantPoolEntry.CONSTANT_Utf8, utf8Bytes);

        // Example constant pool array
        ConstantPoolEntry[] constantPool = new ConstantPoolEntry[1];
        constantPool[0] = entry;

        // Char buffer to hold the string
        char[] charBuffer = new char[10];

        // Read the UTF-8 string
        String result = readUtf(0, charBuffer);
        System.out.println(result); // Output: Hello
    }
}