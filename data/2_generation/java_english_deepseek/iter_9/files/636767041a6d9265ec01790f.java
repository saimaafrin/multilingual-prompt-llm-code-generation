import java.util.Objects;

public class IntArrayConverter {

    /**
     * <p>Converts an array of primitive ints to objects.</p> <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  an <code>int</code> array
     * @return an <code>Integer</code> array, <code>null</code> if null array input
     */
    public static Integer[] toObject(final int[] array) {
        if (array == null) {
            return null;
        }
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5};
        Integer[] result = toObject(testArray);
        for (Integer num : result) {
            System.out.println(num);
        }
    }
}