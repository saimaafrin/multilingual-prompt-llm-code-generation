public class BooleanUtils {

    /**
     * Converts an array of object Booleans to primitives.
     * This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Boolean} array, may be {@code null}
     * @return a {@code boolean} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        }
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array element at index " + i + " is null.");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        Boolean[] array = {true, false, true};
        boolean[] primitiveArray = toPrimitive(array);
        for (boolean b : primitiveArray) {
            System.out.println(b);
        }
    }
}