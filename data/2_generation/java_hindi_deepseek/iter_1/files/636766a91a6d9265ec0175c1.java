import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;

    public ByteVector(int initialCapacity) {
        this.data = new byte[initialCapacity];
        this.capacity = initialCapacity;
    }

    /**
     * इस बाइट वेक्टर को बड़ा करता है ताकि यह 'size' और बाइट्स प्राप्त कर सके।
     * @param size अतिरिक्त बाइट्स की संख्या जो इस बाइट वेक्टर को प्राप्त करनी चाहिए।
     */
    private void enlarge(final int size) {
        int newCapacity = capacity + size;
        byte[] newData = Arrays.copyOf(data, newCapacity);
        this.data = newData;
        this.capacity = newCapacity;
    }

    // Example usage
    public static void main(String[] args) {
        ByteVector vector = new ByteVector(10);
        vector.enlarge(5);
        System.out.println("New capacity: " + vector.capacity);
    }
}