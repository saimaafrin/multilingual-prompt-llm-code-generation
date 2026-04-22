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
        Output output = session.getOutput();

        int offset = 0;
        int length = utf8Bytes.length;

        while (length > 0) {
            int available = lb.buffer.length - lb.offset;
            if (available == 0) {
                lb = LinkedBuffer.allocateNextFrom(lb);
                available = lb.buffer.length - lb.offset;
            }

            int bytesToWrite = Math.min(available, length);
            System.arraycopy(utf8Bytes, offset, lb.buffer, lb.offset, bytesToWrite);

            lb.offset += bytesToWrite;
            offset += bytesToWrite;
            length -= bytesToWrite;
        }

        return lb;
    }
}