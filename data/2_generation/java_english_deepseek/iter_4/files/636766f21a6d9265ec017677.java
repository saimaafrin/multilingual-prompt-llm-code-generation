public class BooleanUtils {

    /**
     * Checks if a {@code Boolean} value is <i>not</i> {@code true}, handling {@code null} by returning {@code true}.
     * <pre>
     * BooleanUtils.isNotTrue(Boolean.TRUE)  = false
     * BooleanUtils.isNotTrue(Boolean.FALSE) = true
     * BooleanUtils.isNotTrue(null)          = true
     * </pre>
     * @param bool  the boolean to check, null returns {@code true}
     * @return {@code true} if the input is null or false
     * @since 2.3
     */
    public static boolean isNotTrue(Boolean bool) {
        return bool == null || !bool;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(isNotTrue(Boolean.TRUE));  // false
        System.out.println(isNotTrue(Boolean.FALSE)); // true
        System.out.println(isNotTrue(null));          // true
    }
}