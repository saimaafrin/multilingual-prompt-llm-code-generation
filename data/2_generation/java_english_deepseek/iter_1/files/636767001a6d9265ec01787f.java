import java.util.Arrays;

/**
 * Appends the details of an int array to the provided StringBuffer.
 * 
 * @param buffer    the StringBuffer to populate
 * @param fieldName the field name, typically not used as already appended
 * @param array     the array to add to the toString, not null
 */
protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
    if (array == null) {
        throw new IllegalArgumentException("Array must not be null");
    }
    buffer.append(Arrays.toString(array));
}