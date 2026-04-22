import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int position;
    private int size;
    
    /**
     * 清空并用提供的字节流填充此 {@code ClassFileBuffer} 的缓冲区。读取指针重置为字节数组的起始位置。
     */
    public void readFrom(final InputStream in) throws IOException {
        // 初始化缓冲区大小为8KB
        if (buffer == null) {
            buffer = new byte[8192];
        }
        
        // 重置位置指针
        position = 0;
        size = 0;
        
        // 读取输入流到缓冲区
        int read;
        while ((read = in.read(buffer, size, buffer.length - size)) != -1) {
            size += read;
            
            // 如果缓冲区已满,扩容为原来的2倍
            if (size == buffer.length) {
                byte[] newBuffer = new byte[buffer.length * 2];
                System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
                buffer = newBuffer;
            }
        }
    }
}