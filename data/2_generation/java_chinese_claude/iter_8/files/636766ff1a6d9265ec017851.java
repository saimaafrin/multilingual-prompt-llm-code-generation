import java.nio.ByteBuffer;

public class ByteSearcher {
    private ByteBuffer buffer;
    
    public ByteSearcher(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * 从指定的 <code>position</code> 开始，搜索 <code>buffer</code> 中指定值的字节。
     * @param value 要查找的值。
     * @param pos   搜索的起始位置。
     * @return 找到的字节位置，从 <code>buffer</code> 开始计数，如果未找到则返回 <code>-1</code>。
     */
    protected int findByte(byte value, int pos) {
        // 保存原始position
        int originalPosition = buffer.position();
        
        try {
            // 设置搜索起始位置
            buffer.position(pos);
            
            // 搜索直到找到匹配值或到达buffer末尾
            while (buffer.hasRemaining()) {
                if (buffer.get() == value) {
                    return buffer.position() - 1;
                }
            }
            
            // 未找到匹配值
            return -1;
            
        } finally {
            // 恢复原始position
            buffer.position(originalPosition);
        }
    }
}