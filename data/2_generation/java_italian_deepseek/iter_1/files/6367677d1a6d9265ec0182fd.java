public class BooleanConverter {
    /**
     * Se <code>value</code> è "true", viene restituito <code>true</code>. Se <code>value</code> è "false", viene restituito <code>false</code>. Altrimenti, viene restituito <code>default</code>. <p> Non importa se <code>value</code> è maiuscolo o minuscolo.
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
        System.out.println(toBoolean("true", false));  // true
        System.out.println(toBoolean("FALSE", true));  // false
        System.out.println(toBoolean("random", true)); // true
        System.out.println(toBoolean(null, false));     // false
    }
}