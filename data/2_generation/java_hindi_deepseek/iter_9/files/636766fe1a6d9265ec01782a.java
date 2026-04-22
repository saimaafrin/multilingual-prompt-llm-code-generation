import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
    try {
        // Assuming classFileBuffer is a byte array containing the class file data
        ByteArrayInputStream bais = new ByteArrayInputStream(classFileBuffer);
        DataInputStream dis = new DataInputStream(bais);

        // Skip to the constant pool entry
        dis.skipBytes(constantPoolEntryIndex);

        // Read the length of the UTF-8 string
        int length = dis.readUnsignedShort();

        // Read the UTF-8 bytes into the charBuffer
        for (int i = 0; i < length; i++) {
            charBuffer[i] = dis.readChar();
        }

        // Convert the charBuffer to a String
        return new String(charBuffer, 0, length);
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}