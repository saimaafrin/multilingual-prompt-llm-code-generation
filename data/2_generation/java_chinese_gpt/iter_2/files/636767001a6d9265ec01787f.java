public class ArrayDetailAppender {

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
        buffer.append(fieldName).append(": [");
        for (int i = 0; i < array.length; i++) {
            buffer.append(array[i]);
            if (i < array.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append("]");
    }

    public static void main(String[] args) {
        ArrayDetailAppender appender = new ArrayDetailAppender();
        StringBuffer buffer = new StringBuffer();
        int[] array = {1, 2, 3, 4, 5};
        appender.appendDetail(buffer, "MyArray", array);
        System.out.println(buffer.toString());
    }
}