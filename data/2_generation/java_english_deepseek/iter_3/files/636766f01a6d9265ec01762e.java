/**
 * Checks if an array of primitive doubles is empty or <code>null</code>.
 * @param array  the array to test
 * @return <code>true</code> if the array is empty or <code>null</code>
 * @since 2.1
 */
public static boolean isEmpty(final double[] array) {
    return array == null || array.length == 0;
}