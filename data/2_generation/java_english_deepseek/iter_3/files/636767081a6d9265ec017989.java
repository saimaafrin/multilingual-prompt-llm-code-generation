public class BooleanArrayConverter {

    /**
     * <p>Converts an array of object Booleans to primitives.</p> <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  a <code>Boolean</code> array, may be <code>null</code>
     * @return a <code>boolean</code> array, <code>null</code> if null array input
     * @throws NullPointerException if array content is <code>null</code>
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
        Boolean[] inputArray = { true, false, true };
        boolean[] primitiveArray = toPrimitive(inputArray);
        for (boolean b : primitiveArray) {
            System.out.println(b);
        }
    }
}