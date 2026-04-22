import java.util.Objects;

public class ByteArrayConverter {

    /** 
     * <p>Converts an array of object Bytes to primitives.</p> 
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  a <code>Byte</code> array, may be <code>null</code>
     * @return a <code>byte</code> array, <code>null</code> if null array input
     * @throws NullPointerException if array content is <code>null</code>
     */
    public static byte[] toPrimitive(final Byte[] array) {
        if (array == null) {
            return null;
        }
        byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array content is null at index " + i);
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        Byte[] byteArray = {1, 2, 3, null}; // This will throw NullPointerException
        byte[] primitiveArray = toPrimitive(byteArray);
    }
}