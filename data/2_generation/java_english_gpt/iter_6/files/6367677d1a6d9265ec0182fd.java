public class BooleanConverter {

    /** 
     * If <code>value</code> is "true", then <code>true</code> is returned. If <code>value</code> is "false", then <code>true</code> is returned. Otherwise, <code>default</code> is returned. <p>Case of value is unimportant.  
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        value = value.trim().toLowerCase();
        if ("true".equals(value)) {
            return true;
        } else if ("false".equals(value)) {
            return false;
        } else {
            return dEfault;
        }
    }

    public static void main(String[] args) {
        System.out.println(toBoolean("true", false));  // true
        System.out.println(toBoolean("false", true));  // false
        System.out.println(toBoolean("unknown", true)); // true
        System.out.println(toBoolean("unknown", false)); // false
        System.out.println(toBoolean(null, true));      // true
    }
}