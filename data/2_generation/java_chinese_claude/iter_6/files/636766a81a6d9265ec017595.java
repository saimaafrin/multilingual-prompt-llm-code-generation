import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    
    public ByteVector() {
        data = new byte[64]; // Default initial capacity
    }
    
    /**
     * 将两个字节放入此字节向量。如有必要，字节向量会自动扩展。
     * @param byteValue1 一个字节。
     * @param byteValue2 另一个字节。
     * @return 此字节向量。
     */
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        if (length + 2 > data.length) {
            // Double array size if needed
            int newCapacity = Math.max(2 * data.length, length + 2);
            data = Arrays.copyOf(data, newCapacity);
        }
        
        data[length++] = (byte) byteValue1;
        data[length++] = (byte) byteValue2;
        
        return this;
    }
}