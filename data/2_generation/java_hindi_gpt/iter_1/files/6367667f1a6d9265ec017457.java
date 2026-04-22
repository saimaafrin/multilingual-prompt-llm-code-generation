import java.nio.ByteBuffer;

public class Utf8Decoder {

    /** 
     * UTF-8 डिकोडिंग का उपयोग करके ऑक्टेट्स को कैरेक्टर में डिकोड करता है और कैरेक्टर को एक StringBuffer में जोड़ता है।
     * @return स्ट्रिंग में डिकोड करने के लिए अगले अनचेक किए गए कैरेक्टर का इंडेक्स
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        while (i < bb.limit()) {
            int b = bb.get(i) & 0xFF; // Get the byte and convert to unsigned
            if (b >= 0 && b <= 0x7F) { // 1-byte character
                sb.append((char) b);
                i++;
            } else if (b >= 0xC2 && b <= 0xDF) { // 2-byte character
                if (i + 1 < bb.limit()) {
                    int b2 = bb.get(i + 1) & 0xFF;
                    if ((b2 & 0xC0) == 0x80) {
                        sb.append((char) (((b & 0x1F) << 6) | (b2 & 0x3F)));
                        i += 2;
                    } else {
                        break; // Invalid sequence
                    }
                } else {
                    break; // Not enough bytes
                }
            } else if (b >= 0xE0 && b <= 0xEF) { // 3-byte character
                if (i + 2 < bb.limit()) {
                    int b2 = bb.get(i + 1) & 0xFF;
                    int b3 = bb.get(i + 2) & 0xFF;
                    if ((b2 & 0xC0) == 0x80 && (b3 & 0xC0) == 0x80) {
                        sb.append((char) (((b & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F)));
                        i += 3;
                    } else {
                        break; // Invalid sequence
                    }
                } else {
                    break; // Not enough bytes
                }
            } else if (b >= 0xF0 && b <= 0xF4) { // 4-byte character
                if (i + 3 < bb.limit()) {
                    int b2 = bb.get(i + 1) & 0xFF;
                    int b3 = bb.get(i + 2) & 0xFF;
                    int b4 = bb.get(i + 3) & 0xFF;
                    if ((b2 & 0xC0) == 0x80 && (b3 & 0xC0) == 0x80 && (b4 & 0xC0) == 0x80) {
                        int codePoint = ((b & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
                        sb.append(Character.toChars(codePoint));
                        i += 4;
                    } else {
                        break; // Invalid sequence
                    }
                } else {
                    break; // Not enough bytes
                }
            } else {
                break; // Invalid byte
            }
        }
        return i; // Return the next index to decode
    }
}