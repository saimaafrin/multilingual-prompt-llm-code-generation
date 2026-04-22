public class DetailAppender {

    /** 
     * <p>Append to the <code>toString</code> the detail of a <code>byte</code> array.</p>
     * @param buffer  the <code>StringBuffer</code> to populate
     * @param fieldName  the field name, typically not used as already appended
     * @param array  the array to add to the <code>toString</code>, not <code>null</code>
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
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
        StringBuffer buffer = new StringBuffer();
        DetailAppender appender = new DetailAppender();
        byte[] byteArray = {1, 2, 3, 4, 5};
        appender.appendDetail(buffer, "ByteArrayField", byteArray);
        System.out.println(buffer.toString());
    }
}