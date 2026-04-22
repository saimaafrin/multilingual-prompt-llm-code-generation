public class ObjectUtils {

    /**
     * Gets the toString of an Object returning an empty string ("") if null input.
     * 
     * @param obj the Object to toString, may be null
     * @return the passed in Object's toString, or "" if null input
     */
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(ObjectUtils.toString(null));         // Output: ""
        System.out.println(ObjectUtils.toString(""));           // Output: ""
        System.out.println(ObjectUtils.toString("bat"));        // Output: "bat"
        System.out.println(ObjectUtils.toString(Boolean.TRUE)); // Output: "true"
    }
}