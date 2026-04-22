import java.util.Objects;

public class BooleanUtils {
    
    public static boolean[] toPrimitive(Boolean[] array) {
        if (array == null) {
            return null;
        }

        final boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Objects.requireNonNull(array[i], "Array element " + i + " is null");
        }
        return result;
    }
}