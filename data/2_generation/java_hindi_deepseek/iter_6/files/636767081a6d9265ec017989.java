import java.util.Objects;

public class BooleanArrayConverter {

    /**
     * <p>एक ऑब्जेक्ट बूलियन के ऐरे को प्राइमिटिव में परिवर्तित करता है।</p>
     * <p>यह विधि <code>null</code> इनपुट ऐरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  एक <code>Boolean</code> ऐरे, यह <code>null</code> हो सकता है
     * @return एक <code>boolean</code> ऐरे, यदि इनपुट ऐरे <code>null</code> है तो <code>null</code>
     * @throws NullPointerException यदि ऐरे की सामग्री <code>null</code> है
     */
    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        }
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Objects.requireNonNull(array[i], "Array element cannot be null");
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        Boolean[] booleanArray = {true, false, true};
        boolean[] primitiveArray = toPrimitive(booleanArray);
        for (boolean b : primitiveArray) {
            System.out.println(b);
        }
    }
}