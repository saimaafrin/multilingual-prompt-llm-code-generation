import java.io.IOException;

public class ByteReader {
    private byte[] buffer;
    private int position;
    private int limit;
    
    public ByteReader(byte[] buffer) {
        this.buffer = buffer;
        this.position = 0;
        this.limit = buffer.length;
    }

    /**
     * 从<code>buffer</code>中读取一个字节，并在必要时进行填充。
     * @return 输入流中的下一个字节。
     * @throws IOException 如果没有更多数据可用。
     */
    public byte readByte() throws IOException {
        if (position >= limit) {
            throw new IOException("No more data available");
        }
        return buffer[position++];
    }
}