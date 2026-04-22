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
        
        for (int i = 0; i < length; i++) {
            Array.set(newArray, i, Array.get(array, i));
        }
        
        return newArray;
    }

    public static void main(String[] args) {
        // Example usage
        Integer[] originalArray = {1, 2, 3};
        Object newArray = copyArrayGrow1(originalArray, Integer.class);
        
        // Print the new array
        for (int i = 0; i < Array.getLength(newArray); i++) {
            System.out.println(Array.get(newArray, i));
        }
    }
}