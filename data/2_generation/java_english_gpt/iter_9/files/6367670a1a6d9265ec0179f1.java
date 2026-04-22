public class ShortArrayConverter {

    /** 
     * <p>Converts an array of primitive shorts to objects.</p> <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  a <code>short</code> array
     * @return a <code>Short</code> array, <code>null</code> if null array input
     */
    public static Short[] toObject(final short[] array) {
        if (array == null) {
            return null;
        }
        Short[] result = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i]; // Autoboxing from short to Short
        }
        return result;
    }

    public static void main(String[] args) {
        short[] primitiveArray = {1, 2, 3, 4, 5};
        Short[] objectArray = toObject(primitiveArray);
        for (Short s : objectArray) {
            System.out.println(s);
        }
    }
}