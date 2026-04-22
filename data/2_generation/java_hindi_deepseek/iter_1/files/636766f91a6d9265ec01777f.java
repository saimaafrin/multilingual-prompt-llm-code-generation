public class BooleanUtils {

    /**
     * <p>एक Boolean को boolean में परिवर्तित करता है, <code>null</code> को संभालते हुए <code>false</code> लौटाता है।</p> 
     * <pre> 
     * BooleanUtils.toBoolean(Boolean.TRUE)  = true 
     * BooleanUtils.toBoolean(Boolean.FALSE) = false 
     * BooleanUtils.toBoolean(null)          = false 
     * </pre>
     * @param bool  वह boolean जिसे परिवर्तित करना है
     * @return <code>true</code> या <code>false</code>, <code>null</code> <code>false</code> लौटाता है
     */
    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(toBoolean(Boolean.TRUE));  // true
        System.out.println(toBoolean(Boolean.FALSE)); // false
        System.out.println(toBoolean(null));          // false
    }
}