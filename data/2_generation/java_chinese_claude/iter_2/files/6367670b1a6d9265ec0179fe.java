import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    private OutputStream out;

    public CustomOutputStream(OutputStream out) {
        this.out = out;
    }

    /**
     * 将指定字节数组中的 <code>b.length</code> 字节写入此输出流。
     * @param b 要写入的字节数组。
     * @exception IOException 如果发生错误。
     */
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        
        // 将整个字节数组写入输出流
        out.write(b, 0, b.length);
        
        // 刷新缓冲区确保写入
        out.flush();
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}