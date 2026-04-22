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
        // Assuming the constant pool entry index points to the start of the CONSTANT_Utf8_info structure
        int offset = constantPoolEntryIndex;

        // Read the length of the UTF-8 string (2 bytes)
        int length = ((classFileBuffer[offset] & 0xFF) << 8) | (classFileBuffer[offset + 1] & 0xFF);
        offset += 2;

        // Decode the UTF-8 bytes into the char buffer
        ByteBuffer byteBuffer = ByteBuffer.wrap(classFileBuffer, offset, length);
        int charCount = StandardCharsets.UTF_8.decode(byteBuffer, charBuffer, 0, charBuffer.length).position();

        // Convert the char buffer to a String
        return new String(charBuffer, 0, charCount);
    }
}