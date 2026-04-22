public class BooleanConverter {
    /** 
     * Se <code>value</code> è "true", viene restituito <code>true</code>. Se <code>value</code> è "false", viene restituito <code>false</code>. Altrimenti, viene restituito <code>default</code>. <p> Non importa se <code>value</code> è maiuscolo o minuscolo. 
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        value = value.trim().toLowerCase();
        if (value.equals("true")) {
            return true;
        } else if (value.equals("false")) {
            return false;
        } else {
            return dEfault;
        }
    }

    public static void main(String[] args) {
        System.out.println(toBoolean("true", false));  // Output: true
        System.out.println(toBoolean("false", true));  // Output: false
        System.out.println(toBoolean("other", true));  // Output: true
        System.out.println(toBoolean(null, false));     // Output: false
    }
}