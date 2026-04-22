public class BooleanConverter {

    /** 
     * Si <code>value</code> es "true", se devuelve <code>true</code>. Si <code>value</code> es "false", se devuelve <code>false</code>. De lo contrario, se devuelve <code>default</code>. <p>El caso de <code>value</code> no es importante.  
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
        System.out.println(toBoolean("other", true));  // Output: true
        System.out.println(toBoolean(null, false));     // Output: false
    }
}