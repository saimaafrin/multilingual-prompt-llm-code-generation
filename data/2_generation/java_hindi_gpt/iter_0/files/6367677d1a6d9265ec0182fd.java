public class BooleanConverter {

    /** 
     * यदि <code>value</code> "true" है, तो <code>true</code> लौटाया जाता है। यदि <code>value</code> "false" है, तो <code>false</code> लौटाया जाता है। अन्यथा, <code>default</code> लौटाया जाता है। <p>value का केस महत्वपूर्ण नहीं है।  
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        switch (value.toLowerCase()) {
            case "true":
                return true;
            case "false":
                return false;
            default:
                return dEfault;
        }
    }

    public static void main(String[] args) {
        System.out.println(toBoolean("true", false));  // Output: true
        System.out.println(toBoolean("false", true));  // Output: false
        System.out.println(toBoolean("other", true));   // Output: true
        System.out.println(toBoolean(null, false));      // Output: false
    }
}