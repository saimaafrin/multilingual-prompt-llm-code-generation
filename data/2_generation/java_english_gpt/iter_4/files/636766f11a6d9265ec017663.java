public class ArrayLengthChecker {

    /** 
     * <p>Checks whether two arrays are the same length, treating <code>null</code> arrays as length <code>0</code>.</p>
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating<code>null</code> as an empty array
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