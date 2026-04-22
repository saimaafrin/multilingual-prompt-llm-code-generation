import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // initial capacity
        this.size = 0;
    }

    /** 
     * Puts two bytes into this byte vector. The byte vector is automatically enlarged if necessary.
     * @param byteValue1 a byte.
     * @param byteValue2 another byte.
     * @return this byte vector.
     */
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        ensureCapacity(size + 2);
        data[size++] = (byte) byteValue1;
        data[size++] = (byte) byteValue2;
        return this;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, requiredCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public byte[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public static void main(String[] args) {
        ByteVector byteVector = new ByteVector();
        byteVector.put11(1, 2);
        byteVector.put11(3, 4);
        System.out.println(Arrays.toString(byteVector.toArray())); // Output: [1, 2, 3, 4]
    }
}