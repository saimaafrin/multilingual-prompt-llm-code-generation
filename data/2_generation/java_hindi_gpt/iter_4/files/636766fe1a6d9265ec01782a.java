public class UtfReader {
    private final char[] classFileBuffer; // Assuming this is initialized elsewhere

    /**
     * {@link #classFileBuffer} में एक CONSTANT_Utf8 स्थायी पूल प्रविष्टि को पढ़ता है।
     * @param constantPoolEntryIndex कक्षा के स्थायी पूल तालिका में एक CONSTANT_Utf8 प्रविष्टि का अनुक्रमांक।
     * @param charBuffer वह बफर है जिसका उपयोग स्ट्रिंग पढ़ने के लिए किया जाएगा। यह बफर पर्याप्त बड़ा होना चाहिए। इसे स्वचालित रूप से आकार नहीं दिया जाता है।
     * @return निर्दिष्ट CONSTANT_Utf8 प्रविष्टि के लिए संबंधित String।
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the first two bytes of the entry give the length of the UTF-8 string
        int length = ((classFileBuffer[constantPoolEntryIndex] & 0xFF) << 8) | (classFileBuffer[constantPoolEntryIndex + 1] & 0xFF);
        
        // Read the UTF-8 string into the charBuffer
        for (int i = 0; i < length; i++) {
            charBuffer[i] = classFileBuffer[constantPoolEntryIndex + 2 + i];
        }
        
        // Return the string created from the charBuffer
        return new String(charBuffer, 0, length);
    }
}