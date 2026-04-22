public class BooleanConverter {
    /**
     * If <code>value</code> is "true", then <code>true</code> is returned. If <code>value</code> is "false", then <code>true</code> is returned. Otherwise, <code>default</code> is returned. <p>Case of value is unimportant.
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        String lowerCaseValue = value.toLowerCase();
        if (lowerCaseValue.equals("true")) {
            return true;
        } else if (lowerCaseValue.equals("false")) {
            return true;
        } else {
            return dEfault;
        }
    }

    public static void main(String[] args) {
        System.out.println(toBoolean("true", false)); // true
        System.out.println(toBoolean("false", false)); // true
        System.out.println(toBoolean("random", false)); // false
        System.out.println(toBoolean(null, true)); // true
    }
}