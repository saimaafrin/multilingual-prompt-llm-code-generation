/**
 * Checks whether two arrays are the same length, treating null arrays as length 0.
 * @param array1 the first array, may be null
 * @param array2 the second array, may be null
 * @return true if length of arrays matches, treating null as an empty array
 */
public static boolean isSameLength(final double[] array1, final double[] array2) {
    int length1 = (array1 == null) ? 0 : array1.length;
    int length2 = (array2 == null) ? 0 : array2.length;
    return length1 == length2;
}