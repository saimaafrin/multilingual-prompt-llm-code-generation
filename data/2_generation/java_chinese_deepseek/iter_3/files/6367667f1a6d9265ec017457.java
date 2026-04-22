import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Decoder {

    /**
     * 使用 UTF-8 解码将字节解码为字符，并将字符附加到 StringBuffer 中。
     * @param i 当前待解码字节的索引
     * @param bb 包含待解码字节的 ByteBuffer
     * @param sb 用于存储解码后字符的 StringBuilder
     * @return 下一个未检查字符在待解码字符串中的索引
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        // 获取当前字节
        byte b = bb.get(i);
        
        // 判断字节的高位以确定字符的字节长度
        if ((b & 0x80) == 0) {
            // 单字节字符 (0xxxxxxx)
            sb.append((char) b);
            return i + 1;
        } else if ((b & 0xE0) == 0xC0) {
            // 双字节字符 (110xxxxx 10xxxxxx)
            if (i + 1 >= bb.limit()) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence: incomplete 2-byte character");
            }
            byte b2 = bb.get(i + 1);
            if ((b2 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence: invalid continuation byte");
            }
            int codePoint = ((b & 0x1F) << 6) | (b2 & 0x3F);
            sb.append((char) codePoint);
            return i + 2;
        } else if ((b & 0xF0) == 0xE0) {
            // 三字节字符 (1110xxxx 10xxxxxx 10xxxxxx)
            if (i + 2 >= bb.limit()) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence: incomplete 3-byte character");
            }
            byte b2 = bb.get(i + 1);
            byte b3 = bb.get(i + 2);
            if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence: invalid continuation bytes");
            }
            int codePoint = ((b & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F);
            sb.append((char) codePoint);
            return i + 3;
        } else if ((b & 0xF8) == 0xF0) {
            // 四字节字符 (11110xxx 10xxxxxx 10xxxxxx 10xxxxxx)
            if (i + 3 >= bb.limit()) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence: incomplete 4-byte character");
            }
            byte b2 = bb.get(i + 1);
            byte b3 = bb.get(i + 2);
            byte b4 = bb.get(i + 3);
            if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80 || (b4 & 0xC0) != 0x80) {
                throw new IllegalArgumentException("Invalid UTF-8 sequence: invalid continuation bytes");
            }
            int codePoint = ((b & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
            sb.append(Character.toChars(codePoint));
            return i + 4;
        } else {
            throw new IllegalArgumentException("Invalid UTF-8 sequence: invalid start byte");
        }
    }
}