import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

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
        try (ByteArrayInputStream bais = new ByteArrayInputStream(classFileBuffer);
             DataInputStream dis = new DataInputStream(bais)) {
            
            // Skip to the constant pool entry
            dis.skipBytes(constantPoolEntryIndex);

            // Read the length of the UTF-8 string
            int length = dis.readUnsignedShort();

            // Read the UTF-8 bytes into the char buffer
            for (int i = 0; i < length; i++) {
                charBuffer[i] = (char) dis.readUnsignedByte();
            }

            // Convert the char buffer to a String
            return new String(charBuffer, 0, length);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read UTF-8 string from constant pool", e);
        }
    }
}