public class CharUtils {

    /**
     * Converts the Character to a char handling null.
     * <pre>
     * CharUtils.toChar(null, 'X') = 'X'
     * CharUtils.toChar(' ', 'X')  = ' '
     * CharUtils.toChar('A', 'X')  = 'A'
     * </pre>
     * @param ch  the character to convert
     * @param defaultValue  the value to use if the Character is null
     * @return the char value of the Character or the default if null
     */
    public static char toChar(final Character ch, final char defaultValue) {
        return ch != null ? ch : defaultValue;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(toChar(null, 'X')); // Output: X
        System.out.println(toChar(' ', 'X'));  // Output:  
        System.out.println(toChar('A', 'X'));  // Output: A
    }
}