import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ClassFileReader {
    private final byte[] classFileBuffer;

    public ClassFileReader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * {@link #classFileBuffer} में एक CONSTANT_Utf8 स्थायी पूल प्रविष्टि को पढ़ता है।
     * @param constantPoolEntryIndex कक्षा के स्थायी पूल तालिका में एक CONSTANT_Utf8 प्रविष्टि का अनुक्रमांक।
     * @param charBuffer वह बफर है जिसका उपयोग स्ट्रिंग पढ़ने के लिए किया जाएगा। यह बफर पर्याप्त बड़ा होना चाहिए। इसे स्वचालित रूप से आकार नहीं दिया जाता है।
     * @return निर्दिष्ट CONSTANT_Utf8 प्रविष्टि के लिए संबंधित String।
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the constant pool entry is a CONSTANT_Utf8_info structure
        // The structure is as follows:
        // u1 tag (1 byte)
        // u2 length (2 bytes)
        // u1 bytes[length] (variable length)

        // Calculate the offset in the classFileBuffer for the given constantPoolEntryIndex
        int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);

        // Read the tag (should be 1 for CONSTANT_Utf8)
        byte tag = classFileBuffer[offset];
        if (tag != 1) {
            throw new IllegalArgumentException("Invalid CONSTANT_Utf8 tag at index " + constantPoolEntryIndex);
        }

        // Read the length of the UTF-8 string
        int length = ((classFileBuffer[offset + 1] & 0xFF) << 8 | (classFileBuffer[offset + 2] & 0xFF);

        // Read the UTF-8 bytes into a byte array
        byte[] utf8Bytes = new byte[length];
        System.arraycopy(classFileBuffer, offset + 3, utf8Bytes, 0, length);

        // Convert the UTF-8 bytes to a String using the provided charBuffer
        ByteBuffer byteBuffer = ByteBuffer.wrap(utf8Bytes);
        return StandardCharsets.UTF_8.decode(byteBuffer).toString();
    }

    private int getConstantPoolEntryOffset(int constantPoolEntryIndex) {
        // This method should calculate the offset of the constant pool entry in the classFileBuffer
        // based on the constantPoolEntryIndex. This is a simplified example and may not cover all cases.
        // In a real implementation, you would need to parse the class file structure properly.
        return constantPoolEntryIndex * 5; // Simplified offset calculation
    }
}