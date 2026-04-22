import java.util.Objects;

public class DoubleArrayConverter {

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
        Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        double[] primitiveArray = {1.0, 2.0, 3.0};
        Double[] objectArray = toObject(primitiveArray);
        System.out.println(java.util.Arrays.toString(objectArray)); // Output: [1.0, 2.0, 3.0]

        double[] nullArray = null;
        Double[] nullObjectArray = toObject(nullArray);
        System.out.println(Objects.isNull(nullObjectArray)); // Output: true
    }
}