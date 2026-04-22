import java.nio.ByteBuffer;

public class Decoder {

    /** 
     * 使用 UTF-8 解码将字节解码为字符，并将字符附加到 StringBuffer 中。
     * @return 下一个未检查字符在待解码字符串中的索引
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        while (i < bb.limit()) {
            int b = bb.get(i) & 0xFF; // 获取字节并确保为无符号
            if ((b & 0x80) == 0) { // 1字节字符
                sb.append((char) b);
                i++;
            } else if ((b & 0xE0) == 0xC0) { // 2字节字符
                if (i + 1 >= bb.limit()) break; // 检查边界
                int b2 = bb.get(i + 1) & 0xFF;
                sb.append((char) (((b & 0x1F) << 6) | (b2 & 0x3F)));
                i += 2;
            } else if ((b & 0xF0) == 0xE0) { // 3字节字符
                if (i + 2 >= bb.limit()) break; // 检查边界
                int b2 = bb.get(i + 1) & 0xFF;
                int b3 = bb.get(i + 2) & 0xFF;
                sb.append((char) (((b & 0x0F) << 12) | ((b2 & 0x3F) << 6) | (b3 & 0x3F)));
                i += 3;
            } else if ((b & 0xF8) == 0xF0) { // 4字节字符
                if (i + 3 >= bb.limit()) break; // 检查边界
                int b2 = bb.get(i + 1) & 0xFF;
                int b3 = bb.get(i + 2) & 0xFF;
                int b4 = bb.get(i + 3) & 0xFF;
                int codePoint = ((b & 0x07) << 18) | ((b2 & 0x3F) << 12) | ((b3 & 0x3F) << 6) | (b4 & 0x3F);
                sb.append(Character.toChars(codePoint));
                i += 4;
            } else {
                // 无效的 UTF-8 字节序列，处理错误
                break;
            }
        }
        return i;
    }
}