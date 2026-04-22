import java.util.Objects;

public class ArrayConverter {

    /** 
     * <p>Converts an array of object Integers to primitives.</p> <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  a <code>Integer</code> array, may be <code>null</code>
     * @return an <code>int</code> array, <code>null</code> if null array input
     * @throws NullPointerException if array content is <code>null</code>
     */
    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        }
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array content is null at index " + i);
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, null};
        try {
            int[] primitiveArray = toPrimitive(integerArray);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}