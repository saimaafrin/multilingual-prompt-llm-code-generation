import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.WriteSession;

public class UTF8Writer {
    /**
     * 将字符串中的 UTF-8 编码字节写入 {@link LinkedBuffer}。
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null) {
            return lb;
        }

        final int len = str.length();
        if (len == 0) {
            return lb;
        }

        LinkedBuffer buffer = lb;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c < 0x80) {
                // 1 byte, 7 bits
                if (buffer.offset == buffer.buffer.length) {
                    buffer = LinkedBuffer.allocate(buffer.buffer.length);
                }
                buffer.buffer[buffer.offset++] = (byte) c;
            } else if (c < 0x800) {
                // 2 bytes, 11 bits
                if (buffer.offset + 2 > buffer.buffer.length) {
                    buffer = LinkedBuffer.allocate(buffer.buffer.length);
                }
                buffer.buffer[buffer.offset++] = (byte) (0xC0 | ((c >> 6) & 0x1F));
                buffer.buffer[buffer.offset++] = (byte) (0x80 | (c & 0x3F));
            } else {
                // 3 bytes, 16 bits
                if (buffer.offset + 3 > buffer.buffer.length) {
                    buffer = LinkedBuffer.allocate(buffer.buffer.length);
                }
                buffer.buffer[buffer.offset++] = (byte) (0xE0 | ((c >> 12) & 0x0F));
                buffer.buffer[buffer.offset++] = (byte) (0x80 | ((c >> 6) & 0x3F));
                buffer.buffer[buffer.offset++] = (byte) (0x80 | (c & 0x3F));
            }
        }

        session.size += buffer.offset - lb.offset;
        return buffer;
    }
}