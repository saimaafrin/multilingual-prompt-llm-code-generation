import java.util.Objects;

public class ArrayUtils {

    /**
     * Empty array constant to optimize memory usage.
     */
    public static final Character[] EMPTY_CHARACTER_ARRAY = new Character[0];

    /**
     * Defensive programming technique to change a {@code null} reference to an empty one.
     * This method returns an empty array for a {@code null} input array.
     * As a memory optimizing technique, an empty array passed in will be overridden with the empty {@code public static} references in this class.
     *
     * @param array the array to check for {@code null} or empty
     * @return the same array, {@code public static} empty array if {@code null} or empty input
     * @since 2.5
     */
    public static Character[] nullToEmpty(final Character[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_CHARACTER_ARRAY;
        }
        return array;
    }
}