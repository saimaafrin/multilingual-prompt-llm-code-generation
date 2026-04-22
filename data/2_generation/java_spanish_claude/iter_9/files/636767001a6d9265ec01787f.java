import java.util.Arrays;

public class ToStringBuilder {

    protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        buffer.append(Arrays.toString(array));
    }
}