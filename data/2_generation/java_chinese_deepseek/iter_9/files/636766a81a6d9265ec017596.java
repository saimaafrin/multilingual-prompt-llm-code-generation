import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // 初始容量
        this.size = 0;
    }

    public ByteVector putInt(final int intValue) {
        ensureCapacity(size + 4); // 确保有足够的空间存放4个字节的整数

        // 将整数按大端序写入字节数组
        data[size++] = (byte) (intValue >> 24);
        data[size++] = (byte) (intValue >> 16);
        data[size++] = (byte) (intValue >> 8);
        data[size++] = (byte) intValue;

        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = data.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }

    public int size() {
        return size;
    }
}