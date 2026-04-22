import java.io.DataInput;
import java.io.IOException;

final class ClassFileReader {
    private byte[] classFileBuffer;
    private int[] constantPool;

    public ClassFileReader(byte[] classFileBuffer, int[] constantPool) {
        this.classFileBuffer = classFileBuffer;
        this.constantPool = constantPool;
    }

    /**
     * {@link #classFileBuffer} में एक CONSTANT_Utf8 स्थायी पूल प्रविष्टि को पढ़ता है।
     * @param constantPoolEntryIndex कक्षा के स्थायी पूल तालिका में एक CONSTANT_Utf8 प्रविष्टि का अनुक्रमांक।
     * @param charBuffer वह बफर है जिसका उपयोग स्ट्रिंग पढ़ने के लिए किया जाएगा। यह बफर पर्याप्त बड़ा होना चाहिए। इसे स्वचालित रूप से आकार नहीं दिया जाता है।
     * @return निर्दिष्ट CONSTANT_Utf8 प्रविष्टि के लिए संबंधित String।
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        int utf8Index = constantPool[constantPoolEntryIndex];
        int length = ((classFileBuffer[utf8Index] & 0xFF) << 8) | (classFileBuffer[utf8Index + 1] & 0xFF);
        int offset = utf8Index + 2;

        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) (classFileBuffer[offset + i] & 0xFF);
        }

        return new String(charBuffer, 0, length);
    }
}