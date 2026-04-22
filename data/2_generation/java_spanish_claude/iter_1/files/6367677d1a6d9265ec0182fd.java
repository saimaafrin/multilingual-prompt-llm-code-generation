public class BooleanConverter {
    /**
     * Si <code>value</code> es "true", se devuelve <code>true</code>. Si <code>value</code> es "false", se devuelve <code>false</code>. 
     * De lo contrario, se devuelve <code>default</code>.
     * El caso de <code>value</code> no es importante.
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        
        String lowercaseValue = value.toLowerCase();
        
        if (lowercaseValue.equals("true")) {
            return true;
        }
        
        if (lowercaseValue.equals("false")) {
            return false;
        }
        
        return dEfault;
    }
}