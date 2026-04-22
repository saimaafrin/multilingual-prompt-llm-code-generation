import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    /**
     * इस बाइट वेक्टर में एक int डालता है। यदि आवश्यक हो तो बाइट वेक्टर को स्वचालित रूप से बढ़ा दिया जाता है।
     * @param intValue एक int।
     * @return यह बाइट वेक्टर।
     */
    public ByteVector putInt(final int intValue) {
        ensureCapacity(size + Integer.BYTES);
        for (int i = 0; i < Integer.BYTES; i++) {
            data[size++] = (byte) (intValue >> (i * 8));
        }
        return this;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, requiredCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public byte[] getData() {
        return Arrays.copyOf(data, size);
    }

    public int getSize() {
        return size;
    }
}