public class CharacterUtils {

    /**
     * Converts an array of object Characters to primitives.
     * This method returns {@code null} for a {@code null} input array.
     *
     * @param array  a {@code Character} array, may be {@code null}
     * @return a {@code char} array, {@code null} if null array input
     * @throws NullPointerException if array content is {@code null}
     */
    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        }
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array element at index " + i + " is null.");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Character[] testArray = {'a', 'b', 'c'};
        char[] primitiveArray = toPrimitive(testArray);
        System.out.println(java.util.Arrays.toString(primitiveArray)); // Output: [a, b, c]
    }
}