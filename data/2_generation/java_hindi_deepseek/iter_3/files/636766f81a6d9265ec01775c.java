public class ObjectUtils {

    /**
     * <p>एक <code>Object</code> का <code>toString</code> प्राप्त करता है, यदि <code>null</code> इनपुट हो तो खाली स्ट्रिंग ("") लौटाता है।</p> <pre> ObjectUtils.toString(null)         = "" ObjectUtils.toString("")           = "" ObjectUtils.toString("bat")        = "bat" ObjectUtils.toString(Boolean.TRUE) = "true" </pre>
     * @see StringUtils#defaultString(String)
     * @see String#valueOf(Object)
     * @param obj  वह Object जिसे <code>toString</code> किया जाना है, यह null हो सकता है
     * @return पास किए गए Object का toString, या nullStr यदि <code>null</code> इनपुट हो
     * @since 2.0
     */
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(ObjectUtils.toString(null));         // Output: ""
        System.out.println(ObjectUtils.toString(""));            // Output: ""
        System.out.println(ObjectUtils.toString("bat"));        // Output: "bat"
        System.out.println(ObjectUtils.toString(Boolean.TRUE));  // Output: "true"
    }
}