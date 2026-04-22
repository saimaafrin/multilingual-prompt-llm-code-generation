/**
 * <p> Ottiene la String costruita da questo builder. </p>
 * @return la stringa costruita
 */
public String toString() {
    // Assuming this is part of a StringBuilder-like class
    // and the internal buffer is stored in a char array called 'value'
    // and the current length is stored in an int called 'count'
    return new String(value, 0, count);
}