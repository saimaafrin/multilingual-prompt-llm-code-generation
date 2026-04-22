import io.protostuff.LinkedBuffer;
import io.protostuff.Output;
import io.protostuff.WriteSession;

import java.nio.charset.StandardCharsets;

public class UTF8Writer {

    /**
     * 将字符串中的 UTF-8 编码字节写入 {@link LinkedBuffer}。
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null) {
            return lb;
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        int length = utf8Bytes.length;

        // Ensure there is enough space in the buffer
        if (lb.offset + length > lb.buffer.length) {
            lb = LinkedBuffer.allocate(lb.nextBufferSize, lb);
        }

        // Write the length of the UTF-8 bytes
        session.writeVarInt32(length, lb);

        // Write the UTF-8 bytes
        System.arraycopy(utf8Bytes, 0, lb.buffer, lb.offset, length);
        lb.offset += length;

        return lb;
    }
}