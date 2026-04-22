/**
 * <p> Gets the String built by this builder. </p>
 * @return the built string
 */
public String toString() {
    // Assuming this is part of a StringBuilder-like class
    // where the internal buffer is stored in a char array.
    // Replace 'buffer' with the actual field name if different.
    return new String(buffer, 0, count);
}