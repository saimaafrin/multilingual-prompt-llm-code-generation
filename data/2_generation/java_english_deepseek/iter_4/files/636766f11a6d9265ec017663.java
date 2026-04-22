public class ArrayUtils {

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
        double[] arr1 = {1.0, 2.0, 3.0};
        double[] arr2 = {4.0, 5.0, 6.0};
        double[] arr3 = null;
        double[] arr4 = {7.0};

        System.out.println(isSameLength(arr1, arr2)); // true
        System.out.println(isSameLength(arr1, arr3)); // false
        System.out.println(isSameLength(arr3, arr4)); // false
    }
}