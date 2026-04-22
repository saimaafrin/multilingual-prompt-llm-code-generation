import java.util.Arrays;

public class Main {
    /**
     * एक नई स्ट्रिंग्स की ऐरे लौटाता है जिसमें कोई नल तत्व नहीं है। यह आंतरिक विधि एक्सक्लूड सूचियों (ऐरे और संग्रह) को सामान्य बनाने के लिए उपयोग की जाती है। ध्यान दें कि {@link Arrays#sort(Object[])} एक {@link NullPointerException} फेंकेगा यदि ऐरे का कोई तत्व <code>null</code> है।
     * @param array जाँचने के लिए ऐरे
     * @return दिया गया ऐरे या एक नई ऐरे जिसमें नल नहीं है।
     */
    static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }
        return Arrays.stream(array)
                     .filter(obj -> obj != null)
                     .map(Object::toString)
                     .toArray(String[]::new);
    }

    public static void main(String[] args) {
        Object[] inputArray = { "Hello", null, "World", null, "!" };
        String[] resultArray = toNoNullStringArray(inputArray);
        System.out.println(Arrays.toString(resultArray)); // Output: [Hello, World, !]
    }
}