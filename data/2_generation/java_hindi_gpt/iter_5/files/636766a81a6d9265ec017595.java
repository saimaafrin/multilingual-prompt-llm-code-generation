import java.util.Arrays;

class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[2]; // Initial capacity
        this.size = 0;
    }

    public void put(byte value) {
        if (size == data.length) {
            resize();
        }
        data[size++] = value;
    }

    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public byte[] toArray() {
        return Arrays.copyOf(data, size);
    }
}

public class Main {
    /**
     * इस बाइट वेक्टर में दो बाइट डालता है। यदि आवश्यक हो तो बाइट वेक्टर स्वचालित रूप से बड़ा हो जाता है।
     * @param byteValue1 एक बाइट।
     * @param byteValue2 एक और बाइट।
     * @return यह बाइट वेक्टर।
     */
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        ByteVector byteVector = new ByteVector();
        byteVector.put((byte) byteValue1);
        byteVector.put((byte) byteValue2);
        return byteVector;
    }

    public static void main(String[] args) {
        Main main = new Main();
        ByteVector result = main.put11(10, 20);
        System.out.println(Arrays.toString(result.toArray()));
    }
}