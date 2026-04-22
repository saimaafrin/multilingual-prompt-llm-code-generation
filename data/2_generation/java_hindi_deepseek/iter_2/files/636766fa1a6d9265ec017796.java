import java.util.Objects;

public class BooleanArrayConverter {

    /**
     * <p>प्राथमिक बूलियन के एक ऐरे को ऑब्जेक्ट में परिवर्तित करता है।</p> <p>यह विधि <code>null</code> इनपुट ऐरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  एक <code>boolean</code> ऐरे
     * @return एक <code>Boolean</code> ऐरे, <code>null</code> यदि इनपुट ऐरे null है
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        }
        Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        boolean[] primitiveArray = {true, false, true};
        Boolean[] objectArray = toObject(primitiveArray);
        for (Boolean b : objectArray) {
            System.out.println(b);
        }
    }
}