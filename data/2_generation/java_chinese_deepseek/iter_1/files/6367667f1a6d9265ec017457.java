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
        byte[] bytes = new byte[bb.remaining()];
        bb.get(bytes);
        String decodedString = new String(bytes, i, bytes.length - i, StandardCharsets.UTF_8);
        sb.append(decodedString);
        return bytes.length;
    }
}