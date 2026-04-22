import java.util.Objects;

public class CharacterUtils {

    /**
     * <p>Converts an array of object Characters to primitives.</p> <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     * @param array  a <code>Character</code> array, may be <code>null</code>
     * @return a <code>char</code> array, <code>null</code> if null array input
     * @throws NullPointerException if array content is <code>null</code>
     */
    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        }
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Objects.requireNonNull(array[i], "Array element cannot be null");
        }
        return result;
    }
}