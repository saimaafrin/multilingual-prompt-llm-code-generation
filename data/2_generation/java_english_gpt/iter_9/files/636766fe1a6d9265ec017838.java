public class CharacterArrayConverter {

    /** 
     * <p>Converts an array of object Characters to primitives.</p> 
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  a <code>Character</code> array, may be <code>null</code>
     * @return a <code>char</code> array, <code>null</code> if null array input
     * @throws NullPointerException if array content is <code>null</code>
     */
    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        }
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array content is null at index " + i);
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        Character[] charArray = { 'a', 'b', 'c' };
        char[] primitiveArray = toPrimitive(charArray);
        for (char c : primitiveArray) {
            System.out.print(c + " ");
        }
    }
}