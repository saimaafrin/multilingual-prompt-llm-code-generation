public class ByteArrayConverter {

    /** 
     * <p>एक ऑब्जेक्ट बाइट्स के एरे को प्रिमिटिव में परिवर्तित करता है।</p> 
     * <p>यह विधि <code>null</code> इनपुट एरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  एक <code>Byte</code> एरे, यह <code>null</code> हो सकता है
     * @return एक <code>byte</code> एरे, यदि इनपुट एरे <code>null</code> है तो <code>null</code>
     * @throws NullPointerException यदि एरे की सामग्री <code>null</code> है
     */
    public static byte[] toPrimitive(final Byte[] array) {
        if (array == null) {
            return null;
        }
        byte[] primitiveArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array element at index " + i + " is null");
            }
            primitiveArray[i] = array[i];
        }
        return primitiveArray;
    }

    public static void main(String[] args) {
        // Example usage
        Byte[] byteArray = {1, 2, 3, null}; // This will throw NullPointerException
        byte[] primitiveArray = toPrimitive(byteArray);
    }
}