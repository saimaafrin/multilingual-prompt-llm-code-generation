import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final class ClassFileReader {
    private final ByteBuffer classFileBuffer;

    public ClassFileReader(ByteBuffer classFileBuffer) {
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
        // CONSTANT_Utf8_info structure format:
        // u1 tag (1 byte)
        // u2 length (2 bytes)
        // u1 bytes[length] (variable length)

        // Get the position of the constant pool entry in the class file buffer
        int entryPosition = getConstantPoolEntryPosition(constantPoolEntryIndex);

        // Read the tag (should be 1 for CONSTANT_Utf8)
        byte tag = classFileBuffer.get(entryPosition);
        if (tag != 1) {
            throw new IllegalArgumentException("Invalid CONSTANT_Utf8 tag at index " + constantPoolEntryIndex);
        }

        // Read the length of the UTF-8 string
        int length = classFileBuffer.getShort(entryPosition + 1) & 0xFFFF;

        // Read the UTF-8 bytes into a byte array
        byte[] utf8Bytes = new byte[length];
        classFileBuffer.position(entryPosition + 3);
        classFileBuffer.get(utf8Bytes);

        // Convert the UTF-8 bytes to a String using the provided charBuffer
        String utf8String = new String(utf8Bytes, StandardCharsets.UTF_8);
        utf8String.getChars(0, utf8String.length(), charBuffer, 0);

        return utf8String;
    }

    private int getConstantPoolEntryPosition(int constantPoolEntryIndex) {
        // This method should return the position of the constant pool entry in the class file buffer
        // For simplicity, we assume that the constant pool entries are stored sequentially
        // and that the first entry starts at position 10 (after the magic number, version, etc.)
        // In a real implementation, this would need to be calculated based on the class file structure
        return 10 + (constantPoolEntryIndex - 1) * 5; // Simplified calculation
    }
}