import java.util.Arrays;

public class ArrayUtils {
    
    public void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
        buffer.append(Arrays.toString(array));
    }
}