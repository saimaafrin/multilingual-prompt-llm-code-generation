public class ArrayCloner {
    
    /** 
     * <p>Clones an array returning a typecast result and handling <code>null</code>.</p> 
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  the array to clone, may be <code>null</code>
     * @return the cloned array, <code>null</code> if <code>null</code> input
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        char[] clonedArray = new char[array.length];
        System.arraycopy(array, 0, clonedArray, 0, array.length);
        return clonedArray;
    }

    public static void main(String[] args) {
        char[] original = {'a', 'b', 'c'};
        char[] cloned = clone(original);
        
        // Print original and cloned arrays
        System.out.println("Original: " + java.util.Arrays.toString(original));
        System.out.println("Cloned: " + java.util.Arrays.toString(cloned));
        
        // Test with null
        char[] nullArray = clone(null);
        System.out.println("Null input: " + nullArray);
    }
}