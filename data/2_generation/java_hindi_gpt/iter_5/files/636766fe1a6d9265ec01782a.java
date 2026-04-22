public class Utf8Reader {
    private final byte[] classFileBuffer;

    public Utf8Reader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * {@link #classFileBuffer} में एक CONSTANT_Utf8 स्थायी पूल प्रविष्टि को पढ़ता है।
     * @param constantPoolEntryIndex कक्षा के स्थायी पूल तालिका में एक CONSTANT_Utf8 प्रविष्टि का अनुक्रमांक।
     * @param charBuffer वह बफर है जिसका उपयोग स्ट्रिंग पढ़ने के लिए किया जाएगा। यह बफर पर्याप्त बड़ा होना चाहिए। इसे स्वचालित रूप से आकार नहीं दिया जाता है।
     * @return निर्दिष्ट CONSTANT_Utf8 प्रविष्टि के लिए संबंधित String।
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Assuming the classFileBuffer contains the constant pool and the necessary offsets
        int offset = getConstantPoolEntryOffset(constantPoolEntryIndex);
        int length = (classFileBuffer[offset] << 8) | (classFileBuffer[offset + 1] & 0xFF);
        
        // Read the UTF-8 bytes and convert to characters
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) classFileBuffer[offset + 2 + i];
        }
        
        return new String(charBuffer, 0, length);
    }

    private int getConstantPoolEntryOffset(int index) {
        // This method should return the correct offset for the given constant pool entry index
        // For simplicity, let's assume each entry is of fixed size (this is not true in real class files)
        return index * 2; // Placeholder implementation
    }
}