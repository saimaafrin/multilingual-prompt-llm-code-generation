public class ByteFinder {
    
    /**
     * 从指定的 <code>position</code> 开始，搜索 <code>buffer</code> 中指定值的字节。
     * @param value 要查找的值。
     * @param pos   搜索的起始位置。
     * @return 找到的字节位置，从 <code>buffer</code> 开始计数，如果未找到则返回 <code>-1</code>。
     */
    protected int findByte(byte value, int pos) {
        byte[] buffer = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 示例缓冲区
        if (pos < 0 || pos >= buffer.length) {
            throw new IndexOutOfBoundsException("起始位置超出范围");
        }
        
        for (int i = pos; i < buffer.length; i++) {
            if (buffer[i] == value) {
                return i; // 找到值，返回位置
            }
        }
        return -1; // 未找到值
    }

    public static void main(String[] args) {
        ByteFinder finder = new ByteFinder();
        int position = finder.findByte((byte) 5, 0);
        System.out.println("找到的字节位置: " + position); // 输出: 找到的字节位置: 4
    }
}