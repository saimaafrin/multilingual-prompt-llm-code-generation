import java.util.Arrays;

public class ArrayUtils {

    /**
     * <p>एक ऐरे को क्लोन करता है और टाइपकास्ट परिणाम लौटाता है और <code>null</code> को संभालता है।</p>
     * <p>यह विधि <code>null</code> इनपुट ऐरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  क्लोन करने के लिए ऐरे, यह <code>null</code> हो सकता है
     * @return क्लोन किया गया ऐरे, <code>null</code> यदि <code>null</code> इनपुट हो
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        return Arrays.copyOf(array, array.length);
    }

    public static void main(String[] args) {
        char[] originalArray = {'a', 'b', 'c'};
        char[] clonedArray = clone(originalArray);
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Cloned Array: " + Arrays.toString(clonedArray));

        char[] nullArray = null;
        char[] clonedNullArray = clone(nullArray);
        System.out.println("Cloned Null Array: " + clonedNullArray);
    }
}