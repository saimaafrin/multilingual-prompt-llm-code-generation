import java.util.Arrays;

public class ArrayToStringHelper {

    /**
     * <p>将一个 <code>int</code> 数组的详细信息附加到 <code>toString</code> 中。</p>
     * @param buffer  要填充的 <code>StringBuffer</code>
     * @param fieldName  字段名称，通常不使用，因为已经附加
     * @param array  要添加到 <code>toString</code> 的数组，不能为 <code>null</code>
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        buffer.append(Arrays.toString(array));
    }

    public static void main(String[] args) {
        ArrayToStringHelper helper = new ArrayToStringHelper();
        StringBuffer buffer = new StringBuffer();
        int[] array = {1, 2, 3, 4, 5};
        helper.appendDetail(buffer, "array", array);
        System.out.println(buffer.toString());  // 输出: [1, 2, 3, 4, 5]
    }
}