import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    
    public ByteVector() {
        data = new byte[64]; // Initial capacity
    }
    
    /** 
     * 将一个字节数组放入此字节向量中。如有必要，字节向量会自动扩展。
     * @param byteArrayValue 字节数组。如果为 {@literal null}，则在字节向量中添加 {@code byteLength} 个空字节。
     * @param byteOffset     要复制的 byteArrayValue 的第一个字节的索引。
     * @param byteLength     要复制的 byteArrayValue 的字节数。
     * @return 此字节向量。
     */
    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        // Ensure capacity
        int requiredLength = length + byteLength;
        if (requiredLength > data.length) {
            int newCapacity = Math.max(2 * data.length, requiredLength);
            data = Arrays.copyOf(data, newCapacity);
        }
        
        // Copy bytes
        if (byteArrayValue != null) {
            System.arraycopy(byteArrayValue, byteOffset, data, length, byteLength);
        } else {
            // Fill with zeros if input array is null
            Arrays.fill(data, length, length + byteLength, (byte) 0);
        }
        
        length += byteLength;
        return this;
    }
    
    // Getter for the current length
    public int getLength() {
        return length;
    }
    
    // Getter for the internal byte array
    public byte[] getData() {
        return Arrays.copyOf(data, length);
    }
}