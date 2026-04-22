public class ArrayLengthChecker {
    
    /** 
     * <p>जांचता है कि क्या दो ऐरे एक ही लंबाई के हैं, <code>null</code> ऐरे को लंबाई <code>0</code> के रूप में मानते हुए।</p>
     * @param array1 पहला ऐरे, <code>null</code> हो सकता है
     * @param array2 दूसरा ऐरे, <code>null</code> हो सकता है
     * @return <code>true</code> यदि ऐरे की लंबाई मेल खाती है, <code>null</code> को एक खाली ऐरे के रूप में मानते हुए
     */
    public static boolean isSameLength(final double[] array1, final double[] array2) {
        int length1 = (array1 == null) ? 0 : array1.length;
        int length2 = (array2 == null) ? 0 : array2.length;
        return length1 == length2;
    }

    public static void main(String[] args) {
        double[] array1 = {1.0, 2.0, 3.0};
        double[] array2 = {4.0, 5.0, 6.0};
        double[] array3 = null;

        System.out.println(isSameLength(array1, array2)); // true
        System.out.println(isSameLength(array1, array3)); // false
        System.out.println(isSameLength(array3, array3)); // true
    }
}