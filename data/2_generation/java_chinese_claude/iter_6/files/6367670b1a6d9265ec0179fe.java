import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStream extends OutputStream {
    
    protected byte[] buf;
    protected int count;
    
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
        
        // 确保缓冲区容量足够
        ensureCapacity(count + b.length);
        
        // 将字节数组复制到缓冲区
        System.arraycopy(b, 0, buf, count, b.length);
        count += b.length;
    }
    
    private void ensureCapacity(int minCapacity) {
        // 如果需要的容量大于当前缓冲区大小
        if (minCapacity > buf.length) {
            // 计算新的缓冲区大小(当前大小的2倍)
            int newCapacity = Math.max(buf.length << 1, minCapacity);
            // 创建新的缓冲区并复制数据
            byte[] newBuf = new byte[newCapacity];
            System.arraycopy(buf, 0, newBuf, 0, count);
            buf = newBuf;
        }
    }
}