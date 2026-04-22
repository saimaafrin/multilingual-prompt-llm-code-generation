public class StringUtils {

    /** 
     * <p>Verifica si una cadena termina con un sufijo especificado (opcionalmente sin distinguir entre mayúsculas y minúsculas).</p>
     * @see String#endsWith(String)
     * @param str  la cadena a verificar, puede ser nula
     * @param suffix el sufijo a encontrar, puede ser nulo
     * @param ignoreCase indica si la comparación debe ignorar las mayúsculas y minúsculas (sin distinguir entre mayúsculas y minúsculas) o no.
     * @return <code>true</code> si la cadena termina con el sufijo o ambos son <code>null</code>
     */
    private static boolean endsWith(final String str, final String suffix, final boolean ignoreCase) {
        if (str == null && suffix == null) {
            return true;
        }
        if (str == null || suffix == null) {
            return false;
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        String strEnd = str.substring(str.length() - suffix.length());
        return ignoreCase ? strEnd.equalsIgnoreCase(suffix) : strEnd.equals(suffix);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(endsWith("HelloWorld", "World", false)); // true
        System.out.println(endsWith("HelloWorld", "world", true));  // true
        System.out.println(endsWith("HelloWorld", "Hello", false)); // false
        System.out.println(endsWith(null, null, false));             // true
        System.out.println(endsWith(null, "suffix", false));         // false
    }
}