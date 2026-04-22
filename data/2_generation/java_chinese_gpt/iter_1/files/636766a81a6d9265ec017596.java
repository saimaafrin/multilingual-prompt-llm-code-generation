import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    /** 
     * 将一个整数放入此字节向量中。如有必要，字节向量会自动扩展。
     * @param intValue 一个整数。
     * @return 此字节向量。
     */
    public ByteVector putInt(final int intValue) {
        ensureCapacity(size + 4); // An int takes 4 bytes
        data[size++] = (byte) (intValue >> 24);
        data[size++] = (byte) (intValue >> 16);
        data[size++] = (byte) (intValue >> 8);
        data[size++] = (byte) intValue;
        return this;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, requiredCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }
}