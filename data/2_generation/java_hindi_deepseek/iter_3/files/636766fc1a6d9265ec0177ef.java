import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    /**
     * एक नई स्ट्रिंग्स की ऐरे लौटाता है जिसमें कोई नल तत्व नहीं है। यह आंतरिक विधि एक्सक्लूड सूचियों (ऐरे और संग्रह) को सामान्य बनाने के लिए उपयोग की जाती है। ध्यान दें कि {@link Arrays#sort(Object[])} एक {@link NullPointerException} फेंकेगा यदि ऐरे का कोई तत्व <code>null</code> है।
     * @param array जाँचने के लिए ऐरे
     * @return दिया गया ऐरे या एक नई ऐरे जिसमें नल नहीं है।
     */
    static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }

        List<String> nonNullList = new ArrayList<>();
        for (Object element : array) {
            if (element != null) {
                nonNullList.add(element.toString());
            }
        }

        return nonNullList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Object[] testArray = { "Hello", null, "World", 123, null };
        String[] result = toNoNullStringArray(testArray);

        for (String str : result) {
            System.out.println(str);
        }
    }
}