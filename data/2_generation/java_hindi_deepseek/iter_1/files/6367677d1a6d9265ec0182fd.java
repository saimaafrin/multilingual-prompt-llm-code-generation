public class BooleanConverter {
    /**
     * यदि <code>value</code> "true" है, तो <code>true</code> लौटाया जाता है। यदि <code>value</code> "false" है, तो <code>false</code> लौटाया जाता है। अन्यथा, <code>default</code> लौटाया जाता है। <p>value का केस महत्वपूर्ण नहीं है।  
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        String lowerCaseValue = value.toLowerCase();
        if (lowerCaseValue.equals("true")) {
            return true;
        } else if (lowerCaseValue.equals("false")) {
            return false;
        } else {
            return dEfault;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(toBoolean("True", false));  // true
        System.out.println(toBoolean("FALSE", true)); // false
        System.out.println(toBoolean("random", true)); // true
        System.out.println(toBoolean(null, false));    // false
    }
}