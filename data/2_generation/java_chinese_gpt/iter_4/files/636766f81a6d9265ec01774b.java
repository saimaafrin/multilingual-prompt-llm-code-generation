import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;
    private int currentByte;
    private boolean endOfStream = false;

    public ByteReader(InputStream buffer) {
        this.buffer = buffer;
    }

    /**
     * 从<code>buffer</code>中读取一个字节，并在必要时进行填充。
     * @return 输入流中的下一个字节。
     * @throws IOException 如果没有更多数据可用。
     */
    public byte readByte() throws IOException {
        if (endOfStream) {
            throw new IOException("没有更多数据可用。");
        }

        currentByte = buffer.read();
        if (currentByte == -1) {
            endOfStream = true;
            throw new IOException("没有更多数据可用。");
        }
        return (byte) currentByte;
    }
}