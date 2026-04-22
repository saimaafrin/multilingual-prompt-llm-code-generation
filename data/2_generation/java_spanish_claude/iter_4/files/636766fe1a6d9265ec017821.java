import java.util.Arrays;

public class ToStringBuilder {

    protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
        buffer.append(Arrays.toString(array));
    }

}