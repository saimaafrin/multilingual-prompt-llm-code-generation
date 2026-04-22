import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

final class ClassFileReader {
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
        // CONSTANT_Utf8_info structure format:
        // tag (1 byte) - always 1 for CONSTANT_Utf8
        // length (2 bytes) - number of bytes in the string
        // bytes (length bytes) - the string bytes in UTF-8 format

        ByteBuffer buffer = ByteBuffer.wrap(classFileBuffer);
        buffer.position(constantPoolEntryIndex);

        // Read the tag (should be 1 for CONSTANT_Utf8)
        byte tag = buffer.get();
        if (tag != 1) {
            throw new IllegalArgumentException("Invalid CONSTANT_Utf8 tag");
        }

        // Read the length of the UTF-8 string
        int length = buffer.getShort() & 0xFFFF;

        // Read the UTF-8 bytes
        byte[] utf8Bytes = new byte[length];
        buffer.get(utf8Bytes);

        // Convert UTF-8 bytes to a Java String
        String str = new String(utf8Bytes, StandardCharsets.UTF_8);

        // Copy the characters to the provided charBuffer
        str.getChars(0, str.length(), charBuffer, 0);

        return str;
    }
}