import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int currentSize;

    public ByteVector(int initialCapacity) {
        data = new byte[initialCapacity];
        currentSize = 0;
    }

    /**
     * इस बाइट वेक्टर को बड़ा करता है ताकि यह 'size' और बाइट्स प्राप्त कर सके।
     * @param size अतिरिक्त बाइट्स की संख्या जो इस बाइट वेक्टर को प्राप्त करनी चाहिए।
     */
    private void enlarge(final int size) {
        int newSize = currentSize + size;
        data = Arrays.copyOf(data, newSize);
    }

    // Additional methods for demonstration purposes
    public void add(byte b) {
        if (currentSize == data.length) {
            enlarge(1);
        }
        data[currentSize++] = b;
    }

    public byte get(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + currentSize);
        }
        return data[index];
    }

    public int size() {
        return currentSize;
    }
}