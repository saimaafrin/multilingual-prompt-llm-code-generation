import java.util.Objects;

public class CharacterArrayConverter {

    /**
     * <p>एक ऑब्जेक्ट कैरेक्टर्स के एरे को प्रिमिटिव्स में परिवर्तित करता है।</p>
     * <p>यह विधि <code>null</code> इनपुट एरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  एक <code>Character</code> एरे, यह <code>null</code> हो सकता है
     * @return एक <code>char</code> एरे, यदि इनपुट एरे <code>null</code> है तो <code>null</code>
     * @throws NullPointerException यदि एरे की सामग्री <code>null</code> है
     */
    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        }
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Objects.requireNonNull(array[i], "Array element cannot be null");
        }
        return result;
    }

    public static void main(String[] args) {
        Character[] inputArray = {'a', 'b', 'c'};
        char[] outputArray = toPrimitive(inputArray);
        for (char c : outputArray) {
            System.out.print(c + " ");
        }
    }
}