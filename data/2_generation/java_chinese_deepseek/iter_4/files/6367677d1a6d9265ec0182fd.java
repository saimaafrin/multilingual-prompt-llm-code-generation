public class BooleanConverter {
    /**
     * 如果 <code>value</code> 为 "真"，则返回 <code>true</code>。如果 <code>value</code> 为 "假"，则返回 <code>false</code>。否则，返回 <code>default</code>。<p>值的大小写不重要。
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        String lowerCaseValue = value.toLowerCase();
        if (lowerCaseValue.equals("真") || lowerCaseValue.equals("true")) {
            return true;
        } else if (lowerCaseValue.equals("假") || lowerCaseValue.equals("false")) {
            return false;
        } else {
            return dEfault;
        }
    }

    public static void main(String[] args) {
        System.out.println(toBoolean("真", false)); // true
        System.out.println(toBoolean("假", true));  // false
        System.out.println(toBoolean("TRUE", false)); // true
        System.out.println(toBoolean("FALSE", true)); // false
        System.out.println(toBoolean("unknown", true)); // true
        System.out.println(toBoolean("unknown", false)); // false
    }
}