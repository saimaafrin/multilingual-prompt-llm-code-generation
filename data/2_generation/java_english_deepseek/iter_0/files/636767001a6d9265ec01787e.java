/**
 * <p> Gets the String built by this builder. </p>
 * @return the built string
 */
public String toString() {
    // Assuming this is part of a StringBuilder-like class
    // and the internal buffer is stored in a char array.
    return new String(buffer, 0, count);
}

// Assuming the following fields are part of the class:
// private char[] buffer;
// private int count;