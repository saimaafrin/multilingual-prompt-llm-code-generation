import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UTF8Decoder {

    /**
     * UTF-8 डिकोडिंग का उपयोग करके ऑक्टेट्स को कैरेक्टर में डिकोड करता है और कैरेक्टर को एक StringBuffer में जोड़ता है।
     * @param i स्ट्रिंग में डिकोड करने के लिए शुरुआती इंडेक्स
     * @param bb बाइट बफर जिसमें UTF-8 ऑक्टेट्स होते हैं
     * @param sb स्ट्रिंग बिल्डर जिसमें डिकोड किए गए कैरेक्टर जोड़े जाते हैं
     * @return स्ट्रिंग में डिकोड करने के लिए अगले अनचेक किए गए कैरेक्टर का इंडेक्स
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        byte b = bb.get(i);
        if ((b & 0x80) == 0) {
            // 1-byte character
            sb.append((char) b);
            return i + 1;
        } else if ((b & 0xE0) == 0xC0) {
            // 2-byte character
            if (i + 1 >= bb.limit()) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            byte b2 = bb.get(i + 1);
            if ((b2 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            int codePoint = ((b & 0x1F) << 6) | (b2 & 0x3F);
            sb.append((char) codePoint);
            return i + 2;
        } else if ((b & 0xF0) == 0xE0) {
            // 3-byte character
            if (i + 2 >= bb.limit()) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            byte b2 = bb.get(i + 1);
            byte b3 = bb.get(i + 2);
            if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            int codePoint = ((b & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
            sb.append((char) codePoint);
            return i + 3;
        } else if ((b & 0xF8) == 0xF0) {
            // 4-byte character
            if (i + 3 >= bb.limit()) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            byte b2 = bb.get(i + 1);
            byte b3 = bb.get(i + 2);
            byte b4 = bb.get(i + 3);
            if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80 || (b4 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence");
            }
            int codePoint = ((b & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
            sb.append(Character.toChars(codePoint));
            return i + 4;
        } else {
            throw new IllegalArgumentException("Invalid UTF-8 sequence");
        }
    }
}