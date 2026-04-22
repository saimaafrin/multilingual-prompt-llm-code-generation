public class BooleanUtils {

    /** 
     * <p>Checks if a <code>Boolean</code> value is <i>not</i> <code>true</code>, handling <code>null</code> by returning <code>true</code>.</p> 
     * <pre> 
     *  BooleanUtils.isNotTrue(Boolean.TRUE)  = false 
     *  BooleanUtils.isNotTrue(Boolean.FALSE) = true 
     *  BooleanUtils.isNotTrue(null)          = true 
     * </pre>
     * @param bool  the boolean to check, null returns <code>true</code>
     * @return <code>true</code> if the input is null or false
     * @since 2.3
     */
    public static boolean isNotTrue(Boolean bool) {
        return bool == null || !bool;
    }

    public static void main(String[] args) {
        System.out.println(isNotTrue(Boolean.TRUE));  // Output: false
        System.out.println(isNotTrue(Boolean.FALSE)); // Output: true
        System.out.println(isNotTrue(null));          // Output: true
    }
}