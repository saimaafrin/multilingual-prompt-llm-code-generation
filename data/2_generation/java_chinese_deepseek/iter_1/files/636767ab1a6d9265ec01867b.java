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
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c <= 0x7F) {
                utf8Length++;
            } else if (c <= 0x7FF) {
                utf8Length += 2;
            } else if (Character.isHighSurrogate(c)) {
                utf8Length += 4;
                i++; // Skip the low surrogate
            } else {
                utf8Length += 3;
            }
        }

        if (utf8Length > 65535) {
            throw new IllegalArgumentException("UTF-8 encoded string is too long: " + utf8Length);
        }

        LinkedBuffer buffer = lb;
        if (buffer == null) {
            buffer = LinkedBuffer.allocate();
        }

        Output output = session.getOutput();
        output.writeVarInt32(utf8Length, buffer);

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c <= 0x7F) {
                buffer.buffer[buffer.offset++] = (byte) c;
            } else if (c <= 0x7FF) {
                buffer.buffer[buffer.offset++] = (byte) (0xC0 | (c >> 6));
                buffer.buffer[buffer.offset++] = (byte) (0x80 | (c & 0x3F));
            } else if (Character.isHighSurrogate(c)) {
                int codePoint = Character.toCodePoint(c, str.charAt(++i));
                buffer.buffer[buffer.offset++] = (byte) (0xF0 | (codePoint >> 18));
                buffer.buffer[buffer.offset++] = (byte) (0x80 | ((codePoint >> 12) & 0x3F));
                buffer.buffer[buffer.offset++] = (byte) (0x80 | ((codePoint >> 6) & 0x3F));
                buffer.buffer[buffer.offset++] = (byte) (0x80 | (codePoint & 0x3F));
            } else {
                buffer.buffer[buffer.offset++] = (byte) (0xE0 | (c >> 12));
                buffer.buffer[buffer.offset++] = (byte) (0x80 | ((c >> 6) & 0x3F));
                buffer.buffer[buffer.offset++] = (byte) (0x80 | (c & 0x3F));
            }

            if (buffer.offset == buffer.buffer.length) {
                buffer = buffer.next = LinkedBuffer.allocate();
            }
        }

        return buffer;
    }
}