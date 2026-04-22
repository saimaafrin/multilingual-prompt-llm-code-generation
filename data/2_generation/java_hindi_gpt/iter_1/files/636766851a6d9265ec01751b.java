public class HexDecoder {

    /** 
     * एक सहायक जो एक स्ट्रिंग से हेक्साडेसिमल संख्या के आधे को डिकोड करता है।
     * @param c वह ASCII वर्ण है जिसे डिकोड करना है। इसे {@code [0-9a-fA-F]} के रेंज में होना चाहिए।
     * @return ASCII वर्ण में प्रदर्शित हेक्साडेसिमल मान, या {@link Character#MAX_VALUE} यदि वर्ण अमान्य है।
     */
    private static char decodeHexNibble(final char c) {
        if (c >= '0' && c <= '9') {
            return (char) (c - '0');
        } else if (c >= 'a' && c <= 'f') {
            return (char) (c - 'a' + 10);
        } else if (c >= 'A' && c <= 'F') {
            return (char) (c - 'A' + 10);
        } else {
            return Character.MAX_VALUE; // Invalid character
        }
    }

    public static void main(String[] args) {
        // Test the decodeHexNibble method
        System.out.println(decodeHexNibble('0')); // Output: 0
        System.out.println(decodeHexNibble('a')); // Output: 10
        System.out.println(decodeHexNibble('F')); // Output: 15
        System.out.println(decodeHexNibble('g')); // Output: 65535 (Character.MAX_VALUE)
    }
}