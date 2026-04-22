import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    /** 
     * इस बाइट वेक्टर में बाइट्स का एक एरे डालता है। यदि आवश्यक हो तो बाइट वेक्टर को स्वचालित रूप से बढ़ा दिया जाता है।
     * @param byteArrayValue बाइट्स का एक एरे। {@code byteLength} नल बाइट्स डालने के लिए {@literal null} हो सकता है।
     * @param byteOffset     byteArrayValue का पहला बाइट का इंडेक्स जो कॉपी किया जाना चाहिए।
     * @param byteLength     byteArrayValue के बाइट्स की संख्या जो कॉपी की जानी चाहिए।
     * @return यह बाइट वेक्टर।
     */
    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteArrayValue == null || byteLength <= 0) {
            return this;
        }
        
        // Ensure the byteOffset is within bounds
        if (byteOffset < 0 || byteOffset >= byteArrayValue.length) {
            throw new IndexOutOfBoundsException("byteOffset is out of bounds");
        }
        
        // Ensure the byteLength does not exceed the array bounds
        if (byteOffset + byteLength > byteArrayValue.length) {
            throw new IndexOutOfBoundsException("byteLength exceeds array bounds");
        }

        // Resize the array if necessary
        ensureCapacity(size + byteLength);

        // Copy the bytes into the vector
        System.arraycopy(byteArrayValue, byteOffset, data, size, byteLength);
        size += byteLength;

        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}