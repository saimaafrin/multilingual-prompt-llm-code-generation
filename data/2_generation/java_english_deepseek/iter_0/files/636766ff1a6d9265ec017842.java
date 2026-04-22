import java.util.Objects;

public class DoubleArrayConverter {

    /**
     * <p>Converts an array of object Doubles to primitives.</p> 
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
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
            Objects.requireNonNull(array[i], "Array element cannot be null");
            result[i] = array[i];
        }
        return result;
    }
}