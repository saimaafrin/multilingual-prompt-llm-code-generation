import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StreamReader {

    private final InputStream inputStream;

    public StreamReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 从流中读取 {@code string} 字段值。
     */
    @Override
    public String readString() throws IOException {
        // 读取字符串的长度（假设长度以4字节整数形式存储）
        byte[] lengthBytes = new byte[4];
        int bytesRead = inputStream.read(lengthBytes);
        if (bytesRead != 4) {
            throw new IOException("Failed to read string length");
        }

        int length = (lengthBytes[0] & 0xFF) << 24 |
                     (lengthBytes[1] & 0xFF) << 16 |
                     (lengthBytes[2] & 0xFF) << 8 |
                     (lengthBytes[3] & 0xFF);

        // 读取字符串内容
        byte[] stringBytes = new byte[length];
        bytesRead = inputStream.read(stringBytes);
        if (bytesRead != length) {
            throw new IOException("Failed to read string content");
        }

        return new String(stringBytes, StandardCharsets.UTF_8);
    }
}