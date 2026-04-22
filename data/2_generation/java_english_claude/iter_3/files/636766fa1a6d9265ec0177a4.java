import java.util.Objects;

public class ArrayConverter {
    /**
     * <p>Converts an array of primitive doubles to objects.</p>
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  a <code>double</code> array
     * @return a <code>Double</code> array, <code>null</code> if null array input
     */
    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        }
        
        final Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Double.valueOf(array[i]);
        }
        return result;
    }
}