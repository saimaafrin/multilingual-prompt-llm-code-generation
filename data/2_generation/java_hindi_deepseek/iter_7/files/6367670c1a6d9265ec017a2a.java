import java.util.Objects;

public class ArrayUtils {

    /**
     * <p>एक ऑब्जेक्ट इंटीजर के एरे को प्राइमिटिव में परिवर्तित करता है।</p> 
     * <p>यह विधि <code>null</code> इनपुट एरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  एक <code>Integer</code> एरे, जो <code>null</code> हो सकता है
     * @return एक <code>int</code> एरे, यदि इनपुट एरे <code>null</code> है तो <code>null</code>
     * @throws NullPointerException यदि एरे की सामग्री <code>null</code> है
     */
    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        }
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array element at index " + i + " is null.");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] testArray = {1, 2, 3, 4, 5};
        int[] primitiveArray = toPrimitive(testArray);
        for (int num : primitiveArray) {
            System.out.print(num + " ");
        }
    }
}