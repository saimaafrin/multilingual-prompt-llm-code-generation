public class ObjectUtils {

    /** 
     * <p>Gets the <code>toString</code> of an <code>Object</code> returning an empty string ("") if <code>null</code> input.</p> 
     * <pre> 
     * ObjectUtils.toString(null)         = "" 
     * ObjectUtils.toString("")           = "" 
     * ObjectUtils.toString("bat")        = "bat" 
     * ObjectUtils.toString(Boolean.TRUE) = "true" 
     * </pre>
     * @see StringUtils#defaultString(String)
     * @see String#valueOf(Object)
     * @param obj  the Object to <code>toString</code>, may be null
     * @return the passed in Object's toString, or nullStr if <code>null</code> input
     * @since 2.0
     */
    public static String toString(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }

    public static void main(String[] args) {
        System.out.println(ObjectUtils.toString(null));         // Output: ""
        System.out.println(ObjectUtils.toString(""));           // Output: ""
        System.out.println(ObjectUtils.toString("bat"));        // Output: "bat"
        System.out.println(ObjectUtils.toString(Boolean.TRUE));  // Output: "true"
    }
}