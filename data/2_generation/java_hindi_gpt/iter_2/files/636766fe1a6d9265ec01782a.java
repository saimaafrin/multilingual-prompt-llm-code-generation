public class UtfReader {
    private final char[] classFileBuffer;

    public UtfReader(char[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /** 
     * {@link #classFileBuffer} में एक CONSTANT_Utf8 स्थायी पूल प्रविष्टि को पढ़ता है।
     * @param constantPoolEntryIndex कक्षा के स्थायी पूल तालिका में एक CONSTANT_Utf8 प्रविष्टि का अनुक्रमांक।
     * @param charBuffer वह बफर है जिसका उपयोग स्ट्रिंग पढ़ने के लिए किया जाएगा। यह बफर पर्याप्त बड़ा होना चाहिए। इसे स्वचालित रूप से आकार नहीं दिया जाता है।
     * @return निर्दिष्ट CONSTANT_Utf8 प्रविष्टि के लिए संबंधित String।
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the classFileBuffer contains the necessary data to read the UTF-8 string
        // The actual implementation will depend on the structure of the class file format
        int length = readUnsignedShort(constantPoolEntryIndex); // Read length of the UTF-8 string
        int start = constantPoolEntryIndex + 2; // Assuming the entry starts after the length
        for (int i = 0; i < length; i++) {
            charBuffer[i] = classFileBuffer[start + i];
        }
        return new String(charBuffer, 0, length);
    }

    private int readUnsignedShort(int index) {
        // This method should read two bytes from classFileBuffer starting at index
        // and return the unsigned short value. This is a placeholder implementation.
        return (classFileBuffer[index] << 8) + (classFileBuffer[index + 1] & 0xFF);
    }
}