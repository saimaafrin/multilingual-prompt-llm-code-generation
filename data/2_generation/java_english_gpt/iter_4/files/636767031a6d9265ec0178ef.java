import java.lang.reflect.Array;

public class ArrayUtils {

    /** 
     * Returns a copy of the given array of size 1 greater than the argument. The last value of the array is left to the default value.
     * @param array The array to copy, must not be <code>null</code>.
     * @param newArrayComponentType If <code>array</code> is <code>null</code>, create a size 1 array of this type.
     * @return A new copy of the array of size 1 greater than the input.
     */
    private static Object copyArrayGrow1(final Object array, final Class<?> newArrayComponentType) {
        if (array == null) {
            return Array.newInstance(newArrayComponentType, 1);
        }
        
        int length = Array.getLength(array);
        Object newArray = Array.newInstance(array.getClass().getComponentType(), length + 1);
        
        System.arraycopy(array, 0, newArray, 0, length);
        
        return newArray;
    }

    public static void main(String[] args) {
        // Example usage
        Integer[] originalArray = {1, 2, 3};
        Object newArray = copyArrayGrow1(originalArray, Integer.class);
        
        // Print the new array
        for (int i = 0; i < Array.getLength(newArray); i++) {
            System.out.println(Array.get(newArray, i));
        }
    }
}