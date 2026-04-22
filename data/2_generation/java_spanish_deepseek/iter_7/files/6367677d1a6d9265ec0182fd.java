public class BooleanConverter {
    /**
     * Si <code>value</code> es "true", se devuelve <code>true</code>. Si <code>value</code> es "false", se devuelve <code>false</code>. De lo contrario, se devuelve <code>default</code>. <p>El caso de <code>value</code> no es importante.
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
        // Ejemplos de uso
        System.out.println(toBoolean("true", false));  // true
        System.out.println(toBoolean("FALSE", true));   // false
        System.out.println(toBoolean("random", true)); // true
        System.out.println(toBoolean(null, false));     // false
    }
}