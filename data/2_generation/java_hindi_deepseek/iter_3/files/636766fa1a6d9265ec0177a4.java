/**
 * <p>प्राथमिक डबल्स के एक एरे को ऑब्जेक्ट्स में परिवर्तित करता है।</p> <p>यह विधि <code>null</code> इनपुट एरे के लिए <code>null</code> लौटाती है।</p>
 * @param array  एक <code>double</code> एरे
 * @return एक <code>Double</code> एरे, <code>null</code> यदि इनपुट एरे null है
 */
public static Double[] toObject(final double[] array) {
    if (array == null) {
        return null;
    }
    Double[] result = new Double[array.length];
    for (int i = 0; i < array.length; i++) {
        result[i] = array[i];
    }
    return result;
}