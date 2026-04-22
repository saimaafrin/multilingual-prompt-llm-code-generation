import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    public ByteVector put11(final int byteValue1, final int byteValue2) {
        ensureCapacity(size + 2);
        data[size++] = (byte) byteValue1;
        data[size++] = (byte) byteValue2;
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

    // For testing purposes
    public byte[] getData() {
        return Arrays.copyOf(data, size);
    }

    public static void main(String[] args) {
        ByteVector vector = new ByteVector();
        vector.put11(0x01, 0x02);
        byte[] result = vector.getData();
        System.out.println(Arrays.toString(result)); // Output: [1, 2]
    }
}