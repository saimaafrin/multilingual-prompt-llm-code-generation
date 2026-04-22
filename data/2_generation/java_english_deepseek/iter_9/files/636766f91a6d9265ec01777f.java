public class BooleanUtils {

    /**
     * Converts a Boolean to a boolean handling null by returning false.
     * 
     * @param bool the boolean to convert
     * @return true or false, null returns false
     */
    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(toBoolean(Boolean.TRUE));  // Output: true
        System.out.println(toBoolean(Boolean.FALSE)); // Output: false
        System.out.println(toBoolean(null));         // Output: false
    }
}