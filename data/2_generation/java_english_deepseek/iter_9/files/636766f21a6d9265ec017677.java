public class BooleanUtils {

    /**
     * Checks if a Boolean value is not true, handling null by returning true.
     * 
     * @param bool the boolean to check, null returns true
     * @return true if the input is null or false
     * @since 2.3
     */
    public static boolean isNotTrue(Boolean bool) {
        return bool == null || !bool;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(isNotTrue(Boolean.TRUE));   // false
        System.out.println(isNotTrue(Boolean.FALSE)); // true
        System.out.println(isNotTrue(null));           // true
    }
}