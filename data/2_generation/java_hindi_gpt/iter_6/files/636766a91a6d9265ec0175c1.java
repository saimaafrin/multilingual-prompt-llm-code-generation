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
        currentSize = newSize;
    }
}