import java.util.Objects;

public class ArrayConverter {

    /**
     * <p>प्राथमिक शॉर्ट्स के एक एरे को ऑब्जेक्ट्स में परिवर्तित करता है।</p> <p>यह विधि <code>null</code> इनपुट एरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  एक <code>short</code> एरे
     * @return एक <code>Short</code> एरे, <code>null</code> यदि इनपुट एरे null है
     */
    public static Short[] toObject(final short[] array) {
        if (array == null) {
            return null;
        }
        Short[] result = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        short[] primitiveArray = {1, 2, 3, 4, 5};
        Short[] objectArray = toObject(primitiveArray);
        for (Short s : objectArray) {
            System.out.println(s);
        }
    }
}