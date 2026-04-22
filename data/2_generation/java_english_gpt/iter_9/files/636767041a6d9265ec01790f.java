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
        
        Integer[] objectArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = Integer.valueOf(array[i]);
        }
        return objectArray;
    }

    public static void main(String[] args) {
        int[] primitiveArray = {1, 2, 3, 4, 5};
        Integer[] objectArray = toObject(primitiveArray);
        
        // Print the result
        for (Integer num : objectArray) {
            System.out.print(num + " ");
        }
    }
}