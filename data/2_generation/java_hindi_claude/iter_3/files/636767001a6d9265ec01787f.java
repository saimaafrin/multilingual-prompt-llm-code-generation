import java.util.Arrays;

public class ArrayUtils {
    
    public static void append(StringBuffer buffer, String fieldName, int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        
        buffer.append('[');
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(',');
            }
            buffer.append(array[i]);
        }
        buffer.append(']');
    }
}