import java.util.Arrays;

public class ArrayConverter {
    /** 
     * <p>Converts an array of primitive ints to objects.</p> <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  an <code>int</code> array
     * @return an <code>Integer</code> array, <code>null</code> if null array input
     */
    public static Integer[] toObject(final int[] array) {
        if (array == null) {
            return null;
        }
        return Arrays.stream(array)
                     .boxed()
                     .toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        int[] primitiveArray = {1, 2, 3, 4, 5};
        Integer[] objectArray = toObject(primitiveArray);
        System.out.println(Arrays.toString(objectArray)); // Output: [1, 2, 3, 4, 5]
        
        Integer[] nullArray = toObject(null);
        System.out.println(nullArray); // Output: null
    }
}