import io.protostuff.LinkedBuffer;
import io.protostuff.WriteSession;

public class UTF8Writer {

    /**
     * 将字符串中的 UTF-8 编码字节写入 {@link LinkedBuffer}。
     *
     * @param str     要写入的字符串
     * @param session 写入会话
     * @param lb      目标 LinkedBuffer
     * @return 写入后的 LinkedBuffer
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8);
        int length = utf8Bytes.length;

        // 确保 LinkedBuffer 有足够的空间
        if (lb.offset + length > lb.buffer.length) {
            lb = LinkedBuffer.allocate(lb, length);
        }

        // 将字节写入 LinkedBuffer
        System.arraycopy(utf8Bytes, 0, lb.buffer, lb.offset, length);
        lb.offset += length;

        // 更新 WriteSession 的字节计数
        session.size += length;

        return lb;
    }
}