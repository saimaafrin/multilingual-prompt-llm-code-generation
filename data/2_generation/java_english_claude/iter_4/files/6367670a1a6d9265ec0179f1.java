import java.util.Objects;

public class ShortUtils {
    /**
     * <p>Converts an array of primitive shorts to objects.</p>
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * 
     * @param array a <code>short</code> array
     * @return a <code>Short</code> array, <code>null</code> if null array input
     */
    public static Short[] toObject(final short[] array) {
        if (array == null) {
            return null;
        }
        
        final Short[] result = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Short.valueOf(array[i]);
        }
        return result;
    }
}