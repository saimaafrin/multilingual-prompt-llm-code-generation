public class ArrayUtils {

    /**
     * <p>Checks whether two arrays are the same length, treating <code>null</code> arrays as length <code>0</code>.</p>
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating<code>null</code> as an empty array
     */
    public static boolean isSameLength(final byte[] array1, final byte[] array2) {
        int length1 = (array1 == null) ? 0 : array1.length;
        int length2 = (array2 == null) ? 0 : array2.length;
        return length1 == length2;
    }

    public static void main(String[] args) {
        byte[] array1 = {1, 2, 3};
        byte[] array2 = {4, 5, 6};
        byte[] array3 = null;
        byte[] array4 = {7, 8};

        System.out.println(isSameLength(array1, array2)); // true
        System.out.println(isSameLength(array1, array3)); // false
        System.out.println(isSameLength(array3, array4)); // false
    }
}