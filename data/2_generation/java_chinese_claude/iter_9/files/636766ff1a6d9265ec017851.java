import java.nio.ByteBuffer;

public class ByteSearcher {
    private ByteBuffer buffer;
    
    /**
     * 从指定的 <code>position</code> 开始，搜索 <code>buffer</code> 中指定值的字节。
     * @param value 要查找的值。
     * @param pos   搜索的起始位置。
     * @return 找到的字节位置，从 <code>buffer</code> 开始计数，如果未找到则返回 <code>-1</code>。
     */
    protected int findByte(byte value, int pos) {
        if (buffer == null || pos >= buffer.limit()) {
            return -1;
        }
        
        // Save the original position
        int originalPosition = buffer.position();
        
        try {
            // Set position to start searching from
            buffer.position(pos);
            
            // Search for the byte
            while (buffer.hasRemaining()) {
                if (buffer.get() == value) {
                    return buffer.position() - 1;
                }
            }
            
            return -1;
        } finally {
            // Restore original position
            buffer.position(originalPosition);
        }
    }
}