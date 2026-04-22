public class BooleanArrayConverter {

    /** 
     * <p>Converts an array of object Booleans to primitives.</p> 
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
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
                throw new NullPointerException("Array content is null at index " + i);
            }
            result[i] = array[i].booleanValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Boolean[] booleanArray = {true, false, null, true};
        try {
            boolean[] primitiveArray = toPrimitive(booleanArray);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}