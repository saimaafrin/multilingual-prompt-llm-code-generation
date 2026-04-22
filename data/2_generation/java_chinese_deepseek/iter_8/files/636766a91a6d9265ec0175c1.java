import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;
    private int size;

    public ByteVector(int initialCapacity) {
        this.data = new byte[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    private void enlarge(final int size) {
        int newCapacity = capacity + size;
        if (newCapacity < 0) { // 处理溢出
            throw new OutOfMemoryError("Required array size too large");
        }
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    public void add(byte b) {
        if (size == capacity) {
            enlarge(1); // 每次增加1个字节
        }
        data[size++] = b;
    }

    public byte[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public static void main(String[] args) {
        ByteVector vector = new ByteVector(2);
        vector.add((byte) 1);
        vector.add((byte) 2);
        vector.add((byte) 3); // 触发扩容
        System.out.println(Arrays.toString(vector.toArray()));
    }
}