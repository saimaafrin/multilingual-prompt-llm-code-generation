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
        if (str == null) {
            return lb;
        }

        int length = str.length();
        if (length == 0) {
            return lb;
        }

        LinkedBuffer buffer = lb;
        Output output = session.getOutput();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            if (c <= 0x007F) {
                // 1 byte
                buffer = output.writeByte((byte) c, buffer);
            } else if (c <= 0x07FF) {
                // 2 bytes
                buffer = output.writeByte((byte) (0xC0 | (c >> 6)), buffer);
                buffer = output.writeByte((byte) (0x80 | (c & 0x3F)), buffer);
            } else {
                // 3 bytes
                buffer = output.writeByte((byte) (0xE0 | (c >> 12)), buffer);
                buffer = output.writeByte((byte) (0x80 | ((c >> 6) & 0x3F)), buffer);
                buffer = output.writeByte((byte) (0x80 | (c & 0x3F)), buffer);
            }
        }

        return buffer;
    }
}