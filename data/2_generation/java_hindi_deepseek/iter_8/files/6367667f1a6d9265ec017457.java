import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UTF8Decoder {

    /**
     * UTF-8 डिकोडिंग का उपयोग करके ऑक्टेट्स को कैरेक्टर में डिकोड करता है और कैरेक्टर को एक StringBuffer में जोड़ता है।
     * @param i स्ट्रिंग में डिकोड करने के लिए अगले अनचेक किए गए कैरेक्टर का इंडेक्स
     * @param bb बाइट बफर जिसमें ऑक्टेट्स होते हैं
     * @param sb स्ट्रिंग बिल्डर जिसमें डिकोड किए गए कैरेक्टर जोड़े जाते हैं
     * @return स्ट्रिंग में डिकोड करने के लिए अगले अनचेक किए गए कैरेक्टर का इंडेक्स
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        if (bb.remaining() < 1) {
            return i;
        }

        byte firstByte = bb.get();
        int codePoint;

        if ((firstByte & 0x80) == 0) {
            // 1-byte sequence
            codePoint = firstByte & 0x7F;
        } else if ((firstByte & 0xE0) == 0xC0) {
            // 2-byte sequence
            if (bb.remaining() < 1) {
                return i;
            }
            byte secondByte = bb.get();
            codePoint = ((firstByte & 0x1F) << 6) | (secondByte & 0x3F);
        } else if ((firstByte & 0xF0) == 0xE0) {
            // 3-byte sequence
            if (bb.remaining() < 2) {
                return i;
            }
            byte secondByte = bb.get();
            byte thirdByte = bb.get();
            codePoint = ((firstByte & 0x0F) << 12) | ((secondByte & 0x3F) << 6) | (thirdByte & 0x3F);
        } else if ((firstByte & 0xF8) == 0xF0) {
            // 4-byte sequence
            if (bb.remaining() < 3) {
                return i;
            }
            byte secondByte = bb.get();
            byte thirdByte = bb.get();
            byte fourthByte = bb.get();
            codePoint = ((firstByte & 0x07) << 18) | ((secondByte & 0x3F) << 12) | ((thirdByte & 0x3F) << 6) | (fourthByte & 0x3F);
        } else {
            // Invalid UTF-8 sequence
            return i;
        }

        sb.appendCodePoint(codePoint);
        return i + 1;
    }

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{(byte) 0xE0, (byte) 0xA4, (byte) 0xB9}); // Example UTF-8 bytes for 'ह'
        StringBuilder sb = new StringBuilder();
        int index = decodeOctets(0, bb, sb);
        System.out.println("Decoded String: " + sb.toString());
        System.out.println("Next Index: " + index);
    }
}