import java.util.Objects;

public class ArrayUtils {

    /**
     * An empty array of type Byte.
     */
    public static final Byte[] EMPTY_BYTE_ARRAY = new Byte[0];

    /**
     * Defensive programming technique to change a {@code null} reference to an empty one.
     * This method returns an empty array for a {@code null} input array.
     * As a memory optimizing technique an empty array passed in will be overridden with the empty {@code public static} references in this class.
     *
     * @param array the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Byte[] nullToEmpty(final Byte[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        return array;
    }
}