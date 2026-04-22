import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int count;
    
    /**
     * 扩展此字节向量，以便能够接收 'size' 个额外的字节。
     * @param size 此字节向量应该能够接收的额外字节数。
     */
    private void enlarge(final int size) {
        int length = data.length;
        int newLength = length + size;
        
        // 如果新长度超过最大数组大小,则设置为最大值
        if (newLength > Integer.MAX_VALUE - 8) {
            newLength = Integer.MAX_VALUE - 8;
        }
        
        // 创建新数组并复制原有数据
        data = Arrays.copyOf(data, newLength);
    }
}