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
        // 确保 ByteBuffer 有足够的字节进行解码
        if (bb.remaining() < 1) {
            return i;
        }

        // 读取当前字节
        byte b = bb.get(i);

        // 判断是否为单字节字符（UTF-8 编码中，单字节字符的最高位为 0）
        if ((b & 0x80) == 0) {
            sb.append((char) b);
            return i + 1;
        }

        // 判断是否为多字节字符
        int numBytes;
        if ((b & 0xE0) == 0xC0) {
            numBytes = 2;
        } else if ((b & 0xF0) == 0xE0) {
            numBytes = 3;
        } else if ((b & 0xF8) == 0xF0) {
            numBytes = 4;
        } else {
            // 无效的 UTF-8 编码
            return i + 1;
        }

        // 检查是否有足够的字节进行解码
        if (bb.remaining() < numBytes) {
            return i;
        }

        // 读取多字节字符
        byte[] bytes = new byte[numBytes];
        for (int j = 0; j < numBytes; j++) {
            bytes[j] = bb.get(i + j);
        }

        // 解码并附加到 StringBuilder
        String decodedChar = new String(bytes, StandardCharsets.UTF_8);
        sb.append(decodedChar);

        // 返回下一个未检查字符的索引
        return i + numBytes;
    }
}