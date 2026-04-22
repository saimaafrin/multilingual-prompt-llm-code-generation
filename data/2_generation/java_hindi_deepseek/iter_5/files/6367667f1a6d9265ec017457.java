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
        if (i >= bb.limit()) {
            return i;
        }

        byte firstByte = bb.get(i);
        int codePoint;
        int charCount;

        if ((firstByte & 0x80) == 0) {
            // 1-byte character
            codePoint = firstByte & 0x7F;
            charCount = 1;
        } else if ((firstByte & 0xE0) == 0xC0) {
            // 2-byte character
            codePoint = firstByte & 0x1F;
            charCount = 2;
        } else if ((firstByte & 0xF0) == 0xE0) {
            // 3-byte character
            codePoint = firstByte & 0x0F;
            charCount = 3;
        } else if ((firstByte & 0xF8) == 0xF0) {
            // 4-byte character
            codePoint = firstByte & 0x07;
            charCount = 4;
        } else {
            // Invalid UTF-8 sequence
            throw new IllegalArgumentException("Invalid UTF-8 sequence");
        }

        if (i + charCount > bb.limit()) {
            throw new IllegalArgumentException("Incomplete UTF-8 sequence");
        }

        for (int j = 1; j < charCount; j++) {
            byte nextByte = bb.get(i + j);
            if ((nextByte & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            codePoint = (codePoint << 6) | (nextByte & 0x3F);
        }

        sb.append(Character.toChars(codePoint));
        return i + charCount;
    }
}