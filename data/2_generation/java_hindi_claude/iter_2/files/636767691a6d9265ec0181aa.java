import java.util.Arrays;

public class ArrayHashCode {
    /**
     * Return a hash code based on the contents of the specified array. If <code>array</code> is <code>null</code>, this method returns 0.
     * @param array the long array to obtain a hashcode
     * @return the long array's hashcode, which could be 0 if the array is null.
     */
    public static int hashCode(long[] array) {
        if (array == null) {
            return 0;
        }
        return Arrays.hashCode(array);
    }
}