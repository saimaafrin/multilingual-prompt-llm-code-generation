import io.protostuff.LinkedBuffer;
import io.protostuff.Output;
import io.protostuff.WriteSession;

public class UTF8Writer {

    /**
     * 将字符串中的 UTF-8 编码字节写入 {@link LinkedBuffer}。
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null) {
            return lb;
        }

        int length = str.length();
        int utf8Length = 0;

        // 计算 UTF-8 编码后的字节长度
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c <= 0x7F) {
                utf8Length++;
            } else if (c <= 0x7FF) {
                utf8Length += 2;
            } else if (Character.isHighSurrogate(c)) {
                utf8Length += 4;
                i++; // 跳过低代理项
            } else {
                utf8Length += 3;
            }
        }

        // 确保 LinkedBuffer 有足够的空间
        if (lb.offset + utf8Length > lb.buffer.length) {
            lb = LinkedBuffer.allocate(utf8Length, session.nextBufferSize(), lb);
        }

        // 将字符串编码为 UTF-8 并写入 LinkedBuffer
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c <= 0x7F) {
                lb.buffer[lb.offset++] = (byte) c;
            } else if (c <= 0x7FF) {
                lb.buffer[lb.offset++] = (byte) (0xC0 | (c >> 6));
                lb.buffer[lb.offset++] = (byte) (0x80 | (c & 0x3F));
            } else if (Character.isHighSurrogate(c)) {
                char low = str.charAt(++i);
                int codePoint = Character.toCodePoint(c, low);
                lb.buffer[lb.offset++] = (byte) (0xF0 | (codePoint >> 18));
                lb.buffer[lb.offset++] = (byte) (0x80 | ((codePoint >> 12) & 0x3F));
                lb.buffer[lb.offset++] = (byte) (0x80 | ((codePoint >> 6) & 0x3F));
                lb.buffer[lb.offset++] = (byte) (0x80 | (codePoint & 0x3F));
            } else {
                lb.buffer[lb.offset++] = (byte) (0xE0 | (c >> 12));
                lb.buffer[lb.offset++] = (byte) (0x80 | ((c >> 6) & 0x3F));
                lb.buffer[lb.offset++] = (byte) (0x80 | (c & 0x3F));
            }
        }

        return lb;
    }
}