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
     * @param byteOffset byteArrayValue का पहला बाइट का अनुक्रमांक जो कॉपी किया जाना चाहिए।
     * @param byteLength byteArrayValue के बाइट्स की संख्या जो कॉपी की जानी चाहिए।
     * @return यह बाइट वेक्टर।
     */
    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteArrayValue == null || byteLength <= 0) {
            return this;
        }
        
        ensureCapacity(size + byteLength);
        
        System.arraycopy(byteArrayValue, byteOffset, data, size, byteLength);
        size += byteLength;
        
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - data.length > 0) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public int size() {
        return size;
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }
}