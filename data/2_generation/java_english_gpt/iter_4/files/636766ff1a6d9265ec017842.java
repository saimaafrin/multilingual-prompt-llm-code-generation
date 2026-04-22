import java.util.Objects;

public class ArrayConverter {

    /** 
     * <p>Converts an array of object Doubles to primitives.</p> <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  a <code>Double</code> array, may be <code>null</code>
     * @return a <code>double</code> array, <code>null</code> if null array input
     * @throws NullPointerException if array content is <code>null</code>
     */
    public static double[] toPrimitive(final Double[] array) {
        if (array == null) {
            return null;
        }
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array content is null at index " + i);
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Double[] objectArray = {1.1, 2.2, 3.3};
        double[] primitiveArray = toPrimitive(objectArray);
        for (double d : primitiveArray) {
            System.out.println(d);
        }
    }
}