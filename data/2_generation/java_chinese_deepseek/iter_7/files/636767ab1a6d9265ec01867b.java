import io.protostuff.LinkedBuffer;
import io.protostuff.Output;
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

        // Write the length of the UTF-8 bytes first
        LinkedBuffer buffer = session.writeVarInt32(length, lb);
        if (buffer == null) {
            buffer = LinkedBuffer.allocate();
        }

        // Write the UTF-8 bytes
        buffer = session.writeBytes(utf8Bytes, 0, length, buffer);

        return buffer;
    }
}