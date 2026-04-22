import java.lang.reflect.Array;

public class ArrayUtils {

    /**
     * दिए गए ऐरे की एक प्रति लौटाता है, जो तर्क से 1 बड़ा होता है। ऐरे का अंतिम मान डिफ़ॉल्ट मान पर छोड़ दिया जाता है।
     * @param array कॉपी करने के लिए ऐरे, <code>null</code> नहीं होना चाहिए।
     * @param newArrayComponentType यदि <code>array</code> <code>null</code> है, तो इस प्रकार का आकार 1 का ऐरे बनाएं।
     * @return इनपुट से 1 बड़ा आकार का ऐरे की एक नई प्रति।
     */
    private static Object copyArrayGrow1(final Object array, final Class<?> newArrayComponentType) {
        if (array == null) {
            return Array.newInstance(newArrayComponentType, 1);
        }

        int length = Array.getLength(array);
        Object newArray = Array.newInstance(array.getClass().getComponentType(), length + 1);
        System.arraycopy(array, 0, newArray, 0, length);
        return newArray;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3};
        int[] newArray = (int[]) copyArrayGrow1(originalArray, int.class);

        for (int i : newArray) {
            System.out.print(i + " ");
        }
    }
}