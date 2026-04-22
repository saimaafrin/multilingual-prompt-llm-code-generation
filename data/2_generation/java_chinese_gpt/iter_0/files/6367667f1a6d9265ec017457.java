import java.nio.ByteBuffer;

public class Decoder {

    /** 
     * 使用 UTF-8 解码将字节解码为字符，并将字符附加到 StringBuffer 中。
     * @return 下一个未检查字符在待解码字符串中的索引
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        while (i < bb.limit()) {
            byte b = bb.get(i);
            if ((b & 0x80) == 0) { // 1-byte character
                sb.append((char) b);
                i++;
            } else if ((b & 0xE0) == 0xC0) { // 2-byte character
                if (i + 1 >= bb.limit()) break; // Not enough bytes
                char c = (char) (((b & 0x1F) << 6) | (bb.get(i + 1) & 0x3F));
                sb.append(c);
                i += 2;
            } else if ((b & 0xF0) == 0xE0) { // 3-byte character
                if (i + 2 >= bb.limit()) break; // Not enough bytes
                char c = (char) (((b & 0x0F) << 12) | ((bb.get(i + 1) & 0x3F) << 6) | (bb.get(i + 2) & 0x3F));
                sb.append(c);
                i += 3;
            } else if ((b & 0xF8) == 0xF0) { // 4-byte character
                if (i + 3 >= bb.limit()) break; // Not enough bytes
                int codePoint = ((b & 0x07) << 18) | ((bb.get(i + 1) & 0x3F) << 12) | ((bb.get(i + 2) & 0x3F) << 6) | (bb.get(i + 3) & 0x3F);
                sb.append(Character.toChars(codePoint));
                i += 4;
            } else {
                // Invalid byte, handle error if necessary
                break;
            }
        }
        return i;
    }
}