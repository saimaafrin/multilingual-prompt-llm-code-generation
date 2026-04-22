public class ArrayDetailAppender {

    /**
     * <p>Append to the <code>toString</code> the detail of an <code>int</code> array.</p>
     * @param buffer  the <code>StringBuffer</code> to populate
     * @param fieldName  the field name, typically not used as already appended
     * @param array  the array to add to the <code>toString</code>, not <code>null</code>
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
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
        appender.appendDetail(buffer, "myArray", array);
        System.out.println(buffer.toString());
    }
}