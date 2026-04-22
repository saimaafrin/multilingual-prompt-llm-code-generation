/**
 * <p> Gets the String built by this builder. </p>
 * @return the built string
 */
public String toString() {
    // Assuming this is part of a StringBuilder-like class
    // where the internal buffer is stored in a char array.
    return new String(this.buffer, 0, this.length);
}