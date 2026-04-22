public class ArrayUtils {
    
    /** 
     * <p>जांचता है कि क्या प्राइमिटिव डबल्स का एक एरे खाली है या <code>null</code> है।</p>
     * @param array  परीक्षण के लिए एरे
     * @return <code>true</code> यदि एरे खाली है या <code>null</code> है
     * @since 2.1
     */
    public static boolean isEmpty(final double[] array) {
        return array == null || array.length == 0;
    }

    public static void main(String[] args) {
        // Test cases
        double[] array1 = null;
        double[] array2 = {};
        double[] array3 = {1.0, 2.0, 3.0};

        System.out.println(isEmpty(array1)); // true
        System.out.println(isEmpty(array2)); // true
        System.out.println(isEmpty(array3)); // false
    }
}