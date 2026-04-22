import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // initial capacity
        this.size = 0;
    }

    /** 
     * Puts an int into this byte vector. The byte vector is automatically enlarged if necessary.
     * @param intValue an int.
     * @return this byte vector.
     */
    public ByteVector putInt(final int intValue) {
        ensureCapacity(size + 4); // an int takes 4 bytes
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

    public static void main(String[] args) {
        ByteVector byteVector = new ByteVector();
        byteVector.putInt(123456);
        System.out.println(Arrays.toString(byteVector.toByteArray()));
    }
}