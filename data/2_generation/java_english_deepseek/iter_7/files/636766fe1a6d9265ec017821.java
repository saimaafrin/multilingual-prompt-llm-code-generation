import java.util.Objects;

/**
 * Appends the details of a byte array to the provided StringBuffer.
 * 
 * @param buffer    the StringBuffer to populate
 * @param fieldName the field name, typically not used as already appended
 * @param array     the array to add to the toString, not null
 */
protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
    Objects.requireNonNull(array, "The byte array must not be null");

    buffer.append('[');
    for (int i = 0; i < array.length; i++) {
        if (i > 0) {
            buffer.append(", ");
        }
        buffer.append(array[i]);
    }
    buffer.append(']');
}