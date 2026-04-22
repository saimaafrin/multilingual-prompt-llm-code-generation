import java.util.Arrays;

/**
 * <p>Append to the <code>toString</code> the detail of a <code>byte</code> array.</p>
 * @param buffer  the <code>StringBuffer</code> to populate
 * @param fieldName  the field name, typically not used as already appended
 * @param array  the array to add to the <code>toString</code>, not <code>null</code>
 */
protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
    if (array == null) {
        throw new IllegalArgumentException("The array must not be null");
    }
    buffer.append(Arrays.toString(array));
}