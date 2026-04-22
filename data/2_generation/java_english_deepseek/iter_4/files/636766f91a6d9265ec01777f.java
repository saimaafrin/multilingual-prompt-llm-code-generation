public class BooleanUtils {

    /**
     * <p>Converts a Boolean to a boolean handling <code>null</code> by returning <code>false</code>.</p>
     * <pre>
     * BooleanUtils.toBoolean(Boolean.TRUE)  = true
     * BooleanUtils.toBoolean(Boolean.FALSE) = false
     * BooleanUtils.toBoolean(null)          = false
     * </pre>
     * @param bool  the boolean to convert
     * @return <code>true</code> or <code>false</code>, <code>null</code> returns <code>false</code>
     */
    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool;
    }

    public static void main(String[] args) {
        System.out.println(toBoolean(Boolean.TRUE));  // Output: true
        System.out.println(toBoolean(Boolean.FALSE)); // Output: false
        System.out.println(toBoolean(null));          // Output: false
    }
}